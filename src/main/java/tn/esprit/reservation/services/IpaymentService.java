package tn.esprit.reservation.services;

import tn.esprit.reservation.entity.Payment;

import java.util.List;

public interface IpaymentService {
    List<Payment> retrieveAllPayments();

    Payment retrievePayment(Long idPayment);

    Payment addPayment(Payment p);

    void removePayment(Long idPayment);

    Payment modifyPayment(Payment p);
}
