package org.servlet.sessionMngmt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * Copyright [2015] [Jeff Lee]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author Jeff Lee
 * @since 2015-6-25 19:46:45
 * 	HttpSession的详细案例
 */
@WebServlet(urlPatterns = "/sessionMethods")
public class HttpSessionMethodsServletT extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		resp.setContentType("text/html;");
		resp.setCharacterEncoding("UTF-8");
		resp.setHeader("content-type","text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		// 从请求中获取Session
		HttpSession session = req.getSession();
		// 绑定对象到Session
		session.setAttribute("sessionName", "sessionValue");
		
		// 返回第一次创建Session的时间
		out.println("创建会话时间：" + session.getCreationTime() + "<br>");
		// 返回离最近一次会话操作的间隔
		out.println("离最近一次会话操作的间隔：" + session.getLastAccessedTime() + "<br>");
		// 设置会话最大时间间隔
		session.setMaxInactiveInterval(10 * 60); // 10分钟，默认20分钟
		// 返回会话最大时间间隔
		out.println("会话最大时间间隔：" + session.getMaxInactiveInterval() + "<br>");
		
		// 结束会话
		//session.invalidate();
		//session.setMaxInactiveInterval(0);
	}
	
	
}
