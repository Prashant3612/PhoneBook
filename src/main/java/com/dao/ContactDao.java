package com.dao;

import java.sql.Connection;

import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.Contact;

public class ContactDao {
	private Connection conn;

	public ContactDao(Connection conn) {
		super();
		this.conn=conn;
		// TODO Auto-generated constructor stub
	}
	
	public boolean saveContact(Contact c) {
		boolean f=false;
		try {
			String sql="insert into contact(name,email,phoneNo,about,userid) values(?,?,?,?,?)";
			PreparedStatement ptm=conn.prepareStatement(sql);
			ptm.setString(1,c.getName());
			ptm.setString(2,c.getEmail());
			ptm.setString(3,c.getPhno());
			ptm.setString(4,c.getAbout());
			ptm.setInt(5,c.getUserId());
			
			int i=ptm.executeUpdate();
			if(i==1) {
				f=true;
			}
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return f;
	}
	public List<Contact> getAllContact(int uId){
		List<Contact> list=new ArrayList<Contact>();
		Contact c=null;
		try {
			String sql="select * from contact where userid=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, uId);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				c=new Contact();
				c.setId(rs.getInt(1));
				c.setEmail(rs.getString(3));
				c.setPhno(rs.getString(4));
				c.setAbout(rs.getString(5));
				c.setName(rs.getString(2));
				list.add(c);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}return list;
		
	}
	public Contact getContactByID(int cid) {
		Contact c=new Contact();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from contact where id=?");
			ps.setInt(1,cid);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setPhno(rs.getString(4));
				c.setAbout(rs.getString(5));
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return c;
	}
	public boolean updateContact(Contact c) {
		boolean f=false;
		try {
			String sql="update contact set name=?,email=?,phoneNo=?,about=? where id=?";
			PreparedStatement ptm=conn.prepareStatement(sql);
			ptm.setString(1,c.getName());
			ptm.setString(2,c.getEmail());
			ptm.setString(3,c.getPhno());
			ptm.setString(4,c.getAbout());
			ptm.setInt(5,c.getUserId());
			
			int i=ptm.executeUpdate();
			System.out.println(i);
			if(i==1) {
				f=true;
			}
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return f;
	}
	public boolean deleteContactById(int id) {
		boolean f=false;
	try {
		String sql="delete from contact where id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1,id);
		int i=ps.executeUpdate();
		
	
		if(i==1) {
			f=true;
		}
		
		
		
	}catch(Exception e){
		e.printStackTrace();
	}
	return f;
}
}
