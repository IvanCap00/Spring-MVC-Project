package com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.models.Club;

public interface ClubRepository extends JpaRepository<Club, Long>{
	Optional<Club> findByTitle(String title);
	
	
	
	// questa  è una query parametrica in JPQL
	@Query("SELECT c FROM Club c WHERE c.title LIKE CONCAT('%', :query, '%')")
	List<Club> searchClubs (String query);
}
