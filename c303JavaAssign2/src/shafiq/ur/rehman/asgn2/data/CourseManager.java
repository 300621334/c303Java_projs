package shafiq.ur.rehman.asgn2.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import shafiq.ur.rehman.asgn2.dto.Course;
import shafiq.ur.rehman.asgn2.others.CourseNotFoundException;
import shafiq.ur.rehman.asgn2.others.DuplicateCourseException;

public class CourseManager implements CourseCatalog {

	//to keep unique course codes, I choose map collection
	private static Map<String, Course> allCoursesMap = new HashMap<String, Course>();
	
	@Override
	public Course getCourse(String courseCode) throws CourseNotFoundException {
		if(allCoursesMap.containsKey(courseCode)) {
			return allCoursesMap.get(courseCode);
		}
		throw new CourseNotFoundException(courseCode + txtCourseNotFound);
	}

	@Override
	public Course addCourse(Course course) throws DuplicateCourseException {
		//duplicate course-codes in catalog are NOT allowed
		if(!allCoursesMap.containsKey(course.getCourseCode())) {
			allCoursesMap.put(course.getCourseCode(), course);
			return course; //allCoursesMap.get(course.getCourseCode()); //return newly added course;
		}
		else {
			throw new DuplicateCourseException("Catalog already has this course-code: " + course.getCourseCode());
		}
	}

	@Override
	public Course deleteCourse(String courseCode) throws CourseNotFoundException {
		//Course copyOfDeletedCourse = new Course(courseCode);
		
		if(allCoursesMap.containsKey(courseCode)) {
			//copy populated with title
			//copyOfDeletedCourse.setCourseTitle(allCoursesMap.get(courseCode).getCourseTitle());
			
			//remove course from catalog
			allCoursesMap.remove(courseCode);
			
			//return copy
			return null;
		}
		throw new CourseNotFoundException(String.format("Course-code %s not found!", courseCode));
	}

	@Override
	public Course updateCourse(Course course) throws CourseNotFoundException {
		if(allCoursesMap.containsKey(course.getCourseCode())) {
			allCoursesMap.put(course.getCourseCode(), course);
			return course;
		}
		throw new CourseNotFoundException(course.getCourseCode() + txtCourseNotFound);
	}

	//additional fn - not from interface
	public Collection<Course> getAllCourses() {
		List<Course> allCoursesList = new ArrayList<Course>();
		allCoursesList.addAll(allCoursesMap.values());
		return allCoursesList;
	}
	
	//return singleton
	public static CourseCatalog getInstance() {
		return courseCatalog;	
	}
	
	//There should be ONLY 1 copy of course catalog = singleton = class-variable
	private static CourseCatalog courseCatalog = new CourseManager();
	private static String txtCourseNotFound = " Course-code doesn't exist!";
}
