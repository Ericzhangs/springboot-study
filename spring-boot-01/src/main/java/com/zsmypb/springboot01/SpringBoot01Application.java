package com.zsmypb.springboot01;

import com.zsmypb.springboot01.vo.Book;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

/**
 * @SpringBootApplication 来标注一个主程序类，说明这个类是SpringBoot的主配置类，运行这类的main方法来启动SpringBoot项目
 *
 * 1、@SpringBootConfiguration springboot的配置类；
 *      标注在某个类上，表示这是一个SpringBoot的配置类；
 *      @Configuration 配置类上来标注这个注解
 *          配置类---配置文件；配置类也是容器中的组件(@Component)
 * 2、@EnableAutoConfiguration 开启自动配置功能；springboot帮我们自动配置
 *      @AutoConfigurationPackage 自动配置包；将主配置类的所在包及下面所有子包里面的所有组件扫描到Spring容器；
 *          @Import(AutoConfigurationPackages.Registrar.class)
 *              Spring的底层注解@Import，给容器中导入一个组件；
*           @Import(AutoConfigurationImportSelector.class) 给容器中导入组件
 *              AutoConfigurationImportSelector： 组件导入选择器
 *              将所有需要导入的组件以全类名的方式返回；这些组件就会被添加到容器中；
 *              最终会给容器中导入非常多的自动配置类(xxxAutoConfiguration)，就是给容器中导入这个场景需要的所有组件，并配置好这些组件；
 *
 *
 *              SpringFactoriesLoader.loadFactoryNames(EnableAutoConfiguration.class, ClassLoader)
 *              SpringBoot在启动的时候从类路径下的META-INF/spring.factories中获取EnableAutoConfiguration指定的值；
 *              将这些值作为自动配置类导入到容器中，自动配置类就生效，帮我们进行自动配置工作；
 *              J2EE的整体解决方案和自动配置都在spring-boot-autoconfigure-2.2.5.RELEASE.jar
 *
 *                  1、插入组件selectImports()方法的内容
 *                      List<String> configurations = getCandidateConfigurations(annotationMetadata, attributes); 获取候选的配置
 *                      SpringFactoriesLoader.loadFactoryNames(); 扫描所有jar包类路径下 META-INF/spring.factories
 *                      把扫描到的这些文件的内容包装properties对象
 *  3、每一个自动配置类进行自动配置功能
 *
 *  4、以HttpEncodingAutoConfiguration(HTTP编码自动配置)为例解释自动配置原理
 *      @Configuration() 表示这是一个配置类，可以给容器添加组件
 *      @EnableConfigurationProperties(HttpProperties.class) 启动指定类的ConfigurationProperties功能；
 *          将配置文件中对应的值和HttpProperties绑定起来；并把HttpProperties加入到IOC容器中；配置类中可以直接使用HttpProperties实例
 *      @ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)  判断当前是不是web应用 ，如果是，当前配置类生效
 *          Spring底层@Conditional注解，根据不同的条件，如果满足指定的条件，整个配置类里面的配置就会生效
 *      @ConditionalOnClass(CharacterEncodingFilter.class) 判断当前项目有没有这个类
 *          CharacterEncodingFilter  SpringMVC中进行乱码解决的过滤器
 *      @ConditionalOnProperty(prefix = "spring.http.encoding", value = "enabled", matchIfMissing = true) 判断配置文件中是否存在某个配置
 *          判断spring.http.encoding.enabled是否存在，matchIfMissing = true 这个属性表示即使配置文件中不存在上述文件也是默认生效的
 *      总结： 根据当前不同的条件判断，决定这个配置类是否生效；一但这个配置类生效，这个配置类就会给容器中添加各种组件，这些组件的属性是从对应的properties类中获取的，
 *              这些类里面的每一个属性又是和配置文件绑定的；
 *  5、所有的配置文件中能配置的属性都是在XXXXProperti类中封装着；配置文件能配置什么就可以参照某个功能对应的这个属性类
 *       @ConfigurationProperties(prefix = "spring.http") 从配置文件中获取指定的值和bean的属性进行绑定
 *       public class HttpProperties {
 */
@SpringBootApplication
public class SpringBoot01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot01Application.class, args);
    }


    /**
     * Bean的作用域
     * SCOPE_SINGLETON 默认值，当IOC容器创建的时候就会创建该Bean，而且是单例的，每次注入的都是同一个
     * SCOPE_PROTOTYPE 原型的，当IOC容器创建的时候不会创建该Bean，每次注入的之后才会创建一个新的Bean
     * SCOPE_REQUEST 每次HTTP请求都会创建一个新的Bean，该Bean的作用域仅适用于WebApplicationContext环境
     * SCOPE_SESSION 同一个HTTP Session共享一个Bean，不同的HTTP Session使用不同的Bean，该Bean的作用域仅适用于WebApplicationContext环境
     *
	 * 测试类 scopeTest()
	 *
     * @return
     */
    @Bean()
//    @Scope(WebApplicationContext.SCOPE_SESSION)
	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Book createBook() {
        return new Book("soring Boot 创建了Book");
    }

}
