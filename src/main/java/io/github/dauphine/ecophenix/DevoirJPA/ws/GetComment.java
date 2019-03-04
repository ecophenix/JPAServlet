package io.github.dauphine.ecophenix.DevoirJPA.ws;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;

import io.github.dauphine.ecophenix.DevoirJPA.dao.CommentDAO;
 
@WebServlet(
        name = "GetCommentServlet",
        description = "Retourne les commentaires",
        urlPatterns = "/comments/all"
)
public class GetComment extends HttpServlet {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	  // Injection de notre EJB (Session Bean Stateless)
    @EJB
    private CommentDAO   commentDAO;

	

	@SuppressWarnings("unused")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException,IOException {
			 
		 try
			{
			 response.setContentType("text/plain;charset=UTF-8");
			 String c=commentDAO.allComments();
			 String comments=CommentDAO.getInstance().allComments();
			 
			 if(StringUtils.isEmpty(comments)) {
				 response.getWriter().println("OK");
			 }else {
				 response.getWriter().println(comments);
			 }	 
			}
			catch (Exception e){
				e.printStackTrace();
			}
	    }
}