package com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.dto;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;



import jakarta.validation.Constraint;
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

public class EventoDto {
	private long id;
	@NotEmpty(message="non può esssere vuoto")
	private String photourl;
	@NotEmpty (message = "non può essere vuoto")
	private String contenuto;
	@NotEmpty (message = "non può essere vuoto")
	private String nome;
	@NotNull(message = "non può essere vuoto")
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm" )
	private LocalDateTime starttime;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm" )
	private LocalDateTime endtime;
	
	@CreationTimestamp
	private LocalDateTime createdin;
	@UpdateTimestamp
	private LocalDateTime updatedon;

}
