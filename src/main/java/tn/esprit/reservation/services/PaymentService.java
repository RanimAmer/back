package tn.esprit.reservation.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.reservation.entity.Payment;
import tn.esprit.reservation.repository.PaymentRepository;

import java.util.List;

@Service
@Slf4j
public class PaymentService implements IpaymentService{
    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public List<Payment> retrieveAllPayments() {
        log.info("Liste des offres: {}",paymentRepository.findAll());
        return paymentRepository.findAll();
    }

    @Override
    public Payment retrievePayment(Long id_payment) {
        return paymentRepository.findById(id_payment).get();
    }

    @Override
    public Payment addPayment(Payment p) {
        return paymentRepository.save(p);
    }

    @Override
    public void removePayment(Long id_payment) {
        paymentRepository.deleteById(id_payment);

    }

    @Override
    public Payment modifyPayment(Payment id_payment) {
        return paymentRepository.save(id_payment);
    }
}
