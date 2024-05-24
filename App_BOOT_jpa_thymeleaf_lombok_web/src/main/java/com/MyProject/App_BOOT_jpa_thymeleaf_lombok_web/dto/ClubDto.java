package com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.dto;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClubDto {
	
	
	private long Id;
	
	@NotEmpty (message = "non può essere vuoto")
	private String title;
	@NotEmpty (message = "non può essere vuoto")
	private String photourl;
	@NotEmpty (message = "non può essere vuoto")
	private String content;
	
	private LocalDateTime createdin;
	private LocalDateTime updatedon;
	
	
	

}
