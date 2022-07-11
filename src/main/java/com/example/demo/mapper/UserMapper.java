package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.example.demo.models.User;
import com.example.demo.models.UserEntity;

@Mapper(componentModel = "spring" , unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
	
	User toDto(UserEntity user);
	
	UserEntity fromDto(User user);
	
	List<User> toDtos(List<UserEntity> user);
	
	List<UserEntity> fromDtos(List<User> user);

}
