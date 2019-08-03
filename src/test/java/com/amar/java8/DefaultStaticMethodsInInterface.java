package com.amar.java8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DefaultStaticMethodsInInterface {

	interface DefaultMethodInt {
		default String displayDefault() {
			return "default";
		}

		static String displayStatic() {
			return "static";
		}
	}

	@Test
	public void testInvokeDefaultMethod() {
		DefaultMethodInt dfInt = new DefaultMethodInt() {
		};

		// caling with object ref.. in impl class on body is provided for default method
		assertEquals("default", dfInt.displayDefault());
	}

	@Test
	public void testInvokeStaticMethod() {
		// static method is called directly with interface name
		assertEquals("static", DefaultMethodInt.displayStatic());

	}
}
