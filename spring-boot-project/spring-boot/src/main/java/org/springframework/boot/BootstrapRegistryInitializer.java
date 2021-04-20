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

/**
 * <p>回调接口，可用于在使用BootstrapRegistry之前初始化它。</p>
 * Callback interface that can be used to initialize a {@link BootstrapRegistry} before it
 * is used.
 *
 * @author Phillip Webb
 * @since 2.4.5
 * @see SpringApplication#addBootstrapRegistryInitializer(BootstrapRegistryInitializer)
 * @see BootstrapRegistry
 */
@FunctionalInterface
public interface BootstrapRegistryInitializer {

	/**
	 * <p>使用任何必需的注册来初始化给定的BootstrapRegistry。</p>
	 * Initialize the given {@link BootstrapRegistry} with any required registrations.
	 * @param registry the registry to initialize
	 */
	void initialize(BootstrapRegistry registry);

}