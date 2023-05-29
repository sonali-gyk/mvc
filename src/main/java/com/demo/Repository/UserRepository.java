package com.demo.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.model.User;

@Repository
public class UserRepository {

	@Autowired 
	private HibernateTemplate ht;
	
	@Transactional
	public int adduser(User user)
	{
		int a=(Integer) ht.save(user);
		System.out.println("repo");
		return a;
	}
	
	@Transactional
	public List<User> listOfUser()
	{
		return ht.loadAll(User.class);
	}
	
}
