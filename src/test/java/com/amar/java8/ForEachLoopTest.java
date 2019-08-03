package com.amar.java8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ForEachLoopTest {

	@Test
	public void testLoopProcessAll() {
		List<Integer> nos = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++)
			nos.add(i);

		StringBuilder sb = new StringBuilder();

		nos.forEach((i) -> {
			sb.append(i);
		});

		assertEquals("0123456789", sb.toString());
	}

	@Test
	public void testLoopWithErrorForOne() {
		List<Integer> nos = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++)
			nos.add(i);

		StringBuilder sb = new StringBuilder();
		try {
			nos.forEach((i) -> {
				if (i == 5)
					throw new RuntimeException("trying to stop in between");
				sb.append(i);
			});
		} catch (Exception e) {
		}
		assertEquals("01234", sb.toString());
	}
}
