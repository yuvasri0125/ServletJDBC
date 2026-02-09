package com.in.kce.book.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.in.kce.book.bean.BookBean;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		BookBean bookBean=(BookBean)session.getAttribute("book");
		out.print("<html><body>");
		out.print("<br><br>Book title: "+bookBean.getBookName());
		out.print("<br><br>Author Name: "+bookBean.getAuthor().getAuthorName());
		out.print("<br><br>Author Contact: "+bookBean.getAuthor().getContactNo());
		out.print("<br><br>Book Price: "+bookBean.getCost());
		out.print("<br><br>Book ISBN: "+bookBean.getIsbn());
		out.print("</body></html");
		
		
	}

}
