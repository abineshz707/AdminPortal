package com.adminPortal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.adminPortal.domain.Appointment;
import com.adminPortal.domain.User;
import com.adminPortal.service.AppointmentService;
import com.adminPortal.service.UserService;

@Controller
@PreAuthorize("hasRole('OWNER')")
public class ActionsController {

@Autowired
UserService userService;

@Autowired
AppointmentService appointmentService;

@RequestMapping("/homePage")
public String HomePage()
{
	return "homePage";
}

@RequestMapping("/userDetails")
public String UserDetails(Model model)
{
	List<User> userList = userService.findUserList();
	model.addAttribute("userList",userList);
	return "userDetails";
	
}

@RequestMapping("/appointment")
public String Appointment(Model model)
{
	List<Appointment> appointmentList = appointmentService.findAll();
	model.addAttribute("appointmentList", appointmentList);
	return "appointment";
}

@RequestMapping(value= "/appointmentConfirm", method =RequestMethod.GET)
public String AppointmentConfirm(@RequestParam(value = "appointmentId") Long id)
{
	appointmentService.confirmAppointment(id);
	return "redirect:/appointment";
}

@RequestMapping(value ="/userAction", method= RequestMethod.GET)
public  String UserAction(@RequestParam(value= "userId") Long id)
{
	userService.actionOnUser(id);
	return "redirect:/userDetails";
}

}
