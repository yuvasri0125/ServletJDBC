package com.in.kce.book.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.in.kce.book.bean.AuthorBean;
import com.in.kce.book.util.DBUtil;


public class AuthorDAO {
	public AuthorBean getAuthor(int authorCode) {
		
			  AuthorBean author = null;

			    try {
			        Connection con = DBUtil.getDBConnection();  
			        String query = "SELECT * FROM Author_tbl WHERE Author_code = ?";

			        PreparedStatement ps = con.prepareStatement(query);
			        ps.setInt(1, authorCode);

			        ResultSet rs = ps.executeQuery();

			        if (rs.next()) {
			            AuthorBean authorBean= new AuthorBean();

			            authorBean.setAuthor(rs.getInt("Author_code"));
			            authorBean.setAuthorName(rs.getString("Author_name"));
			            authorBean.setContactNo(rs.getLong("Contact_no"));
			            return authorBean;
			        }
			        else { 
			        	return null;
			        }

			    } catch (Exception e) {
			        e.printStackTrace();
			        
			    }
				return author;
		
 
	}
	
public AuthorBean getAuthor(String authorName) {
	
	  AuthorBean author = null;

	    try {
	        Connection con = DBUtil.getDBConnection();  
	        String query = "SELECT * FROM Author_tbl WHERE Author_Name = ?";

	        PreparedStatement ps = con.prepareStatement(query);
	        ps.setString(1, authorName);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            AuthorBean authorBean= new AuthorBean();

	            authorBean.setAuthor(rs.getInt("Author_code"));
	            authorBean.setAuthorName(rs.getString("Author_name"));
	            authorBean.setContactNo(rs.getLong("Contact_no"));
	            return authorBean;
	        }
	        else { 
	        	return null;
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        
	    }
		return author;


}
}


