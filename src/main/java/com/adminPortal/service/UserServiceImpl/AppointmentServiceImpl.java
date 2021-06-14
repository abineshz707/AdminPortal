package com.adminPortal.service.UserServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminPortal.service.AppointmentService;
import com.adminPortal.dao.AppointmentDao;
import com.adminPortal.domain.Appointment;

@Service
public class AppointmentServiceImpl implements AppointmentService{
	
	
	@Autowired
    private AppointmentDao appointmentDao;

    public Appointment createAppointment(Appointment appointment) {
       return appointmentDao.save(appointment);
    }

    public List<Appointment> findAll() {
        return appointmentDao.findAll();
    }
    
    public Appointment findAppointment(Long id)
    {
    	Optional<Appointment> appointment= appointmentDao.findById(id);
    	
    		return appointment.get();
    	    	
    }

  /*  public Appointment findAppointment(Long id) {
        return appointmentDao.findById(id);
    }
    */

    public void confirmAppointment(Long id) {
        Appointment appointment = findAppointment(id);
        appointment.setConfirmed(true);
        appointmentDao.save(appointment);
    }
    
}
