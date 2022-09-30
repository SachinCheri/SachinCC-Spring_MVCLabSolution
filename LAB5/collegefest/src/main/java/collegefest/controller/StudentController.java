package collegefest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import collegefest.entity.Student;
import collegefest.service.StudentService;

@Controller
public class StudentController {
	@Autowired
private StudentService studentService;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("list")
	public String listBooks(Model theModel) {

		System.out.println("request recieved");
		List<Student> theStudents = studentService.findAll();
		theModel.addAttribute("student", theStudents);
		return "studentlist";
	}

	@GetMapping("showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Student theStudent = new Student();
		theModel.addAttribute("student", theStudent);
		return "studentform";
}

	@GetMapping("showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel) {
		Student theStudent = studentService.findById(theId);
		theModel.addAttribute("student", theStudent);
		return "studentform";
	}

	@PostMapping("save")
	public String saveStudent(Model model, @ModelAttribute("student") Student student) {
		System.out.println(student);
		studentService.save(student);
		return "redirect:/list";
	}
	@RequestMapping("delete")
	public String delete(@RequestParam("studentId") int theId) {
		studentService.deleteById(theId);
		return "redirect:/list";

	}

}



