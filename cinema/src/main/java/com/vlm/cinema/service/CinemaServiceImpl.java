package com.vlm.cinema.service;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vlm.cinema.dao.CategorieRepository;
import com.vlm.cinema.dao.CinemaRepository;
import com.vlm.cinema.dao.FilmRepository;
import com.vlm.cinema.dao.PlaceRepository;
import com.vlm.cinema.dao.ProjectionRepository;
import com.vlm.cinema.dao.SalleRepository;
import com.vlm.cinema.dao.SeanceRepository;
import com.vlm.cinema.dao.TicketRepository;
import com.vlm.cinema.dao.VilleRepository;
import com.vlm.cinema.entities.Categorie;
import com.vlm.cinema.entities.Cinema;
import com.vlm.cinema.entities.Film;
import com.vlm.cinema.entities.Place;
import com.vlm.cinema.entities.Projection;
import com.vlm.cinema.entities.Salle;
import com.vlm.cinema.entities.Seance;
import com.vlm.cinema.entities.Ticket;
import com.vlm.cinema.entities.Ville;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CinemaServiceImpl implements ICinemaInitService {
	
	@Autowired
	private VilleRepository villeRepository;
	
	@Autowired
	private CinemaRepository cinemaRepository;
	
	@Autowired
	private SalleRepository salleRepository;
	
	@Autowired
	private PlaceRepository placeRepository;
	
	@Autowired
	private SeanceRepository seanceRepository;
	
	@Autowired
	private CategorieRepository categorieRepository;
	
	@Autowired
	private FilmRepository filmRepository;
	
	@Autowired
	private ProjectionRepository projectionRepository;
	
	@Autowired
	private TicketRepository ticketRepository;
	

	@Override
	public void initVilles() {
		Stream.of("Dakar","Thies"," Saint-Louis","Diourbel").forEach(nameVille->{
			Ville ville = new Ville();
			ville.setName(nameVille);
			villeRepository.save(ville);
		});
		
	}

	@Override
	public void initCinemas() {
		villeRepository.findAll().forEach(v->{
			Stream.of("MegaRama","IMAX","FOUNOUN","CHACHRAZAD","DAOULIZ")
			.forEach(nameCinema->{
				Cinema cinema = new Cinema();
				cinema.setName(nameCinema);
				cinema.setNombreSalles(3+(int)(Math.random()*7));
				cinema.setVille(v);
				cinemaRepository.save(cinema);
			});
		});
		
	}

	@Override
	public void initSalles() {
		cinemaRepository.findAll().forEach(cinema->{
			for(int i=0; i<cinema.getNombreSalles();i++) {
				Salle salle =new Salle();
				salle.setName("Salle "+(i+1));
				salle.setCinema(cinema);
				salle.setNombrePlace(15+(int)(Math.random()*20));
				salleRepository.save(salle);
			}
		});
		
	}

	@Override
	public void initPlaces() {
		salleRepository.findAll().forEach(salle->{
			for(int i=0; i<salle.getNombrePlace();i++) {
				Place place = new Place();
				place.setNumero(i+1);
				place.setSalle(salle);
				placeRepository.save(place);
			}
		});
		
	}

	@Override
	public void initSeances() {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		Stream.of("12:00","15:00","17:00","19:00","21:00").forEach(s->{
			Seance seance = new Seance();
			try {
				seance.setHeureDebut(dateFormat.parse(s));
				seanceRepository.save(seance);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		});
		
	}

	@Override
	public void initCategories() {
		Stream.of("Histoire","Actions","Fiction","Drama").forEach(cat->{
			Categorie categorie = new Categorie();
			categorie.setName(cat);
			categorieRepository.save(categorie);
		});
		
	}

	@Override
	public void initFilms() {
		double[] durees = new double[] {1,1.5,2,2.5,3};
		List<Categorie> categories = categorieRepository.findAll();
		Stream.of("12 Hommes en colere","Forest Gump","Green Book","La Ligne Verte","Le Parrin","Le Seigneur des anneaux")
		.forEach(titreFilm->{
			Film film = new Film();
			film.setTitre(titreFilm);
			film.setDuree(durees[new Random().nextInt(durees.length)]);
			film.setPhoto(titreFilm.replaceAll("", "")+".jpg");
			film.setCategorie(categories.get(new Random().nextInt(categories.size())));
			filmRepository.save(film);
		});
		
	}

	@Override
	public void initProjections() {
		double[] prices = new double[] {30,50,60,70,90,100};
		villeRepository.findAll().forEach(ville->{
			ville.getCinemas().forEach(cinema->{
				cinema.getSalles().forEach(salle->{
					filmRepository.findAll().forEach(film->{
						seanceRepository.findAll().forEach(seance->{
							Projection projection = new Projection();
							projection.setDateProjection(new Date());
							projection.setFilm(film);
							projection.setPrix(prices[new Random().nextInt(prices.length)]);
							projection.setSalle(salle);
							projection.setSeance(seance);
							projectionRepository.save(projection);
						});
					});
				});
			});
		});
		
	}

	@Override
	public void initTickets() {
		projectionRepository.findAll().forEach(p->{
			p.getSalle().getPlaces().forEach(place->{
				Ticket ticket = new Ticket();
				ticket.setPlace(place);
				ticket.setPrix(p.getPrix());
				ticket.setProjection(p);
				ticket.setReserve(false);
				ticketRepository.save(ticket);
			});
		});
		
	}

}
