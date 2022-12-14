package acme.features.teacher.help_request;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.help_requests.HelpRequest;
import acme.framework.controllers.AbstractController;
import acme.roles.Teacher;

@Controller
public class TeacherHelpRequestController extends AbstractController<Teacher, HelpRequest>{

	// Internal state
	
	@Autowired
	protected TeacherHelpRequestListService listService;
	
	@Autowired
	protected TeacherHelpRequestShowService showService;
	
	@Autowired
	protected TeacherHelpRequestAcceptService acceptService;
	
	@Autowired
	protected TeacherHelpRequestDenyService denyService;
	
	// Constructors
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("list", this.listService);
		super.addCommand("show", this.showService);
		super.addCommand("accept", "update", this.acceptService);
		super.addCommand("deny", "update", this.denyService);
	}
}
