package com.cg.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.project.dao.TraineeDAO;
import com.cg.project.dao.TraineeDAOImpl;
import com.cg.project.entity.Trainee;
import com.cg.project.service.TraineeService;

/**
 * @author Ayushi_Chaudhary
 * Apr 15, 2020
 */
@Controller
public class TraineeController {

	@Autowired
	private TraineeService traineeService;

	//login
	@RequestMapping("/")
	public String menu() {
		return "login";
	}

	@RequestMapping("/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
		if (username.equals("admin") && password.equals("admin")) {
			return "main-menu";
		} else {
			return "login";
		}
	}

	
	// Adding Trainee
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Trainee theTrainee = new Trainee();
		theModel.addAttribute("trainee", theTrainee);
		return "trainee-form";
	}

	@PostMapping("/saveTrainee")
	public String saveTrainee(@ModelAttribute("trainee") Trainee theTrainee) {
		traineeService.saveTrainee(theTrainee);
		return "redirect:/main-menu";
	}

	
	// Removing the Trainee
	@RequestMapping("/delete-ops")
	public String deleteOps() {
		return "delete-ops";
	}

	@GetMapping("/deleteTrainee")
	public String deleteTrainee(@RequestParam("id") int id) {
		traineeService.deleteTrainee(id);
		return "redirect:/main-menu";
	}

	
	// Updating the Trainee
	@RequestMapping("/modify-ops")
	public String modifyOps() {
		return "modify-ops";
	}

	@GetMapping("/update")
	public String update(@RequestParam("id") int id, Model theModel) {
		Trainee theTrainee = traineeService.getTrainee(id);
		theModel.addAttribute("updateTrainee", theTrainee);
		return "update-trainee-form";
	}

	@PostMapping("/updateTrainee")
	public String updateTrainee(@ModelAttribute("updateTrainee") Trainee theTrainee) {
		traineeService.updateTrainee(theTrainee);
		return "/";
	}

	// Retrieving one Trainee
	@RequestMapping("/retrieve-ops")
	public String retrieveOps() {
		return "retrieve-ops";
	}

	@RequestMapping("/retrieve-trainee")
	public String retrieveTrainee(@RequestParam("id") int id, Model theModel) {
		Trainee theTrainee = traineeService.getTrainee(id);
		theModel.addAttribute("ReTrainee", theTrainee);
		return "retrieve-one";
	}

	
	// Retreiving all Trainee
	@GetMapping("/allDetails")
	public String listTrainees(Model theModel) {
		List<Trainee> theTrainees = traineeService.getTrainees();
		theModel.addAttribute("trainees", theTrainees);
		return "retrieve-all";

	}

}
