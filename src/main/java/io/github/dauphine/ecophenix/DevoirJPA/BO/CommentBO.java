package io.github.dauphine.ecophenix.DevoirJPA.BO;

import java.util.List;
import javax.persistence.EntityManager;
import io.github.dauphine.ecophenix.DevoirJPA.entite.Comment;
import io.github.dauphine.ecophenix.DevoirJPA.utility.JPAUtility;

public class CommentBO {
	
	private static CommentBO instance = null;

	public static synchronized CommentBO getInstance() throws Exception
	{
		if (instance == null) instance = new CommentBO();
		return instance;
	}

	//@PersistenceContext(unitName = "EclipseLink_NamedQuery-ejbPU")
   // private EntityManager em;
	
	private List comments;
	
	public List allComment() throws Exception {
		EntityManager entityManager = JPAUtility.getEntityManager();
		
		if(entityManager!=null) {
			 comments=entityManager.createNamedQuery("Comment.findAll")
		                .getResultList();
		}		 
		return comments;
	}


	public void addComment(Comment comment) throws Exception {
	
		EntityManager entityManager = JPAUtility.getEntityManager();	entityManager.getTransaction().begin();
		
		if(entityManager!=null) {
			entityManager.persist(comment);
			entityManager.getTransaction().commit();
			entityManager.close();
			JPAUtility.close();		
			System.out.println("Entity saved.");
		}
	}
	



	
	
}
