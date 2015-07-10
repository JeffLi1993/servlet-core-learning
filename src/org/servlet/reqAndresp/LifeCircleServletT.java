package org.servlet.reqAndresp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
 * @since 2015-7-10 21:40:41
 * 	Servlet生命周期演示案例
 */
@WebServlet(urlPatterns = "/lifeCircle")
public class LifeCircleServletT extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;");
		resp.setCharacterEncoding("UTF-8");
		resp.setHeader("content-type","text/html;charset=UTF-8");
		
		System.out.println("Servlet 执行了。");
		resp.getWriter().println("Servlet生命周期案例。<br> Servlet 执行了！");
	}

	@Override
	public void destroy() {
		System.out.println("Servlet 被卸载了！");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Servlet 初始化了！\t（初始化只有一次，Servlet是单例的。）ps:不信可再次访问。");
	}

	
}
