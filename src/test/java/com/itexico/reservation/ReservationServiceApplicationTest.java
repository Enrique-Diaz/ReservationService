package com.itexico.reservation;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("ReservationServiceApplicationTest")
public class ReservationServiceApplicationTest {

	ReservationServiceApplication cut = new ReservationServiceApplication();
	
	@Test
	@DisplayName("constructor")
	public void testDispatchServiceApplication() {
		assertNotNull(cut, "The call to the constructor did not return the expected results");
	}
}