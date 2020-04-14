package com.zsmypb.springboot01;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.util.PoiPublicUtil;
import com.zsmypb.springboot01.car.CarDto;
import com.zsmypb.springboot01.config.scan.PersonService;
import com.zsmypb.springboot01.vo.Book;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.util.Date;
import java.util.List;

@SpringBootTest
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

	@Autowired
	@Qualifier("PersonService")
	private PersonService personService;

	@Test
	public String getName(){
		return personService.getName();
	}



	public void test2() {
		System.out.println(1111);
		ImportParams params = new ImportParams();
		params.setTitleRows(1);
		params.setHeadRows(1);
		long start = new Date().getTime();
		List<CarDto> list = ExcelImportUtil.importExcel(
				new File("/Users/zhangs/car/车型名称映射.xlsx"),
				CarDto.class, params);
		System.out.println(new Date().getTime() - start);
		System.out.println(list.size());
		System.out.println(ReflectionToStringBuilder.toString(list.get(0)));
	}

}
