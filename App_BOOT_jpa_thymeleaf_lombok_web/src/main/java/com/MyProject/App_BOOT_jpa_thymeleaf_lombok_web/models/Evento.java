package com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="evento")
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotEmpty (message = "non può essere vuoto")
	private String photourl;
	@NotEmpty (message = "non può essere vuoto")
	private String contenuto;
	@NotEmpty (message = "non può essere vuoto")
	private String nome;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm" )
	@NotNull(message = "non può essere vuoto")
	private LocalDateTime starttime;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm" )
	@NotNull(message = "non può essere vuoto")
	private LocalDateTime endtime;
	@CreationTimestamp
	private LocalDateTime createdin;
	@UpdateTimestamp
	private LocalDateTime updatedon;
	
	@ManyToOne
	@JoinColumn(name = "club_id", nullable=false)
	private Club club;
	
			/*
			 * create table evento(
		id int auto_increment primary key,
		name varchar(45) not null,
		starttime date not null,
		endtime date not null,
		createdIn date not null,
		updatedOn date not null,
		club_id int not null,
		foreign key (club_id) references club.id
		);
		*/
	

}
