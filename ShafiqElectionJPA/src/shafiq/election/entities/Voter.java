package shafiq.election.entities;

import java.io.Serializable;
import javax.persistence.*;
import shafiq.election.exceptions.*;

import shafiq.election.entities.PersonsName;
import shafiq.election.entities.Voter;

/**
 * Entity implementation class for Entity: Voter
 *
 */
@Entity
@Table(name = "voter", schema = "ELECTION")
public class Voter implements Serializable//whole obj can b serialized & passed into session & retreived later from session
{

	
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY ) 
	@Column(name="VPK")
	private int vid; 
	
	@Embedded //@Embeddable on class def
	@AttributeOverrides(value = {//https://www.callicoder.com/hibernate-spring-boot-jpa-embeddable-demo/
			@AttributeOverride(name = "firstName", column = @Column(name = "FIRST_NAME")),
			@AttributeOverride(name = "lastName", column = @Column(name = "LAST_NAME"))
	})
	private PersonsName voterName;
	
	@Column(name="PASSWORD") 
	private String password;  
	
	@Column(name="VOTED") 
	boolean voted;
	
	public Voter() {
		super();
	}
	
	public int getVid() {
		return vid;
	}
	
	public void setVid(int vid) {
		this.vid = vid;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) throws DataInputException {
		if ( password == null || password.trim().isEmpty() ) {
			throw new DataInputException ("Attempt to create voter with no student number");
		}
		this.password = password.trim();
	}
	public PersonsName getVoterName() {
		return voterName;
	}
	
	public void setVoterName (PersonsName name) throws DataInputException {
		if ( name == null ) {
			throw new DataInputException( "A person must have a name");
		}
		this.voterName = name;
	}

	public boolean hasVoted() {
		return isVoted();
	}
	
	public boolean isVoted() {
			return voted;	
	}	

	public void setVoted(boolean voted) {
		this.voted = voted;
	}

	@Override
	public String toString() {
		if (isVoted() ) {
			return vid + ": " + voterName + " has Voted";
		} else {
			return vid + ": " + voterName + " has not Voted";
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + vid;
		result = prime * result + (voted ? 1231 : 1237);
		result = prime * result + ((voterName == null) ? 0 : voterName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voter other = (Voter) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (vid != other.vid)
			return false;
		if (voted != other.voted)
			return false;
		if (voterName == null) {
			if (other.voterName != null)
				return false;
		} else if (!voterName.equals(other.voterName))
			return false;
		return true;
	}
   
}
