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
 * @since 2015-7-12 10:58:28
 * 	HttpSession的默认Cookie实现案例
 */
@WebServlet(urlPatterns = "/sessionByCookie")
public class HttpSessionByCookieServletT extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		// 获取session
		// 如果是第一次请求的话，会创建一个HttpSeesion，等同于 req.getSession(true);
		// 如果已存在session，则会获取session。
		HttpSession session = req.getSession();
		
		if (session.isNew()) {
			// 设置session属性值	
			session.setAttribute("name", "Jeff");
		}
		// 获取SessionId
		String sessionId = session.getId();
		
		PrintWriter out = resp.getWriter();
		// 如果HttpSeesion是新建的话
		if (session.isNew()) {
			out.println("Hello,HttpSession! <br>The first response - SeesionId=" 
					+ sessionId + " <br>");
		} else {
			out.println("Hello,HttpSession! <br>The second response - SeesionId=" 
					+ sessionId + " <br>");
			// 从Session获取属性值
			out.println("The second-response - name: " 
					+ session.getAttribute("name"));
		}
		
	}
	
}
