package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.example.demo.models.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	
	List<UserEntity> findByFirstName(String firstName);

}
