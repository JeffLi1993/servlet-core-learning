package org.servlet;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
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
 * @since 2015-9-3 19:30:56
 * 	HttpServlet的service方法实现
 */
public class HttpServletService extends HttpServlet{
	private static final long serialVersionUID = -5630942344912714108L;
	
    private static final String METHOD_DELETE = "DELETE";
    private static final String METHOD_HEAD = "HEAD";
    private static final String METHOD_GET = "GET";
    private static final String METHOD_OPTIONS = "OPTIONS";
    private static final String METHOD_POST = "POST";
    private static final String METHOD_PUT = "PUT";
    private static final String METHOD_TRACE = "TRACE";

    private static final String HEADER_IFMODSINCE = "If-Modified-Since";

    private static final String LSTRING_FILE =
            "javax.servlet.http.LocalStrings";
    private static ResourceBundle lStrings =
            ResourceBundle.getBundle(LSTRING_FILE);
    /**
     * HTTP状态码304
     */
    public static final int SC_NOT_MODIFIED = 304;
    
	/**
	 * 接收来自 public service方法的标准HTTP请求，
	 * 并将它们分发给此类中定义的doXXX方法。
	 */
	@SuppressWarnings("unused")
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// 获取请求方法名
		String method = req.getMethod();
		// 如果是GET请求
		if (method.equals(METHOD_GET)) {
			// 上一次修改HttpServletRequest对象的时间
			long lastModified = getLastModified(req);
			// 没有改变
			if (lastModified == -1) {
				doGet(req, resp);
			} else {
				long ifModifiedSince;
				try {
					// 获取请求头中服务器修改时间
					ifModifiedSince = req.getDateHeader(HEADER_IFMODSINCE);
				} catch (IllegalArgumentException iae) {
					// 获取无效
					ifModifiedSince = -1;
				}
				// 如果请求头服务器修改时间迟
				if (ifModifiedSince < (lastModified / 1000 * 1000)) {
					// 设置修改HttpServletResponse对象的时间,重新设置浏览器的参数
                  //maybeSetLastModified(resp, lastModified);
					// 调用doGet方法
                    doGet(req, resp);
				} else {
					// 304 HTTP状态码
					resp.setStatus(SC_NOT_MODIFIED);
				}
			}
		} else if (method.equals(METHOD_HEAD)) {
            long lastModified = getLastModified(req);
          //maybeSetLastModified(resp, lastModified);
            doHead(req, resp);
        } else if (method.equals(METHOD_POST)) {
            doPost(req, resp);
        } else if (method.equals(METHOD_PUT)) {
            doPut(req, resp);
        } else if (method.equals(METHOD_DELETE)) {
            doDelete(req, resp);
        } else if (method.equals(METHOD_OPTIONS)) {
            doOptions(req,resp);
        } else if (method.equals(METHOD_TRACE)) {
            doTrace(req,resp);
        } else {
            // 如果没有被请求到的话
            String errMsg = lStrings.getString("http.method_not_implemented");
            Object[] errArgs = new Object[1];
            errArgs[0] = method;
            errMsg = MessageFormat.format(errMsg, errArgs);
            // 501 HTTP状态码
            resp.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED, errMsg);
        }
	}
	
}
