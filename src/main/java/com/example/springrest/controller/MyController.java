package com.example.springrest.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springrest.entity.Course;
import com.example.springrest.services.CourseService;

import java.util.List;

@RestController
public class MyController {

	@Autowired
	private CourseService courseService;
//	@GetMapping("/home")
//	public String home() {
//		
//		return "This is home page";
//		
//	}

	// get the coursers

	@GetMapping("/courses")
	public List<Course> getCourses() {
		return this.courseService.getCourses();
	}
	
	//Single course get
	@GetMapping("/courses/{courseId}")
	//single use for pathVariable
	public Course getCourse(@PathVariable String courseId) {
		return this.courseService.getCourse(Long.parseLong(courseId));

	}
	
	//course add
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.updateCourse(course);
		
	}
	
	//course update PUT Request..
	@PutMapping("/courses")
	public Course UpdateCourse(@RequestBody Course course) {
		return this.courseService.updateCourse(course);
		
	}
	
	//delete the course
	
	@DeleteMapping("courses/{courseId}")
	
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
		try {

			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	

}
