package com.adminPortal.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.adminPortal.domain.Appointment;
import com.adminPortal.domain.User;

public interface AppointmentDao extends CrudRepository<Appointment, Long> {

    List<Appointment> findAll();
    
    
}