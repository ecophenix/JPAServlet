package io.github.dauphine.ecophenix.DevoirJPA.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import io.github.dauphine.ecophenix.DevoirJPA.entite.Comment;
import io.github.dauphine.ecophenix.DevoirJPA.utility.JPAUtility;
import io.github.dauphine.ecophenix.DevoirJPA.utility.TimeUtils;

@Stateless
public class CommentDAO {
	
	
	  // Injection du manager, qui s'occupe de la connexion avec la BDD
    @PersistenceContext( unitName = "jpaPU" )
    private EntityManager       em;
	private static CommentDAO instance = null;

	public static synchronized CommentDAO getInstance() throws Exception
	{
		if (instance == null) instance = new CommentDAO();
		return instance;
	}
	
	private List<Comment> comments;
	
	@SuppressWarnings("unchecked")
	public String allComments() throws Exception {
		EntityManager entityManager = JPAUtility.getEntityManager();
		StringBuilder sb=new StringBuilder();
		
		List<String> allComments=new ArrayList<String>();
		
		if(em!=null) {
			 comments=em.createNamedQuery("Comment.findAll")
		                .getResultList();
		}
		if(comments!=null) {
			for(Comment comment: comments) {
			
				sb.append(comment.getDescription());
				sb.append(";");
				sb.append(TimeUtils.toISO8601UTC(comment.getDate()));
				sb.append("\n");
				//allComments.add(sb.toString());
			}
		}
		
	
		return sb.toString();
	}


	public void addComment(Comment comment) throws Exception {
	
		EntityManager entityManager = JPAUtility.getEntityManager();	entityManager.getTransaction().begin();
	
		
		   try {
				
				if(em!=null) {
					em.persist(comment);
				}
	        } catch ( Exception e ) {
	            throw new Exception( e );
	        }
		
		if(entityManager!=null) {
			entityManager.persist(comment);
			entityManager.getTransaction().commit();
			entityManager.close();
			JPAUtility.close();		
			System.out.println("Entity saved.");
		}
	}
	



	
	
}
