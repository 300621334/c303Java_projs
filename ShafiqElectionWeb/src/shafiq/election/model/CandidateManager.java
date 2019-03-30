package shafiq.election.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import shafiq.election.entities.Candidate;
import shafiq.election.exceptions.CandidateException;


public class CandidateManager { 
	
    public CandidateManager() {
        super();
    }
    
    // First four methods do not need to be implemented because 
    // they not required in this exercise. However they would be 
    // implemented in a more generic bean used in other situations.
    
    public Candidate getCandidate(String CandidateCode) throws CandidateException {
    	// method not required for this exercise
    	return null;
    }
    
    public Candidate addCandidate(Candidate candidate) throws CandidateException {
    	// method not required for this exercise
    	return null;
    }
    
    public Candidate deleteCandidate(String CandidateCode) throws CandidateException {
    	// method not required for this exercise
    	return null;
    }
    
    public Candidate updateCandidate(Candidate Candidate) throws CandidateException {
    	// method not required for this exercise
    	return null;
    }
    
    // returns candidate information used to generate buttons on the ballot form
	public List<Candidate> getCandidates() {
		// complete this method and modify the next line to 
		// return a list of candidates
		
		//move to constructor when implementing other methods============
		EMFSupplier emfSupplier = EMFSupplier.getInstance();// Singleton
		EntityManagerFactory emFactory = emfSupplier.getEMF();// Singleton
		EntityManager em = emFactory.createEntityManager();
		//===============================================================
		
		String sqlStr = "select c from Candidate c";//select * from candidate; will err
		//Query query = em.createQuery(sqlStr);//Type safety: Unchecked cast from List to List<Candidate>
		//https://www.objectdb.com/java/jpa/query/named
		TypedQuery<Candidate> query = em.createQuery(sqlStr, Candidate.class);//db resultset cast to objs
		List<Candidate> resultSet = query.getResultList();
		return resultSet;
	}
}
