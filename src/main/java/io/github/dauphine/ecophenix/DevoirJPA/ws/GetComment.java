package io.github.dauphine.ecophenix.DevoirJPA.ws;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.github.dauphine.ecophenix.DevoirJPA.BO.CommentBO;
 
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
	

	@SuppressWarnings("unused")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws IOException {
			 
		 try
			{
			 List comments=CommentBO.getInstance().allComment();
			 
			 response.getWriter().println("Hello");
			}
			catch (Exception e){
				e.printStackTrace();
			}
	    }
}