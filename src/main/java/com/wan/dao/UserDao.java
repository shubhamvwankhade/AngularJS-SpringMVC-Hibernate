package com.wan.dao;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wan.model.UserDetails;
@Repository
@Transactional
public class UserDao 
{
	@Autowired
	public SessionFactory sessionfactory;
	
	public void addUser(UserDetails usr)
	{
		sessionfactory.getCurrentSession().save(usr);
	}
	
	public List<UserDetails> getAllUsers()
	{
		
		System.out.println("request to get user details");
		return sessionfactory.getCurrentSession().createCriteria(UserDetails.class).list();
	}
	
	public void deleteUser(UserDetails usr)
	{
		System.out.println("delete madhe ala re");
	
		sessionfactory.getCurrentSession().delete(usr);
	}
	
	public void editUser(UserDetails usr)
	{
		System.out.println("edit madhe ala re");
	
		sessionfactory.getCurrentSession().update(usr);;
	}
}
