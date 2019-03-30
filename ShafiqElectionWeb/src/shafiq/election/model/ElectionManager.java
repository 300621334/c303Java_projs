package shafiq.election.model;

import java.io.PrintStream;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import shafiq.election.entities.Candidate;
import shafiq.election.entities.Voter;
import shafiq.election.exceptions.ElectionException;
import shafiq.election.exceptions.DataInputException;
/*Because the Web project and JPA project are in the same EAR, resolving references (or dependencies) from one project to another should require only import statements.*/

public class ElectionManager { 
	
	EMFSupplier emfSupplier;
	EntityManagerFactory emFactory;
	EntityManager em;
	
    public ElectionManager() {
    	emfSupplier = EMFSupplier.getInstance();// Singleton
		emFactory = emfSupplier.getEMF();// Singleton
		em = emFactory.createEntityManager();
    }
    
    // user login: returns a Voter if user authenticated or null otherwise 
    //file LoginServlet.java >> Voter voter = electionManager.authenticateVoter(vid, password);
	public Voter authenticateVoter(int voterId, String password) throws ElectionException  {
		    // complete this method to return either an authenticated Voter or null

		
		//1st letter of Voter MUST be cap... v.VPK (db col) cannot be used, instead use EntityBean's field v.vid... else following errs resp
		//QuerySyntaxException: voter is not mapped [select v from voter v WHERE v.VPK = 301]
		//QueryException: could not resolve property: VPK of: shafiq.election.entities.Voter [select v from shafiq.election.entities.Voter v WHERE v.VPK = 301]
		String sqlStr = "select v from Voter v WHERE v.vid = " + voterId;//select * from candidate; will err
		
		//Query query = em.createQuery(sqlStr);//Type safety: Unchecked cast from List to List<Candidate>
		//https://www.objectdb.com/java/jpa/query/named
		TypedQuery<Voter> query = em.createQuery(sqlStr, Voter.class);//db resultset cast to objs
		Voter voter = query.getSingleResult();
		
		if(voter != null)
		{
			if(voter.getPassword().equals(password))
			{
				return voter;
			}
		}
		return null;
	}

	// user votes: set Voter.hasVoted to true or 1 and 1 to count of votes for the candidate
	//File VoteServlet.java >> electionManager.castBallot(voter, candidate);//Voter is the logged-in person
	public void castBallot(Voter v, Candidate c ) throws ElectionException, DataInputException 
	{
	// complete this method process one ballot form throw exceptions as appropriate
		
		/*Increment CVOTE for this Candidate on tbl CANDIDATE & UPDATE CVOTE new value*/
		em.getTransaction().begin();
		Candidate candidateFromDb = em.find(Candidate.class, c.getCid() );
		candidateFromDb.setVotes(candidateFromDb.getVotes() + 1);
		em.getTransaction().commit();
		
		
		/*Get CVOTE col for this candidate*/
		/*String sqlStr = "select v from Voter v WHERE v.vid = " + v.getVid();
		TypedQuery<Voter> query = em.createQuery(sqlStr, Voter.class);
		Voter voter = query.getSingleResult();*/
		em.getTransaction().begin();
		Voter voterFromDb = em.find(Voter.class, v.getVid());
		voterFromDb.setVoted(true);
		em.getTransaction().commit();
		
		
		
		
		
//		em.getTransaction().begin();//If any operations write to the database, enclose those operations in a transaction, using an object of type EntityTransaction.  
////        Todo todo = new Todo();
////        todo.setSummary("This is a test");
////        todo.setDescription("This is a test");
//        em.persist(null);
//        em.getTransaction().commit();
//
//        /*Get the voter from VOTER tbl*/
//        
//        /*Update VOTED col to TRUE on VOTER tbl for this voter*/
//        em.getTransaction().begin();//If any operations write to the database, enclose those operations in a transaction, using an object of type EntityTransaction.  
//
//        em.persist(null);
//        em.getTransaction().commit();
//        
//        em.close();
        
		return;
	}
	
	// for testing and debugging only: 
	// print current vote count for each candidate to the server console 	
	public void printVoteCount(PrintStream out) throws ElectionException {
	// complete this method
		return;
	}
}
