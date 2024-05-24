package com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.service;

import java.util.List;

import com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.dto.ClubDto;
import com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.dto.EventoDto;
import com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.models.Club;
import com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.models.Evento;

import io.micrometer.observation.Observation.Event;

public interface EventService {
	void createEvent(Long clubid, EventoDto event);
	
	List<EventoDto> findallEvents();
	
	List<EventoDto> cercaLista(long club_id);
	
	void deleteEvent(long eventId);
	
	EventoDto findEventoById(long id);
	
	void updateEvent(EventoDto eventdto, Club club);
	
	
	

}
