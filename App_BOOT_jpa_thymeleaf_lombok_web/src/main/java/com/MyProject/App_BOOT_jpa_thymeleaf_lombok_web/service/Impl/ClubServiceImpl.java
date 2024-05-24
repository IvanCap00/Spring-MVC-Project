package com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.dto.ClubDto;
import com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.models.Club;
import com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.repository.ClubRepository;
import com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.service.ClubService;

@Service
public class ClubServiceImpl implements ClubService{
	private ClubRepository clubrepository;
	
	@Autowired
	public ClubServiceImpl(ClubRepository clubrepository) {
		super();
		this.clubrepository = clubrepository;
	}



	@Override
	public List<ClubDto> findallClubs() {
		List<Club> list = clubrepository.findAll();
		return list.stream().map((club)->mapToClubDto(club)).collect(Collectors.toList());
	}
	
	private ClubDto mapToClubDto(Club club) {
		ClubDto clubDto = ClubDto.builder()
				.Id(club.getId())
				.title(club.getTitle())
				.photourl(club.getPhotourl())
				.content(club.getContent())
				.createdin(club.getCreatedin())
				.updatedon(club.getUpdatedon())
				.build();
		return clubDto;
	}



	@Override
	public Club saveClub(Club club) {
		// TODO Auto-generated method stub
		
		return clubrepository.save(club);
	}



	@Override
	public ClubDto findClubById(long clubId) {
		Club club = clubrepository.findById(clubId).get();
		return mapToClubDto(club);
	}



	@Override
	public void updateclub(ClubDto club) {
		// TODO Auto-generated method stub
		Club club1 = mapToClub(club);
		clubrepository.save(club1);
	}



	private Club mapToClub(ClubDto clubDto) {
		Club club = Club.builder()
				.Id(clubDto.getId())
				.title(clubDto.getTitle())
				.photourl(clubDto.getPhotourl())
				.content(clubDto.getContent())
				.createdin(clubDto.getCreatedin())
				.updatedon(clubDto.getUpdatedon())
				.build();
		return club;
	}



	@Override
	public void delete(long clubId) {
		clubrepository.deleteById(clubId);
		
	}



	@Override
	public List<ClubDto> searchClubs(String query) {
		// TODO Auto-generated method stub
		List<Club> list = clubrepository.searchClubs(query);
		
		return list.stream().map((club)->mapToClubDto(club)).collect(Collectors.toList());
	}



	@Override
	public Club findNonDtoClubById(long id) {
		// TODO Auto-generated method stub
		Club club = clubrepository.findById(id).get();
		return club;
	}




	

	
	
	
	

}
