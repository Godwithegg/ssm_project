package com.danhuang.crud.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.danhuang.crud.bean.Department;
import com.danhuang.crud.bean.Employee;
import com.danhuang.crud.dao.DepartmentMapper;
import com.danhuang.crud.dao.EmployeeMapper;

/**
 * 测试dao层的工作
 * @author Administrator
 * 推荐Spring的项目可以使用Spring的单元测试，可以自动注入我们需要的组建
 * 导入SpringTest模块
 * 直接Autowired
 * @ContextConfiguration制定spring配置文件的位置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	
	@Autowired
	DepartmentMapper departmentMapper;
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	/**
	 * 测试departmentmapper
	 */
	@Test
	public void testCRUD(){
//		//1.创建SpringIOC容器
//		ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
//		//2.从容器中取得mapper
//		ioc.getBean(DepartmentMapper.class);
		
		//System.out.println(departmentMapper);
		
//		//1.插入几个部门
//		departmentMapper.insertSelective(new Department(null,"开发部"));
//		departmentMapper.insertSelective(new Department(null,"测试部"));
//		
//		//2.生成员工数据，测试员工插入
//		employeeMapper.insertSelective(new Employee(null,"Jerry","M","Jerry@qq.com",1));
	
		//3.批量插入多个,批量：使用可以执行批量操作的sqlSession
		/*
		for(){
			employeeMapper.insertSelective(new Employee(null,"Jerry","M","Jerry@qq.com",1));
		}
		 */
		
		//批处理，配置在applicationContext中
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		for(int i = 0 ; i < 1000 ; i ++){
			String uid = UUID.randomUUID().toString().substring(0, 5) + i;
			mapper.insertSelective(new Employee(null,uid,"M", uid + "@danhuang.com",1));
		}
		System.out.println("执行成功");
		
	}
}
