package com.danhuang.crud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.danhuang.crud.bean.Employee;
import com.danhuang.crud.bean.Msg;
import com.danhuang.crud.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/*
 * 处理员工CRUD请求
 */
@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	/**
	 * 单个批量二合一
	 * 批量删除，1-2-3
	 * 单个删除：1
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/emp/{ids}",method=RequestMethod.DELETE)
	public Msg deleteEmp(@PathVariable("ids")String ids){
		//批量删除
		if(ids.contains("-")){
			List<Integer> del_ids = new ArrayList<>();
			String[] str_ids = ids.split("-");
			//组装id的集合
			for (String string : str_ids) {
				del_ids.add(Integer.parseInt(string));
			}
			employeeService.deleteBatch(del_ids);
		}else{
			Integer id = Integer.parseInt(ids);
			employeeService.deleteEmp(id);
		}
		return Msg.success();
	}
	
	//@ResponseBody
	//@RequestMapping(value="/emp/{id}",method=RequestMethod.DELETE)
	public Msg deleteEmpById(@PathVariable("id")Integer id){
		employeeService.deleteEmp(id);
		return Msg.success();
	}
	
	/**
	 * 如果直接发送ajax=put形式的请求就会是除id之外全空
	 * 原因：
	 * tomcat问题：
	 * 	将请求体中的数据，封装一个map，
	 * 	request.getParameter("empName")就会从这个map中取值。
	 * 	SpringMvc封装数据的PoJo的时候会把PoJo中每个属性的值调用request.getParamter("email")得到
	 *AJAX
	 *	put请求，请求体重，request.getParameter("email")的数据都拿不到
	 *	tomcat一看是put不会封装请求体中的数据为map，只有post形式的请求才封装请求体为map
	 * org.apache.catalina.connector.Request--parseParameters() (3111);
	 * 
	 * protected String parseBodyMethods = "POST";
	 * if( !getConnector().isParseBodyMethod(getMethod()) ) {
                success = true;
                return;
            }
	 * 员工更新
	 * 解决方案；
	 * 我们要能支持直接发送PUT之类的请求还要封装请求体中的数据
	 * 1、配置上HttpPutFormContentFilter；
	 * 2、他的作用；将请求体中的数据解析包装成一个map。
	 * 3、request被重新包装，request.getParameter()被重写，就会从自己封装的map中取数据
	 * 员工更新方法
	 * @param employee
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/emp/{empId}",method=RequestMethod.PUT)
	public Msg saveEmp(Employee employee,HttpServletRequest request){
		System.out.println("请求体中的值"+request.getParameter("gender"));;
		System.out.println("将要更新的员工数据:"+employee);
		employeeService.updateEmp(employee);
		return Msg.success();
	}
	
	/**
	 * 根据id查询员工
	 * @param id
	 * @return
	 */
	
	@RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Msg getEmp(@PathVariable("id") Integer id){
		Employee employee = employeeService.getEmp(id);
		System.out.println(employee);
		return Msg.success().add("emp", employee);
	}
	
	/**
	 * 员工保存
	 * 1.支持JSR303校验
	 * 2.导入Hibernate--Validator
	 * @param employee
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	public Msg saveEmp(@Valid Employee employee,BindingResult result){
		if(result.hasErrors()){
			//校验失败应该返回失败，在模态框中显示校验失败的错误信息
			Map<String, Object> map = new HashMap<>();
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError fieldError : errors) {
				System.out.println("错误的字段名:"+fieldError.getField());
				System.out.println("错误信息:"+fieldError.getDefaultMessage());
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return Msg.fail().add("errorFields", map);
		}else{			
			employeeService.saveEmp(employee);
			return Msg.success();
		}
	}
	
	/**
	 * 检查用户名是否可用
	 * @param empName
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/checkuser")
	public Msg checkuser(@RequestParam("empName")String empName){
		//先判断用户名是否是合法的表达式
		String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
		if(!empName.matches(regx)){
			return Msg.fail().add("va_msg", "用户名必须是6-16位数字和字母的组合或者2-5位中文");
		}
		
		//数据库用户名重复校验
		boolean b = employeeService.checkUser(empName);
		if(b){
			return Msg.success();
		}else{
			return Msg.fail().add("va_msg", "用户名不可用");
		}
	}
	
	/**
	 * 导入jackson包
	 * @param pn
	 * @param model
	 * @return
	 */
	@RequestMapping("/emps")
	@ResponseBody
	public Msg getEmpsWithJson(@RequestParam(value="pn",defaultValue="1") Integer pn){
		//这不是一个分页查询
		//引入PageHelper分页插件
		//在查询之前只需要调用,插入页码，以及每页的大小
		//stratPage后面紧跟的这个查询就是一个分页查询
		PageHelper.startPage(pn,5);
		List<Employee> emps = employeeService.getAll();
		//使用pageInfo包装查询后的结果，只需要将pageinfo交给页面就行了。
		//封装了详细的分页信息，包括有我们查询出来的数据,传入连续显示的页数
		PageInfo page = new PageInfo(emps,5);
		
		return Msg.success().add("pageInfo",page);
	}
	
	/**
	 * 查询员工数据(分页查询)
	 * @return
	 */
//	@RequestMapping("/emps")
	public String getEmps(@RequestParam(value="pn",defaultValue="1") Integer pn,Model model){
		//这不是一个分页查询
		//引入PageHelper分页插件
		//在查询之前只需要调用,插入页码，以及每页的大小
		//stratPage后面紧跟的这个查询就是一个分页查询
		PageHelper.startPage(pn,5);
		List<Employee> emps = employeeService.getAll();
		//使用pageInfo包装查询后的结果，只需要将pageinfo交给页面就行了。
		//封装了详细的分页信息，包括有我们查询出来的数据,传入连续显示的页数
		PageInfo page = new PageInfo(emps,5);
		model.addAttribute("pageInfo",page);
		
		return "list";
	}
}
