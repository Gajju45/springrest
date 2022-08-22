package com.example.springrest.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springrest.dao.CourseDao;
import com.example.springrest.entity.Course;



// this my service
@Service
public class CourseServiceImpl implements CourseService {
	
	//class object create
	@Autowired
	private CourseDao coursedao;
	//List <Course> list;
	
	public CourseServiceImpl() {
//		list=new ArrayList<>();
//		list.add(new Course(111,"Java Programing"," This Course is based oops.."));
//		list.add(new Course(121,"Python Programing"," This Course is based ML & AI.."));

	}

	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		
		return coursedao.findAll();
	}

	@Override
	public Course getCourse(long courseId) {
		// TODO Auto-generated method stub
		
//		Course c=null;
//		for(Course course: list) {
//			if (course.getId()==courseId) {
//				c=course;
//				break;
//			}
//			
//		}
		return coursedao.getOne(courseId);
	}

	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		
		//list.add(course);
		coursedao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		
//		list.forEach(e->{
//			if (e.getId()==course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//				
//			}
//		});
		
		coursedao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
		// TODO Auto-generated method stub
		
		//list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		
		Optional<Course> entityCourse=coursedao.findById(parseLong);
		//			this.walletRepository.deleteById(walletId);

		if (entityCourse.isPresent()) {
			this.coursedao.deleteById(parseLong);
		}
		
		
	}
}
