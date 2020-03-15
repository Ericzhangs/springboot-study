package com.zsmypb.springboot01;

import com.zsmypb.springboot01.vo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

}
