package com.jpa.StandardJPA.contents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {

	private StudentRepository studentService;

	@Autowired
	public StudentController(StudentRepository studentService) {
		this.studentService = studentService;
	}

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/students")
	public String getAll(Model theModel) {
		List<Student> theStudent = studentService.findAll();
		theModel.addAttribute("student", theStudent);
		return "list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam int id) {
		studentService.deleteById(id);
		return "redirect:/";
	}

	@GetMapping("/find")
	public String findToDelete(@RequestParam int id, Model theModel) {
		Optional<Student> student = studentService.findById(id);
		if (student.isPresent()) {
			theModel.addAttribute("studentList", student.get());
			return "confirm-delete";
		} else {
			return "delete-error.html";
		}
	}

	@GetMapping("/addForm")
	public String addForm(Model theModel) {
		Student student = new Student();
		theModel.addAttribute("newStud", student);
		return "add-form";
	}

	@GetMapping("/updateForm")
	public String updateForm(Model theModel) {
		Student student = new Student();
		theModel.addAttribute("newStud", student);
		return "update-form";
	}

	@PostMapping("/save")
	public String add(@ModelAttribute("newStud") Student stu) {
		Optional<Student> test = studentService.findById(stu.getId());
		if (test.isPresent()) {
			return "add-error";
		}
		stu = studentService.save(stu);
		return "redirect:/";
	}

	@PostMapping("/update")
	public String update(@ModelAttribute("newStud") Student stu, Model theModel) {
		Optional<Student> test = studentService.findById(stu.getId());
		if (!test.isPresent()) {
			return "update-error";
		}
		stu = studentService.save(stu);
		Student student = studentService.getOne(stu.getId());
		theModel.addAttribute("newStudent", student);
		return "update-confirm";

	}

	@GetMapping("/deleteForm")
	public String delete(Model theModel) {
		List<Student> studentList = studentService.findAll();
		theModel.addAttribute("list", studentList);
		return "delete-form";

	}

}
