package com.amar.java8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.jupiter.api.Test;

public class LambdaExpressionTest {

	interface FuncIntWithNoMethodParam {
		void displayName();
	}

	interface FuncIntWithMethodParam {
		void displayName(String name);
	}

	@Test
	public void testWithNoParam() {
		// in java7 or before
		FuncIntWithNoMethodParam methodWithNoParams = new FuncIntWithNoMethodParam() {
			@Override
			public void displayName() {
				System.out.println("HELLO");
			}
		};
		methodWithNoParams.displayName();

		// in java8
		methodWithNoParams = () -> {
			System.out.println("HELLO");
		};
		methodWithNoParams.displayName();
	}

	@Test
	public void testWithParam() {
		// in java7 or before
		FuncIntWithMethodParam methodWithParams = new FuncIntWithMethodParam() {
			@Override
			public void displayName(String name) {
				System.out.println("HELLO");
			}
		};
		methodWithParams.displayName("There");

		// in java8
		methodWithParams = (name) -> {
			System.out.println("HELLO " + name);
		};
		methodWithParams.displayName("There");
	}

	interface FuncIntWithMethodParamAndReturnValue {
		String displayName(String name);
	}

	@Test
	public void testWithReturnStatement() {
		// in java7 or before
		FuncIntWithMethodParamAndReturnValue methodWithParamsAndReturnValue = new FuncIntWithMethodParamAndReturnValue() {
			@Override
			public String displayName(String name) {
				return "Hello " + name;
			}
		};
		assertEquals("Hello There", methodWithParamsAndReturnValue.displayName("There"));

		// in java8
		methodWithParamsAndReturnValue = (name) -> "Hello " + name;

		System.out.println(methodWithParamsAndReturnValue.displayName("There"));
		assertEquals("Hello There", methodWithParamsAndReturnValue.displayName("There"));
	}

	@Test
	public void testWithOutReturnKeyword() throws Exception {
		FuncIntWithMethodParamAndReturnValue methodWithParamsAndReturnValue = (name) -> "Hello " + name;
		assertEquals("Hello There", methodWithParamsAndReturnValue.displayName("There"));
	}

	@Test
	public void testInvokeThread() throws Exception {
		Runnable r = () -> {
			System.out.println("HELLO");
		};

		Thread t = new Thread(r);
		t.start();

		// Callable
		Callable<String> callable = () -> {
			return "Hi";
		};

		Future<String> futures = Executors.newFixedThreadPool(1).submit(callable);

		System.out.println(futures.get());

	}
}
