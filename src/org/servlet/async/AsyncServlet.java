package org.servlet.async;

import java.io.IOException;
import java.util.Date;

import javax.servlet.AsyncContext;
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
 * @since 2015-9-3 20:30:19
 * 	Servlet 3.0提供的异步处理
 * 		通过AsyncContext类实现，该对象从请求Request的startAsync方法获取。
 */
@WebServlet(urlPatterns="/async",asyncSupported=true)// 开始异步调用
public class AsyncServlet extends HttpServlet {
	
	private static final long serialVersionUID = -6795872120748178723L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException,IOException {
		resp.setContentType("text/html;charset=UTF-8");
		Date startDate = new Date();
		System.out.println("Servlet当前时间 --- " + startDate );
		
		// 从请求中获取AsyncContext
		AsyncContext asyncContext = req.startAsync();
		// 设置异步调用的超时时长
		asyncContext.setTimeout(30*1000);// 30秒
		// 开始异步调用
		asyncContext.start(new AsyncThread(asyncContext));
		
		Date endDate = new Date();
		System.out.println("Servlet结束时间 --- " + endDate);
		
		// startDate和endDate时间差不多相等。
		// 说明Servlet重新发起了一条线程去掉用耗时业务方法，避免了阻塞式调用
	}
}
