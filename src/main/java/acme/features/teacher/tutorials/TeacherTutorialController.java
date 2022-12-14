/*
 * AuthenticatedAnnouncementController.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.teacher.tutorials;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.tutorials.Tutorial;
import acme.framework.controllers.AbstractController;
import acme.roles.Teacher;

@Controller
@RequestMapping("/teacher/tutorial/")
public class TeacherTutorialController extends AbstractController<Teacher, Tutorial> {

	// Internal state ---------------------------------------------------------
	@Autowired
	protected TeacherLabListService	listLabService;
	
	@Autowired
	protected TeacherTheoryListService listTheoryService;
	
	@Autowired
	protected TeacherTutorialShowService	showService;
	
	@Autowired
	protected TeacherTheoryCreateService	createTheoryService;
	
	@Autowired
	protected TeacherLabCreateService	createLabService;
	
	@Autowired
	protected TeacherTutorialUpdateService	updateService;
	
	@Autowired
	protected TeacherTutorialDeleteService	deleteService;
	
	@Autowired
	protected TeacherTutorialPublishService	publishService;


	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addCommand("list-lab","list", this.listLabService);
		super.addCommand("list-theory","list", this.listTheoryService);
		super.addCommand("show", this.showService);
		super.addCommand("create-theory", "create", this.createTheoryService);
		super.addCommand("create-lab", "create", this.createLabService);
		super.addCommand("delete", this.deleteService);
		super.addCommand("update", this.updateService);
		super.addCommand("publish", "update", this.publishService);
	}

}
