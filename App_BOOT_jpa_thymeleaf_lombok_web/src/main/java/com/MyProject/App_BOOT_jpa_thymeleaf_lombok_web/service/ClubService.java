package com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.service;

import java.util.List;

import com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.dto.ClubDto;
import com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.models.Club;

import jakarta.validation.Valid;

public interface ClubService {
	List<ClubDto> findallClubs();
	
	Club saveClub( Club club);

	ClubDto findClubById(long clubId);

	void updateclub(ClubDto club);

	void delete(long clubId);
		
	List<ClubDto> searchClubs (String query);
	
	Club findNonDtoClubById(long id);
}
