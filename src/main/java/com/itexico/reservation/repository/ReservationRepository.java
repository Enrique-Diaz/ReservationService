package com.itexico.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itexico.reservation.pojo.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

}