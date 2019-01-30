package shafiq.ur.rehman.asgn2.data;

import java.util.Collection;
import java.util.List;

import shafiq.ur.rehman.asgn2.dto.Course;
import shafiq.ur.rehman.asgn2.others.CourseNotFoundException;
import shafiq.ur.rehman.asgn2.others.DuplicateCourseException;

public class CourseManager implements CourseCatalog {

	@Override
	public Course getCourse(String courseCode) throws CourseNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course addCourse(Course course) throws DuplicateCourseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course deleteCourse(String courseCode) throws CourseNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course updateCourse(Course course) throws CourseNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	//additional fn - not from interface
	public Collection<Course> getAllCourses() {
		
		
		return null;
	}
	
	//return singleton
	public static CourseCatalog getInstance() {
		return courseCatalog;	
	}
	
	//There should be ONLY 1 copy of course catalog = singleton = class-variable
	public static CourseCatalog courseCatalog = new CourseManager();
}
