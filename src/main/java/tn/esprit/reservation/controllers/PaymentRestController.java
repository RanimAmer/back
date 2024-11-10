package tn.esprit.reservation.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.reservation.entity.Payment;
import tn.esprit.reservation.repository.PaymentRepository;
import tn.esprit.reservation.services.IpaymentService;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/payment")
public class PaymentRestController {
    private IpaymentService paymentService;
    @Autowired
    private PaymentRepository paymentRepository;
    @GetMapping("/retrieve-all-payment")
    public List<Payment> getPayments() {
        List<Payment> listPayment = paymentService.retrieveAllPayments();
        return listPayment;
    }

    @GetMapping("/retrieve-payment/{payment-id}")
    public Payment retrievePayment(@PathVariable("payment-id") Long id_payment) {
        Payment payment = paymentService.retrievePayment(id_payment);
        return payment;
    }

    @PostMapping("/add-payment")
    public Payment addPayment(@RequestBody Payment p) {
        Payment payment = paymentService.addPayment(p);
        return payment;
    }

    @DeleteMapping("/remove-Payment/{payment-id}")
    public void removePayment(@PathVariable("payment-id") Long id_payment) {
        paymentService.removePayment(id_payment);
    }

    @PutMapping("/modify-Payment/{payment-id}")
    public Payment modifyPayment(@PathVariable ("payment-id") Long id_payment, @RequestBody Payment p) {
        p.setId_payment(id_payment);
        Payment payment = paymentService.modifyPayment(p);
        return payment;
    }



}
