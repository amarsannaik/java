package com.amar.java8;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Optional;

import org.junit.jupiter.api.Test;

public class OptionalClassTest {

	@Test
	public void testWithVal() {
		final StringBuilder sb = new StringBuilder("testVal");
		Optional<StringBuilder> opt = Optional.of(sb);

		// check if value present
		assertEquals(true, opt.isPresent());
		// check if value is same
		assertEquals("testVal", opt.get().toString());

		// update the value
		opt.ifPresent((s) -> {
			s.append("1");
		});
		// check value after update
		assertEquals("testVal1", sb.toString());
	}

	@Test
	public void testWithNull() {
		String value = null;
		Optional<String> opt = Optional.ofNullable(value);

		// check value
		assertEquals(false, opt.isPresent());
		// if null default is returned
		assertEquals("noval", opt.orElse("noval"));

		// trying to fetch value throws error
		try {
			opt.get();

			fail("its not throwing error");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
