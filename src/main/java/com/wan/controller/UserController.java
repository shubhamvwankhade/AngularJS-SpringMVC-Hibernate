package com.wan.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.wan.dao.UserDao;
import com.wan.model.UserDetails;

@RestController
public class UserController
{
    @Autowired
	public UserDao usrd;
	
	public Gson gson=new Gson();
    
    public UserController()
    {
    	System.out.println("------construcor UserController----");
       
    }
    
	
    @RequestMapping(value="/userdetails",method=RequestMethod.GET,produces="application/json")
    public String GetUserdetails()
    {
    	
    	System.out.println("------getuserdetails----");
    	
    
		List<UserDetails> lst=usrd.getAllUsers();
		String response=gson.toJson(lst);
		System.out.println(response);
		
    	for(UserDetails user:lst)
    	{
    		System.out.println(user);
    	}
    	
    	return response;
        
    }
    
    @RequestMapping(value="/user",consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    @ResponseBody
    public String ProcessUser(@RequestBody UserDetails usr)
    {
    	System.out.println("------adduser----");
    	
    	
    	
		usrd.addUser(usr);
		return gson.toJson(usr);
    	
    }
    
    @RequestMapping(value="/deleteuser",consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
   
    public ResponseEntity DeleteUser(@RequestBody UserDetails usr)
    {
    	System.out.println("------delete----");
    	
    	usrd.deleteUser(usr);
       
        return new ResponseEntity(HttpStatus.OK);
    }
    
   
    @RequestMapping(value="/editUser",consumes=MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.POST)
    @ResponseBody
    public String EditUser(@RequestBody UserDetails usr)
    {
    	System.out.println("------editUser----");
    	System.out.println(usr);
    	
    	usrd.editUser(usr);
    	System.out.println("after edit "+usr);
    	
  return  gson.toJson(usr);
    }
}