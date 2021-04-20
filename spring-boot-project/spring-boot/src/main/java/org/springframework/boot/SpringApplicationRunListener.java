/*
 * Copyright 2012-2021 the original author or authors.
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

package org.springframework.boot;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.support.SpringFactoriesLoader;

/**
 * <p>SpringApplication run方法的侦听器。
 * SpringApplicationRunListeners是通过SpringFactoriesLoader加载的，
 * 并且应该声明一个公共构造函数来接受SpringApplication实例和一个String[]参数。
 * 每次运行都会创建一个新的SpringApplicationRunListener实例。</p>
 *
 * Listener for the {@link SpringApplication} {@code run} method.
 * {@link SpringApplicationRunListener}s are loaded via the {@link SpringFactoriesLoader}
 * and should declare a public constructor that accepts a {@link SpringApplication}
 * instance and a {@code String[]} of arguments. A new
 * {@link SpringApplicationRunListener} instance will be created for each run.
 *
 * @author Phillip Webb
 * @author Dave Syer
 * @author Andy Wilkinson
 * @since 1.0.0
 */
public interface SpringApplicationRunListener {

	/**
	 * <p>在run方法第一次启动时立即调用。可以用于非常早期的初始化。</p>
	 * Called immediately when the run method has first started. Can be used for very
	 * early initialization.
	 * @param bootstrapContext the bootstrap context
	 */
	default void starting(ConfigurableBootstrapContext bootstrapContext) {
		starting();
	}

	/**
	 * Called immediately when the run method has first started. Can be used for very
	 * early initialization.
	 * @deprecated since 2.4.0 for removal in 2.6.0 in favor of
	 * {@link #starting(ConfigurableBootstrapContext)}
	 */
	@Deprecated
	default void starting() {
	}

	/**
	 * <p>在环境准备好之后，但在创建ApplicationContext之前调用。</p>
	 * Called once the environment has been prepared, but before the
	 * {@link ApplicationContext} has been created.
	 * @param bootstrapContext the bootstrap context
	 * @param environment the environment
	 */
	default void environmentPrepared(ConfigurableBootstrapContext bootstrapContext,
			ConfigurableEnvironment environment) {
		environmentPrepared(environment);
	}

	/**
	 * Called once the environment has been prepared, but before the
	 * {@link ApplicationContext} has been created.
	 * @param environment the environment
	 * @deprecated since 2.4.0 for removal in 2.6.0 in favor of
	 * {@link #environmentPrepared(ConfigurableBootstrapContext, ConfigurableEnvironment)}
	 */
	@Deprecated
	default void environmentPrepared(ConfigurableEnvironment environment) {
	}

	/**
	 * <p>在创建并准备好ApplicationContext之后调用，但在加载源之前调用。</p>
	 * Called once the {@link ApplicationContext} has been created and prepared, but
	 * before sources have been loaded.
	 * @param context the application context
	 */
	default void contextPrepared(ConfigurableApplicationContext context) {
	}

	/**
	 * <p>一旦加载了应用程序上下文，但在它被刷新之前调用。</p>
	 * Called once the application context has been loaded but before it has been
	 * refreshed.
	 * @param context the application context
	 */
	default void contextLoaded(ConfigurableApplicationContext context) {
	}

	/**
	 * <p>上下文已经刷新，应用程序已经启动，但还没有调用CommandLineRunners和ApplicationRunners。</p>
	 * The context has been refreshed and the application has started but
	 * {@link CommandLineRunner CommandLineRunners} and {@link ApplicationRunner
	 * ApplicationRunners} have not been called.
	 * @param context the application context.
	 * @since 2.0.0
	 */
	default void started(ConfigurableApplicationContext context) {
	}

	/**
	 * <p>当应用程序上下文已经刷新并且所有CommandLineRunners和ApplicationRunners已经被调用时，在run方法结束之前立即调用。</p>
	 * Called immediately before the run method finishes, when the application context has
	 * been refreshed and all {@link CommandLineRunner CommandLineRunners} and
	 * {@link ApplicationRunner ApplicationRunners} have been called.
	 * @param context the application context.
	 * @since 2.0.0
	 */
	default void running(ConfigurableApplicationContext context) {
	}

	/**
	 * <p>在运行应用程序时发生故障时调用。</p>
	 * Called when a failure occurs when running the application.
	 * @param context the application context or {@code null} if a failure occurred before
	 * the context was created
	 * @param exception the failure
	 * @since 2.0.0
	 */
	default void failed(ConfigurableApplicationContext context, Throwable exception) {
	}

}
