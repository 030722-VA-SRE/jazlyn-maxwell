package com.revature.daos;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.revature.daos.CharmPostgres.isInteger;

@ExtendWith(MockitoExtension.class)
public class CharmPostgresTest {
	
	static CharmPostgres cDao;
	
	@BeforeAll
	public static void init() {
		cDao = new CharmPostgres();
	}
	
	@Test
	public void testIsIntegerTrue() {
		assertTrue(isInteger("1"));
	}
	
	@Test
	public void testIsIntegerFalse() {
		assertFalse(isInteger("test"));
	}
	
	@Test
	public void testIsIntegerNegative() {
		assertTrue(isInteger("-2"));
	}
}
