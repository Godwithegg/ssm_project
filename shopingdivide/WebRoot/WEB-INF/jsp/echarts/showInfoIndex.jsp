<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<html lang="zh-CN">
<head>
<link rel="shortcut icon" href="img/fac.ico" />
<link rel="bookmark" href="img/fac.ico" />
<title>- 观测数据 -</title>
</head>


<script type="text/javascript" src="static/echarts/jquery-1.8.3.js"></script>
<script type="text/javascript" src="static/echarts/echarts.js"></script>

<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<style type="text/css">
.mybody {
	background: url('img/echartgrund.png');
}
</style>
<body class="mybody">
	<br>
	<br>
	<nav role="navigation">
		<!-- 显示Echarts图表 -->
		<div id="main" style="height: 410px; min-height: 100px; margin: 0 auto;"></div>


		<a href="${pageContext.request.contextPath }/crop/queryStatus.action"
			class="btn btn-info" style="text: center">返回</a>
	</nav>



	<script type="text/javascript">
		// 基于准备好的dom，初始化echarts实例
		var myChart = echarts.init(document.getElementById('main'));

		// 指定图表的配置项和数据
		var option = {
			title : { //图表标题
				text : '商品数据图表'
			},
			tooltip : {
				trigger : 'axis', //坐标轴触发提示框，多用于柱状、折线图中
				/*
				控制提示框内容输出格式*/
				formatter : '{b0}<br/><font color=#FF3333>&nbsp;●&nbsp;</font>{a0} : {c0} 元 '
						+ '<br/><font color=#53FF53>●&nbsp;</font>{a1} : {c1} 份 '
			},
			dataZoom : [ {
				type : 'slider', //支持鼠标滚轮缩放
				start : 0, //默认数据初始缩放范围为10%到90%
				end : 100
			}, {
				type : 'inside', //支持单独的滑动条缩放
				start : 0, //默认数据初始缩放范围为10%到90%
				end : 100
			} ],
			legend : { //图表上方的类别显示           	
				show : true,
				data : [ '价格（元）', '总量（份）', '销售量（份）' ]
			},
			color : [ '#FF3333', //价格曲线颜色
			'#53FF53', //总量曲线颜色
			'#B15BFF' //销售量图颜色

			],
			toolbox : {
				feature : {
					dataView : {
						show : true,
						readOnly : false
					},
					magicType : {
						show : true,
						type : [ 'line', 'bar' ]
					},
					restore : {
						show : true
					},
					saveAsImage : {
						show : true
					}
				}
			},
			xAxis : { //X轴       	
				type : 'category',
				data : []
			//先设置数据值为空，后面用Ajax获取动态数据填入
			},
			yAxis : [ //Y轴（这里我设置了两个Y轴，左右各一个）
			{
				//第一个（左边）Y轴，yAxisIndex为0
				type : 'value',
				name : '价格',
				/* max: 120,
				min: -40, */
				axisLabel : {
					formatter : '{value} 元' //控制输出格式
				}
			}, {
				//第二个（右边）Y轴，yAxisIndex为1
				type : 'value',
				name : '总量',
				//额外添加6.28
				//max:120,
				min:0,
				//额外添加6.28
				scale : true,
				axisLabel : {
					formatter : '{value} 份'
				}
			}

			],
			series : [ //系列（内容）列表                      
			{
				name : '价格（元）',
				type : 'line', //折线图表示（生成价格曲线）
				symbol : 'emptycircle', //设置折线图中表示每个坐标点的符号；emptycircle：空心圆；emptyrect：空心矩形；circle：实心圆；emptydiamond：菱形	                    
				data : []
			//数据值通过Ajax动态获取
			},

			{
				name : '总量（份）',
				type : 'line',
				symbol : 'emptyrect',
				yAxisIndex : 1,//与第二y轴有关
				data : []
			}]
		};
		myChart.showLoading(); //数据加载完之前先显示一段简单的loading动画

		var tems = []; //价格数组（存放服务器返回的所有价格值）
		var hums = []; //总量数组
		var names = [];

		$.ajax({ //使用JQuery内置的Ajax方法
			type : "post", //post请求方式
			async : true, //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
			url : "echarts/record.action", //请求发送到ShowInfoIndexServlet处
			data : {
				name : "商品"  //$(statusCustom)"
			}, //请求内包含一个key为name，value为A0001的参数；服务器接收到客户端请求时通过request.getParameter方法获取该参数值
			dataType : "json", //返回数据形式为json
			success : function(result) {
				//请求成功时执行该函数内容，result即为服务器返回的json对象
				if (result != null && result.length > 0) {
					for (var i = 0; i < result.length; i++) {
						names.push(result[i].name);
						tems.push(result[i].price); //挨个取出价格、总量、销售量等值并填入前面声明的价格、总量、销售量等数组
						hums.push(result[i].total);
		
					}
					myChart.hideLoading(); //隐藏加载动画

					myChart.setOption({ //载入数据
						xAxis : {
							data : names
						//填入X轴数据
						},
						series : [ //填入系列（内容）数据
						{
							// 根据名字对应到相应的系列
							name : '价格',
							data : tems
						}, {
							name : '总量',
							data : hums
						} ]
					});

				} else {
					//返回的数据为空时显示提示信息
					alert("图表请求数据为空，可能服务器暂未录入近五天的观测数据，您可以稍后再试！");
					myChart.hideLoading();
				}

			},
			error : function(errorMsg) {
				//请求失败时执行该函数
				alert("图表请求数据失败，可能是服务器开小差了");
				myChart.hideLoading();
			}
		})

		myChart.setOption(option); //载入图表
	</script>
</body>
</html>