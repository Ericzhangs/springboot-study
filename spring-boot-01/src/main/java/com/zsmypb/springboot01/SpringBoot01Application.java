package com.zsmypb.springboot01;

import com.zsmypb.springboot01.vo.Book;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

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
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Book createBook() {
        return new Book("soring Boot 创建了Book");
    }

}
