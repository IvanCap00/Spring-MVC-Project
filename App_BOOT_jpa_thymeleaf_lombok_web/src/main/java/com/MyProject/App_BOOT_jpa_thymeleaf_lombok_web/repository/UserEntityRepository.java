package com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.models.Userentity;

public interface UserEntityRepository extends JpaRepository<Userentity, Long> {
	
	Optional<Userentity>  findByUsername(String user);

}
