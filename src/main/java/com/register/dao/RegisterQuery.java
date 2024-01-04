package com.register.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisterQuery {

	public int insert(String name, String password, String city) throws ClassNotFoundException, SQLException {
        Connection con = DbConnection.getConnect();
        String query="insert into login values('"+name+"','"+password+"','"+city+"')";
    	Statement st=con.createStatement();
    	int count=st.executeUpdate(query);
		return count;
        
    }
    
    public int update(String name, String password, String city) throws ClassNotFoundException, SQLException {
    	String query="update login set name='"+name+"',password='"+password+"',city='"+city+"' where name='"+name+"'";
    	Connection con=DbConnection.getConnect();
    	Statement st=con.createStatement();
    	int count=st.executeUpdate(query);
		return count;
    }
    
    public int delete(String name) throws ClassNotFoundException, SQLException {
    	String query="delete from login where name='"+name+"'";
    	Connection con=DbConnection.getConnect();
    	Statement st=con.createStatement();
    	int count=st.executeUpdate(query);
		return count;
    	
    }

    public ResultSet login(String uname, String pass) throws ClassNotFoundException, SQLException {
        
    		Connection con=DbConnection.getConnect();
            String query="SELECT * FROM login WHERE name='"+uname+"' AND password='"+pass+"'"; 
            
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query); 
            return rs;

           
        
    }
}