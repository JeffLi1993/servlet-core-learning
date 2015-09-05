package org.servlet.async;

import java.util.Date;

import javax.servlet.AsyncContext;
import javax.servlet.ServletRequest;

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
public class AsyncThread implements Runnable {

	// 异步上下文
	private AsyncContext asyncContext = null;
	
	public AsyncThread(AsyncContext asyncContext) {
		this.asyncContext = asyncContext;
	}

	@Override
	public void run() {
		try {
			// 开始时间
			Date startDate = new Date();
			// 暂停5秒
			Thread.sleep(5 * 1000);
			// 开始时间
			Date endDate = new Date();
						
			// 从异步上下文获取请求对象
			ServletRequest request = asyncContext.getRequest();
			request.setAttribute("name", "BYSocket");
			request.setAttribute("startDate", startDate);
			request.setAttribute("endDate", endDate);
			asyncContext.dispatch("/async/asyncThread.jsp");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
