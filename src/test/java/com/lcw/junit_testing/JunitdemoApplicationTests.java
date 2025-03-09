package com.lcw.junit_testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class JunitdemoApplicationTests {

	private Calculator c=new Calculator();

	@Test
	void contextLoads() {
		System.out.println("first test method");
	}

	@BeforeEach
	void setUp() {
		System.out.println("inside before each method");
	}


	@Test
	void testSum(){
//expected output
		int expectedResult=17;
//actual output from logic
		int actualResult = c.doSum(12, 3, 2);
		assertThat(actualResult).isEqualTo(expectedResult);
		System.out.println("second test method");

	}

	@Test
	void testMul(){

		int expectedResult=6;

		int actualResult = c.doMul(3, 2);
		assertThat(actualResult).isEqualTo(expectedResult);
		System.out.println("third test method");
	}

}
