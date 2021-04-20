/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.web.servlet;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.SpringServletContainerInitializer;
import org.springframework.web.WebApplicationInitializer;

/**
 * <p>接口用于以编程方式配置Servlet 3.0+上下文。与WebApplicationInitializer不同，
 * 实现这个接口的类(不实现WebApplicationInitializer)不会被SpringServletContainerInitializer检测到，因此不会被Servlet容器自动引导。</p>
 * Interface used to configure a Servlet 3.0+ {@link ServletContext context}
 * programmatically. Unlike {@link WebApplicationInitializer}, classes that implement this
 * interface (and do not implement {@link WebApplicationInitializer}) will <b>not</b> be
 * detected by {@link SpringServletContainerInitializer} and hence will not be
 * automatically bootstrapped by the Servlet container.
 * <p>该接口被设计成以与ServletContainerInitializer类似的方式进行操作，但其生命周期由Spring管理，而不是Servlet容器。</p>
 * <p>
 * This interface is designed to act in a similar way to
 * {@link ServletContainerInitializer}, but have a lifecycle that's managed by Spring and
 * not the Servlet container.
 * <p>
 * For configuration examples see {@link WebApplicationInitializer}.
 *
 * @author Phillip Webb
 * @since 1.4.0
 * @see WebApplicationInitializer
 */
@FunctionalInterface
public interface ServletContextInitializer {

	/**
	 * Configure the given {@link ServletContext} with any servlets, filters, listeners
	 * context-params and attributes necessary for initialization.
	 * @param servletContext the {@code ServletContext} to initialize
	 * @throws ServletException if any call against the given {@code ServletContext}
	 * throws a {@code ServletException}
	 */
	void onStartup(ServletContext servletContext) throws ServletException;

}
