package shafiq.ur.rehman.asgn2.dto;
//data transfer obj
import shafiq.ur.rehman.asgn2.others.ImproperInputException;

public class Professor {
	private String firstName = null;
	private String middleName = null;
	private String lastName = null;

	public Professor( String firstName, String lastName)
			throws ImproperInputException {
		setFirstName(firstName);
		setLastName(lastName);
	}
	
	public Professor( String firstName, String middleName, String lastName)
			throws ImproperInputException {
		setFirstName(firstName);
		setMiddleName(middleName);
		setLastName(lastName);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) throws ImproperInputException {
		if (firstName == null || firstName.isEmpty()) {
			throw new ImproperInputException("Proressor must have a first name");
		}
		this.firstName = firstName;
	}

	public String getmiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) throws ImproperInputException {
		// middle name can be null or empty String
		this.middleName = middleName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) throws ImproperInputException {
		if (lastName == null || lastName.isEmpty()) {
			throw new ImproperInputException("Proressor must have a last name");
		}
		this.lastName = lastName;
	}

	//additional methods
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		String string = 
				String.format("First name: %s \n" 
							+ "Last name: %s \n"
				, this.getFirstName()
				, this.getLastName());
		
		return string;
	}

	public boolean equals(Professor p)
	{
		//test whether two [separate] instances are identical
		return p instanceof Professor
				&& this.getFirstName().equals(p.getFirstName())
				&& this.getLastName().equals(p.getLastName());
	}}
