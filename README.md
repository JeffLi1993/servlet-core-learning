# servlet-core-learning
Servlet/JSP学习积累的例子，是Java EE初学者及Servlet/JSP核心技术巩固的最佳实践。<br>
补充：还有Tomcat容器相关

## 作者与学习乐园
源码地址:我的[GitHub地址](https://github.com/JeffLi1993 "GitHub")<br>
作者： [李强强](http://www.bysocket.com/ "李强强")<br>
QQ群：编程之美 365234583 [立即加入](http://jq.qq.com/?_wv=1027&k=Sx4s4U "编程之美")

## 项目结构
- src 目录<br>
Servlet/JSP核心技术学习代码兼测试案例<br>
- test目录(测试包名与src目录保持一致)<br>
对应学习代码包的详细测试案例<br>

包目录：

	├── 插件
	├── org.component					// 插件相关
	├── Servlet JSP
	├── org.jsp						// jsp相关
	├── org.servlet					// Servlet相关
	├── org.servlet.async				// 异步调用
	├── org.servlet.reqAndresp		// 请求与响应
	├── org.servlet.sessionMngmt		// 会话管理
	├── Tomcat 
	├── org.tomcat					// tomcat相关
	│
	拼命更新！顶！d=====(￣▽￣*)b

插件相关详细目录：

	├── README.md						// 项目唯一详细文档
	├── org.component					// 插件相关
	├── org.component.uploadfile		// 插件-文件上传下载
	├── 	UploadServlet.java				// 	文件上传类
	拼命更新！顶！d=====(￣▽￣*)b

Servlet/Jsp相关详细目录：

	├── README.md								// 项目唯一详细文档
	├── org.jsp							// jsp相关
	├── 	Counter.java						// 	page指令之计数器累加器
	├── org.servlet						// Servlet相关
	├── 	HttpServletService.java				// 	HttpServlet的service方法实现
	├── org.servlet.async					// 异步调用
	├── 	AsyncServlet.java					// 	Servlet3.0提供的异步处理案例
	├── 	AsyncThread.java					// 	Servlet3.0提供的异步处理案例
	├── org.servlet.reqAndresp			// 请求与响应
	├── 	HelloWorldServletT.java				// 	HelloWrold案例
	├── 	LifeCircleServletT.java				// 	Servlet生命周期演示案例
	├── 	SuperServiceServletT.java			// 	super.service测试案例
	├── org.servlet.sessionMngmt			// 会话管理
	├── 	HttpSessionByCookieServletT.java	// HttpSession的默认Cookie实现案例
	├── 	HttpSessionMethodsServletT.java		// HttpSession的详细案例
	├── 	HttpSessionServletT.java			// HttpSession简单案例
	拼命更新！顶！d=====(￣▽￣*)b

Tomcat相关详细目录：

	├── README.md							// 项目唯一详细文档
	├── org.tomcat.jsp.jasper				// Japser引擎
	├── 	JspCompilerT.java					// 	Jasper引擎编译JSP
	拼命更新！顶！d=====(￣▽￣*)b

WebContent相关详细目录：

	├── README.md							// 项目唯一详细文档
	├── /component						// 插件相关
	├── /component/uploadfile				// 文件上传下载
	├── 	upload.jsp							// 文件上传JSP
	├── /async							// 异步调用
	├── 	asyncThread.jsp						// 异步调用JSP	
	├── counter.jsp							// page指令之计数器累加器显示JSP
	├── jspC.jsp								// 	Jasper引擎编译JSP所需的JSP
	拼命更新！顶！d=====(￣▽￣*)b

