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

package org.springframework.boot.autoconfigure;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.support.SpringFactoriesLoader;

/**
 * <p>启用Spring应用程序上下文的自动配置，尝试猜测和配置您可能需要的bean。
 * 自动配置类通常根据您的类路径和您定义的bean来应用。例如，如果您的类路径上有tomcat-embedded.jar，
 * 那么您很可能需要一个TomcatServletWebServerFactory(除非您已经定义了自己的ServletWebServerFactory bean)。</p>
 * Enable auto-configuration of the Spring Application Context, attempting to guess and
 * configure beans that you are likely to need. Auto-configuration classes are usually
 * applied based on your classpath and what beans you have defined. For example, if you
 * have {@code tomcat-embedded.jar} on your classpath you are likely to want a
 * {@link TomcatServletWebServerFactory} (unless you have defined your own
 * {@link ServletWebServerFactory} bean).
 * <p>当使用@SpringBootApplication时，上下文的自动配置将自动启用，因此添加这个注释不会产生额外的效果。</p>
 * <p>
 * When using {@link SpringBootApplication @SpringBootApplication}, the auto-configuration
 * of the context is automatically enabled and adding this annotation has therefore no
 * additional effect.
 * <p>自动配置试图尽可能地智能化，当您定义更多自己的配置时，它会后退。
 * 您总是可以手动exclude()任何您不想应用的配置(如果您不能访问它们，请使用excludeName())。
 * 您也可以通过spring.autoconfigure.exclude属性排除它们。自动配置总是在注册了用户定义的bean之后应用。</p>
 * <p>
 * Auto-configuration tries to be as intelligent as possible and will back-away as you
 * define more of your own configuration. You can always manually {@link #exclude()} any
 * configuration that you never want to apply (use {@link #excludeName()} if you don't
 * have access to them). You can also exclude them via the
 * {@code spring.autoconfigure.exclude} property. Auto-configuration is always applied
 * after user-defined beans have been registered.
 * <p>用@EnableAutoConfiguration注释的类包(通常通过@SpringBootApplication注释)具有特定的意义，通常被用作“默认值”。
 * 例如，它将在扫描@Entity类时使用。通常建议您将@EnableAutoConfiguration(如果您没有使用@SpringBootApplication)放在根包中，以便可以搜索所有的子包和类。</p>
 * <p>
 * The package of the class that is annotated with {@code @EnableAutoConfiguration},
 * usually via {@code @SpringBootApplication}, has specific significance and is often used
 * as a 'default'. For example, it will be used when scanning for {@code @Entity} classes.
 * It is generally recommended that you place {@code @EnableAutoConfiguration} (if you're
 * not using {@code @SpringBootApplication}) in a root package so that all sub-packages
 * and classes can be searched.
 * <p>自动配置类是常规的Spring @Configuration bean。
 * 它们是使用SpringFactoriesLoader机制定位的(与该类对应)。
 * 通常自动配置bean是@Conditional(最常用@ConditionalOnClass和@ConditionalOnMissingBean注释)。</p>
 * <p>
 * Auto-configuration classes are regular Spring {@link Configuration @Configuration}
 * beans. They are located using the {@link SpringFactoriesLoader} mechanism (keyed
 * against this class). Generally auto-configuration beans are
 * {@link Conditional @Conditional} beans (most often using
 * {@link ConditionalOnClass @ConditionalOnClass} and
 * {@link ConditionalOnMissingBean @ConditionalOnMissingBean} annotations).
 *
 * @author Phillip Webb
 * @author Stephane Nicoll
 * @since 1.0.0
 * @see ConditionalOnBean
 * @see ConditionalOnMissingBean
 * @see ConditionalOnClass
 * @see AutoConfigureAfter
 * @see SpringBootApplication
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@AutoConfigurationPackage
@Import(AutoConfigurationImportSelector.class)
public @interface EnableAutoConfiguration {

	/**
	 * <p>环境属性，在启用自动配置时可用于重写。</p>
	 * Environment property that can be used to override when auto-configuration is
	 * enabled.
	 */
	String ENABLED_OVERRIDE_PROPERTY = "spring.boot.enableautoconfiguration";

	/**
	 * <p>排除特定的自动配置类，这样它们就永远不会被应用。</p>
	 * Exclude specific auto-configuration classes such that they will never be applied.
	 * @return the classes to exclude
	 */
	Class<?>[] exclude() default {};

	/**
	 * <p>排除特定的自动配置类名，这样它们就永远不会被应用。</p>
	 * Exclude specific auto-configuration class names such that they will never be
	 * applied.
	 * @return the class names to exclude
	 * @since 1.3.0
	 */
	String[] excludeName() default {};

}
