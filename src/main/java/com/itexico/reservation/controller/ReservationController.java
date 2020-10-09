package com.itexico.reservation.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itexico.reservation.pojo.Reservation;
import com.itexico.reservation.repository.ReservationRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "reservations")
public class ReservationController {

	@Autowired
	Logger logger;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@ApiOperation(value = "Get all reservations.")
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Reservation> getReservations(){
		logger.info("Start getting all reservations");
		
		List<Reservation> reservations = reservationRepository.findAll();
		
		logger.info("End of getting all reservations");
		return reservations;
	}
}