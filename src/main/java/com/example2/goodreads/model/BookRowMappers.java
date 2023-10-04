package com.example2.goodreads.model;
import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;





public class BookRowMappers  implements RowMapper<Book> 
{
    
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException
	{
	    return new Book
	    		(
	    		rs.getInt("id"),
	    		rs.getString("name"),
	    		rs.getString("imageUrl")
	    		);
				
	}
}

	 	
	 


