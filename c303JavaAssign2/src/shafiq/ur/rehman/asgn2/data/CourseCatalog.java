package shafiq.ur.rehman.asgn2.data;
//interface defines behavior of Business Logic

import shafiq.ur.rehman.asgn2.dto.Course;
import shafiq.ur.rehman.asgn2.others.CourseNotFoundException;
import shafiq.ur.rehman.asgn2.others.DuplicateCourseException;

public interface CourseCatalog {
	   
	public Course getCourse(String courseCode) 
			throws CourseNotFoundException;
	   
	public Course addCourse(Course course) 
			throws DuplicateCourseException;
	   
	public Course deleteCourse(String courseCode)
	          throws CourseNotFoundException;
	   
	public Course updateCourse(Course course) 
			throws CourseNotFoundException;

}
