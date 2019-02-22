package shafiq.ur.rehman.asgn2.dto;
//data transfer obj
import java.io.Serializable;
import shafiq.ur.rehman.asgn2.others.ImproperInputException;

public class Course implements Serializable {

	private static final long serialVersionUID = 1L;
	private String courseCode;
	private String courseTitle;
	private Professor professor;

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) throws ImproperInputException {
		if ( courseCode == null || courseCode.isEmpty() ) {
			throw new ImproperInputException("Course must have a course code");
		}
		courseCode.toUpperCase();
		if ( ! courseCode.matches("[A-Z]{3,4} ?[0-9]{3,4}" ) ) {
			throw new ImproperInputException(
				"Course code must be 3 or 4 letters followed by 3 or 4 digits" );
		}
		this.courseCode = courseCode;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		// assume a course can have an empty or null title
		this.courseTitle = courseTitle;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		// professor can be null when professor not assigned
		this.professor = professor;
	}

	//Java doesn't support default-values for params. Alt is Builder-Pattern (but that's equally wordy!!!): 
	//https://stackoverflow.com/questions/222214/managing-constructors-with-many-parameters-in-java/222295#222295
	//https://stackoverflow.com/a/997883
	public Course( String courseCode) throws ImproperInputException {
		super();
		setCourseCode(courseCode);
	}
	
	public Course(String courseCode, String courseTitle) throws ImproperInputException  {
		this( courseCode );
		setCourseTitle(courseTitle);
	}
	
	public Course(String code, String title, Professor professor) throws ImproperInputException   {
		this(code,title);
		this.professor = professor;
}

	
	//additional methods
	@Override
	public String toString() {
		//StringBuilder stringBuilder = new StringBuilder();
		String string = 
				String.format("\n"
							+ "Course Code: %s \n" 
							+ "Course Title: %s \n"
							+ "Professor: %s %s"
				, this.getCourseCode()
				, this.getCourseTitle()
				, this.getProfessor() !=null?this.getProfessor().getFirstName():"" //professor could be null
				, this.getProfessor() !=null?this.getProfessor().getLastName():"");
		
		return string;
		
	}

	public boolean equals(Course course)
	{
		//test whether two [separate] instances are identical
		return course instanceof Course
				&& this.getCourseCode().equals(course.getCourseCode())
				&& this.getCourseTitle().equals(course.getCourseTitle());
	}
}
