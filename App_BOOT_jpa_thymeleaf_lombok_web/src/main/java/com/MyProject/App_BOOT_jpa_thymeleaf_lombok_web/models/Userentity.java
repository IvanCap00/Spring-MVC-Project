package com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.GeneratorType;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="userentity")
public class Userentity {
			/*
			 * create table userEntity(
		id INT NOT NULL AUTO_INCREMENT,
		nome_utente VARCHAR(45) NOT NULL,
		pass_word varchar(45),
		email VARCHAR(75) NOT NULL
		);
			 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotEmpty(message="non può esssere vuoto")
	private String username;
	@NotEmpty(message="non può esssere vuoto")
	private String pass_word;
	@NotEmpty(message="non può esssere vuoto")
	private String role;

}
