package com.vlm.cinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.vlm.cinema.entities.Ticket;

@RepositoryRestResource
public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
