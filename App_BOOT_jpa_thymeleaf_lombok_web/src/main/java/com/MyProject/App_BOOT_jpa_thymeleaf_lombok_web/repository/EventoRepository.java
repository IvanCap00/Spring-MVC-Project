package com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MyProject.App_BOOT_jpa_thymeleaf_lombok_web.models.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {

}
