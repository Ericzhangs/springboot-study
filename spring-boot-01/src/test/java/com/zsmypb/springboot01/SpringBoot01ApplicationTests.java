package com.zsmypb.springboot01;

import com.zsmypb.springboot01.vo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@SpringBootTest
class SpringBoot01ApplicationTests {

	@Autowired
	Book createBook;

	@Autowired
	Book createBook2;

	/**
	 * 测试bean的作用域
	 */
	@Test
	void scopeTest() {
		Book book = createBook;
		Book book2 = createBook2;
		System.out.println(book == book2);
	}

	@Test
	void beanTest() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
		DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getBeanFactory();
	}

	@Test
	void classTest() throws ClassNotFoundException {
		Class<?> book = Class.forName("com.zsmypb.springboot01.vo.Book");
		System.out.println(book);
		System.out.println(book.getName());
	}

}
