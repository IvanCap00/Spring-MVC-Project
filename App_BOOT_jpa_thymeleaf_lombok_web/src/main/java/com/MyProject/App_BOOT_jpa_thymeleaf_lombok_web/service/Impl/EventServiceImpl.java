package com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.service.Impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.dto.EventoDto;
import com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.models.Club;
import com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.models.Evento;
import com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.repository.ClubRepository;
import com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.repository.EventoRepository;
import com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.service.ClubService;
import com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.service.EventService;

import io.micrometer.observation.Observation.Event;

@Service
public class EventServiceImpl implements EventService {
	private EventoRepository eventorepsoitory;
	private ClubRepository clubrepository;
	
	
	
	@Autowired
	public EventServiceImpl(EventoRepository eventorepsoitory, ClubRepository clubrepository) {
		super();
		this.eventorepsoitory = eventorepsoitory;
		this.clubrepository = clubrepository;
	}




	@Override
	public void createEvent(Long clubid, EventoDto eventodto) {
		Club byId = clubrepository.findById(clubid).get();
		Evento event = maptoEvento(eventodto);
		event.setClub(byId);
		eventorepsoitory.save(event);
		
		
	}




	private Evento maptoEvento(EventoDto eventodto) {
		// TODO Auto-generated method stub
		return Evento.builder()
				.id(eventodto.getId())
				.photourl(eventodto.getPhotourl())
				.contenuto(eventodto.getContenuto())
				.nome(eventodto.getNome())
				.starttime(eventodto.getStarttime())
				.endtime(eventodto.getEndtime())
				.createdin(eventodto.getCreatedin())
				.updatedon(eventodto.getUpdatedon())
				
				.build();
				
	}




	@Override
	public List<EventoDto> findallEvents() {
		List<Evento> allEventi = eventorepsoitory.findAll();
		return allEventi.stream().map((event)->mapToEventoDto(event)).collect(Collectors.toList());
		
	}




	private EventoDto mapToEventoDto(Evento evento) {
		// TODO Auto-generated method stub
		return EventoDto.builder()
				.id(evento.getId())
				.photourl(evento.getPhotourl())
				.contenuto(evento.getContenuto())
				.nome(evento.getNome())
				.starttime(evento.getStarttime())
				.endtime(evento.getEndtime())
				.createdin(evento.getCreatedin())
				.updatedon(evento.getUpdatedon())
				
				.build();
	}



	public List<EventoDto> cercaLista(long club_id){
		Club byId = clubrepository.findById(club_id).get();
		List<Evento> allEventi = byId.getEventi();
		return allEventi.stream().map((event)->mapToEventoDto(event)).collect(Collectors.toList());
		
	}




	@Override
	public void deleteEvent(long eventId) {
		Evento event = eventorepsoitory.findById(eventId).get();
		eventorepsoitory.delete(event);
		// TODO Auto-generated method stub
		
	}




	@Override
	public EventoDto findEventoById(long id) {
		// TODO Auto-generated method stub
		Evento byId = eventorepsoitory.findById(id).get();
		
		return mapToEventoDto(byId);
	}




	@Override
	public void updateEvent(EventoDto eventdto, Club club) {
		// TODO Auto-generated method stub
		Evento maptoEvento = maptoEvento(eventdto);
		maptoEvento.setClub(club);
		eventorepsoitory.save(maptoEvento);
		
	}

	

}
