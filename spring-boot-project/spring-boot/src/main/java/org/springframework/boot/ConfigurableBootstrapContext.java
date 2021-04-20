/*
 * Copyright 2012-2020 the original author or authors.
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
 * <p>一个BootstrapContext，它还通过BootstrapRegistry接口提供配置方法。</p>
 * A {@link BootstrapContext} that also provides configuration methods via the
 * {@link BootstrapRegistry} interface.
 *
 * @author Phillip Webb
 * @since 2.4.0
 * @see BootstrapRegistry
 * @see BootstrapContext
 * @see DefaultBootstrapContext
 */
public interface ConfigurableBootstrapContext extends BootstrapRegistry, BootstrapContext {

}
