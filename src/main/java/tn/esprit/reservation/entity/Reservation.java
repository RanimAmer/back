package tn.esprit.reservation.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="reservation")
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_reservation")
    private Long id_reservation;
    @Column(name = "nom_cours")
    private String nomCours;

    @Column(name = "nom_coach")
    private String nomCoach;
    private String image;
    private Boolean reservee;
    private String keywords;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_reservation", updatable = false)
    private Date date;
}

