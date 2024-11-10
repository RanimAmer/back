package tn.esprit.reservation.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.reservation.entity.Reservation;
import tn.esprit.reservation.entity.Nutrition;
import tn.esprit.reservation.repository.ReservationRepository;
import tn.esprit.reservation.services.IreservationService;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/reservation")
public class ReservationRestController {
    private IreservationService reservationService;
    @Autowired
    private ReservationRepository reservationRepository;
    @GetMapping("/retrieve-all-reservation")
    public List<Reservation> getReservations() {
        List<Reservation> listReservation = reservationService.retrieveAllReservations();
        return listReservation;
    }

    @GetMapping("/retrieve-Reservation/{reservation-id}")
    public Reservation retrieveReservation(@PathVariable("reservation-id") Long id_reservation) {
        Reservation reservation = reservationService.retrieveReservation(id_reservation);
        return reservation;
    }

    @PostMapping("/add-Reservation")
    public Reservation addReservation(@RequestBody Reservation r) {
        Reservation reservation = reservationService.addReservation(r);
        return reservation;
    }

    @DeleteMapping("/remove-Reservation/{Reservation-id}")
    public void removeReservation(@PathVariable("Reservation-id") Long id_reservation) {
        reservationService.removeReservation(id_reservation);
    }

    @PutMapping("/modify-Reservation/{reservation-id}")
    public Reservation modifyReservation(@PathVariable ("reservation-id") Long id_reservation, @RequestBody Reservation r) {
        r.setId_reservation(id_reservation);
        Reservation reservation = reservationService.modifyReservation(r);
        return reservation;
    }
    @GetMapping("/search/{keywords}")
    public ResponseEntity<List<Reservation>> searchReservation(@PathVariable String keywords){
        List<Reservation> reservations =reservationService.searchReservation(keywords);
        return ResponseEntity.ok().body(reservations);
    }

    @GetMapping("/nutrition/retrieve-all-nutritions")
    public List<Nutrition> getAllnutritions() {
        List<Nutrition> listNutrition = reservationService.getAllNutrition();
        return listNutrition;
    }
}
