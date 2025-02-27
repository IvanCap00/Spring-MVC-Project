package com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.dto.ClubDto;
import com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.dto.EventoDto;
import com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.models.Club;
import com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.models.Evento;
import com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.service.ClubService;
import com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.service.EventService;
import com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.service.Impl.ClubServiceImpl;

import aj.org.objectweb.asm.Attribute;
import io.micrometer.observation.Observation.Event;
import jakarta.validation.Valid;

@Controller
public class ClubController {
	
	
	// questo è un esempio  di polimorfismo
	// lo stiamo chiamando per il nome del'interfaccia ma potresti chiamrlo anche ClubServiceimpl 
	// entrambe hanno il metodo findAllClubDto
	// ho provato e funzionano  entrambe
	private ClubService clubservice;
	private EventService eventservice;

	
	@Autowired
	public ClubController(ClubService clubservice , EventService eventservice) {
		super();
		this.clubservice = clubservice;
		this.eventservice = eventservice;
	}
	
	
	
	
	/*
	 * request.setAttribute("clubs",clubs);
	 * session.getRequestDispatcher(clubs-list.html).forward(request,response);
	 * questa sarebbe la servlet, il metodo getMapping sta facendo la stessa cosa
	 */
	@GetMapping("/clubs")
	public String listClubs(Model model) {
		List<ClubDto> clubs = clubservice.findallClubs();
		model.addAttribute("clubs",clubs);
		return "clubs-list";
	}
	
	
	//il metodo @GetMapping e @RequestMapping(method = requestMethod.Get)
	//fanno la stessa cosa ovvero mappano il perscorso a un url, fanno la stessa cosa della servlet
	//questo metodo sta dicendo "quando accedi all'URL loclahost8080/clubs2 mostra la pagina clubs-list2.html"
	@GetMapping("/clubs2")
	public String listClubs2(Model model) {
		List<ClubDto> clubs = clubservice.findallClubs();
		model.addAttribute("clubs",clubs);
		return "clubs-list2";
		// il return è il nome della pagina su cui vai è l'equivalente del forward di una servlet
	}
	
	
	@GetMapping("/clubs/new")
	public String createClubForm(Model model) {
		Club club = new Club();
		model.addAttribute("club",club);
		return "clubs-create";
		
	}
	
	@PostMapping("clubs/new")
	public String saveClub(@Valid @ModelAttribute("club") Club club, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("club", club);
			return "clubs-create";
		}
		clubservice.saveClub(club);
		return "redirect:/clubs2";
	}
	
	
	
	
	@GetMapping("/clubs/{Id}/edit")
	public String editclubForm(@PathVariable("Id")  long Id, Model model) {
		ClubDto club = clubservice.findClubById(Id);
		model.addAttribute("club", club );
		
		return "clubs-edit";
	}
	

	@PostMapping("/clubs/{Id}/edit")
	public String updateClub(@PathVariable("Id") long Id, @Valid @ModelAttribute("club") ClubDto club,
			BindingResult result) {
		if(result.hasErrors()) {
			return "clubs-edit";
		}
		club.setId(Id);
		clubservice.updateclub(club);
		return "redirect:/clubs2";
		
	}
	
	@GetMapping("/clubs/{clubId}")
	public String clubDetail(@PathVariable("clubId") long id, Model model) {
		ClubDto clubdto = clubservice.findClubById(id);
		List<EventoDto> cercaLista = eventservice.cercaLista(id);
		model.addAttribute("club",clubdto);
		model.addAttribute("listaEventi",cercaLista);
		return "clubs-detail";

		
	}
	
	
	@GetMapping("/clubs/{clubId}/delete")
	public String deleteClub(@PathVariable("clubId") long clubId) {
		clubservice.delete(clubId);
		
		return "redirect:/clubs2";
		
	}
	
	@GetMapping("/clubs/search")
	public String searchClub(@RequestParam(value="query") String query, Model model ) {
		List<ClubDto> searchClubs = clubservice.searchClubs(query);
		model.addAttribute("clubs", searchClubs);
		return "clubs-list2";
		
	}
	
	
	@GetMapping("/events/{clubid}/new")
	public String createEventoForm(@PathVariable("clubid") Long id, Model model) {
		Evento event = new Evento();
		model.addAttribute("clubid", id);
		model.addAttribute("evento",event);
		
		return "evento-create";
		
	}
	
	@PostMapping("/events/{clubid}")
	public String createNuovoEvento(@PathVariable("clubid") Long id, @Valid @ModelAttribute("evento") EventoDto eventodto,
			Model model, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("evento", eventodto);
			return "evento-create";
		}
		eventservice.createEvent(id, eventodto);
		
		return "redirect:/clubs2";
	}
	
	@GetMapping("/clubs/{eventId}/deleteEvent")
	public String deleteEvent(@PathVariable("eventId") long eventId) {
		eventservice.deleteEvent(eventId);
		
		return "redirect:/clubs2";
		
	}
	
	@GetMapping("/events/{eventId}/{clubId}")
	public String eventDetail(@PathVariable("eventId") long id, @PathVariable("clubId") long clubId, Model model) {
		EventoDto eventoById = eventservice.findEventoById(id);
		model.addAttribute("eventobyid",eventoById);
		model.addAttribute("clubId", clubId);
	
		return "event-detail";
	}
	
	
	@GetMapping("/event/{Id}/{clubId}/edit")
	public String editEventForm(@PathVariable("Id")  long Id,@PathVariable("clubId") long clubId, Model model) {
		EventoDto eventoById = eventservice.findEventoById(Id);
		
		model.addAttribute("clubId", clubId);
		model.addAttribute("eventoDaModificare", eventoById );
		
		return "event-edit";
	}


	
	@PostMapping("/events/{Id}/{clubId}/edit")
	public String updateEvent(@PathVariable("Id") long Id, @PathVariable("clubId") long clubId, @ModelAttribute("eventoDaModificare") EventoDto eventodto
			) {
		EventoDto eventoDtoById = eventservice.findEventoById(Id);
		eventodto.setId(Id);
		Club club = clubservice.findNonDtoClubById(clubId);
		eventservice.updateEvent(eventodto, club);
	
		return "redirect:/clubs2";
	}
	
}
