package org.tomcat.jsp.jasper;

import org.apache.jasper.JspC;

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
 * @since 2015-7-16 13:32:04
 * 	Jasper引擎编译JSP
 * 		jar：Ant相关 + tomcat-juli.jar
 */
public class JspCompilerT {
	
	/**
	 * 编译Jsp文件，并输出
	 * @param uriRoot web应用的root目录
	 * @param outPutDir .java和.class文件输出目录
	 * @param jspFileName 要编译的jsp
	 * @return
	 */
	public static String jspCompiler(
			String uriRoot,
			String outPutDir,
			String jspFileName){
		String errorMsg = "";
		try {
			// 创建一个Jsp编译器
			JspC jspC = new JspC();
			
			// 设置相关属性，参加方法
			jspC.setUriroot(uriRoot);
			jspC.setOutputDir(outPutDir);
			jspC.setJspFiles(jspFileName);
			
			// 是否编译，是会包含.class文件
			jspC.setCompile(true);
			jspC.execute();
		} catch (Exception e) {
			errorMsg = e.toString();
		}
		return errorMsg;
	}

	public static void main(String[] args) {
		System.out.println(
			JspCompilerT.jspCompiler(
					"./WebContent",
					"E:/", 
					"jspC.jsp")// 文件目标：WebContent/jspC.jsp
				);
	}
}
