package com.itexico.reservation.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import com.itexico.reservation.pojo.Reservation;
import com.itexico.reservation.repository.ReservationRepository;

@DisplayName("ReservationControllerTest")
public class ReservationControllerTest {

	@Mock
	public Logger logger;
	
	@Mock
	public ReservationRepository reservationRepository;
	
	@InjectMocks
	ReservationController cut;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	@DisplayName("constructor")
	void testProcessorController() {
		assertNotNull(cut, "The constructor did not return the expected results");
	}
	
	@Nested
	@DisplayName("Tests GetReservations method")
	class testGetReservations {
		@Test
		@DisplayName("Test reservations found")
		void testReservationsFound() {
			List<Reservation> reservations = new ArrayList<>();
			Reservation reservation = new Reservation();
			
			reservation.setId(1);
			reservation.setName("Test1");
			reservation.setLocalDateTime(Instant.now());
			
			reservations.add(reservation);
			
			reservation = new Reservation();
			reservation.setId(2);
			reservation.setName("Test2");
			reservation.setLocalDateTime(Instant.now());
			
			reservations.add(reservation);
			
			when(reservationRepository.findAll()).thenReturn(reservations);
			
			List<Reservation> response = cut.getReservations();
			
			assertNotNull(response);
			verify(reservationRepository, times(1)).findAll();
			assertEquals(2, response.size());
			assertEquals("Test1", response.get(0).getName());
			assertEquals("Test2", response.get(1).getName());
		}
		
		@Test
		@DisplayName("Test reservations not found")
		void testReservationsNotFound() {
			List<Reservation> reservations = new ArrayList<>();
			
			when(reservationRepository.findAll()).thenReturn(reservations);
			
			List<Reservation> response = cut.getReservations();
			
			assertNotNull(response);
			verify(reservationRepository, times(1)).findAll();
			assertEquals(0, response.size());
		}
	}
}