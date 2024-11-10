package tn.esprit.reservation.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.reservation.entity.Reservation;
import tn.esprit.reservation.entity.Nutrition;
import tn.esprit.reservation.repository.ReservationRepository;

import java.util.List;
@Service
@Slf4j
public class ReservationService implements IreservationService{
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    private NutritionClient nutritionClient;

    @Override
    public List<Reservation> retrieveAllReservations() {
       log.info("Liste des reservation: {}",reservationRepository.findAll());
        return reservationRepository.findAll();
    }

    @Override
    public Reservation retrieveReservation(Long id_reservation) {
        return reservationRepository.findById(id_reservation).get();
    }

    @Override
    public Reservation addReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    @Override
    public void removeReservation(Long id_reservation) {
        reservationRepository.deleteById(id_reservation);

    }

    @Override
    public Reservation modifyReservation(Reservation id_reservation) {
        return reservationRepository.save(id_reservation);
    }

    @Override
    public List<Reservation> searchReservation(String keywords) {
        return reservationRepository.findByNomCoursOrNomCoach(keywords, keywords);
    }

    @Override
    public List<Nutrition> getAllNutrition() {
        return nutritionClient.getNutritions();
    }


}
