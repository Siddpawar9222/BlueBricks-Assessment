package com.bluebricks.crudbackend.repository;




import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bluebricks.crudbackend.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	 
//	   @Query("Select u from User u where email=")
//	   User getUserByEmailAndPhone(String email , String phone) ;
	   
	    Optional<User>  findByEmailAndPhone(String email ,String name) ;
}