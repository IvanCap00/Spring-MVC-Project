package com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="clubs")
public class Club {	
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	@NotEmpty (message = "non può essere vuoto")
	private String title;
	@NotEmpty (message = "non può essere vuoto")
	private String photourl;
	@NotEmpty (message = "non può essere vuoto")
	private String content;
	@CreationTimestamp
	private LocalDateTime createdin;
	@UpdateTimestamp
	private LocalDateTime updatedon;
	
	@OneToMany(mappedBy = "club", cascade = CascadeType.REMOVE)
	private List<Evento> eventi = new ArrayList<>();
	
	

}
