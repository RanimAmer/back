package tn.esprit.reservation.services;

import tn.esprit.reservation.entity.Reservation;
import tn.esprit.reservation.entity.Nutrition;

import java.util.List;

public interface IreservationService {
    List<Reservation> retrieveAllReservations();

    Reservation retrieveReservation(Long idReservation);

    Reservation addReservation(Reservation r);

    void removeReservation(Long idReservation);

    Reservation modifyReservation(Reservation r);

    List<Reservation> searchReservation(String keywords);




    List<Nutrition> getAllNutrition();
}
