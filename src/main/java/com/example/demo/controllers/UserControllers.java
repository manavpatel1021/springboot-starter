package com.example.demo.controllers;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.CustomExceptionDemo;
import com.example.demo.mapper.UserMapper;
import com.example.demo.models.User;
import com.example.demo.models.UserEntity;
import com.example.demo.repository.UserRepository;


@RestController
//@RequestMapping(value = "/")
public class UserControllers 
{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	MessageSource source;
	
	@Autowired
	UserMapper userMapper;
	
	//create
	@PostMapping(value = "/user" )
	public ResponseEntity<?> createUser(@RequestBody @Valid User user)	
	{
		
		UserEntity userEntity = userMapper.fromDto(user);
		userRepository.save(userEntity);
		return ResponseEntity.ok("Added..");

		
//		return "created...";
	}
	
	
	//get all
	@GetMapping(value = "/all")
	public List<User> getAllUser()
	{
		List<User> userList = userMapper.toDtos(userRepository.findAll());
		return userList;
	}
	
	
	
	
	//get by id
	@GetMapping(value = "/user/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id,@RequestHeader(name ="Accept-Language" , defaultValue = "en")Locale locale)
	{
		
		 User user = userRepository.findById(id).map(m->userMapper.toDto(m)).orElse(null);
		
		
		return ResponseEntity.ok(user);
		
		
		
			
			
//			return ResponseEntity.ok(byId);
//			return (ResponseEntity<List<User>>) byId;
		
		
//		throw new RuntimeException("user not found");
		
//		return ResponseEntity.notFound().build();
//		return  null;
	}
	
	//by name
	
	@GetMapping(value = "/byname/{first_name}")
	public List<User> getByName(@PathVariable(value = "first_name") String firstName)
	{
		List<UserEntity> userList = userRepository.findByFirstName(firstName);
		
		List<User> byName = userMapper.toDtos(userList);
		return byName;
		
	}
	
	//delete
//	@DeleteMapping(value = "/delete/{id}")
//	public String delete(@PathVariable int id)
//	{
//		for(User user : userList)
//		{
//			if(user.getId() == id)
//			{
//				userList.remove(user);
//			}
//		}
//		return "Deleted...";
//		
//	}
//	@PostMapping(value = "/update/{id}")
//	public String update(@PathVariable int id, @RequestParam String name)
//	{
//		for(User user : userList)
//		{
//			if(user.getId() == id)
//			{
//				userList.remove(user);
//				user.setFirstName(name);
//				userList.add(user);
//				
//			}
//		}
//		return "updated...";
//	}

	
	@ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity<?> handleRuntimeException(RuntimeException e)
	{	
		return ResponseEntity.notFound().build();
	}
	
	
	@ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity<?> handleCustomException(CustomExceptionDemo e)
	{
		return ResponseEntity.ok("");
	}
}
