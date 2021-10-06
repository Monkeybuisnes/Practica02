package svc.service;

import org.springframework.stereotype.Service;
import svc.model.Loan;
import svc.model.Payment;
import svc.repository.PaymentRepository;

import java.util.List;

@Service
public class PaymentService implements CrudService<Payment, Integer>{

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void create(Payment payment) {
        paymentRepository.save(payment);
    }

    @Override
    public void update(Payment payment) {
        paymentRepository.save(payment);
    }

    @Override
    public void delete(Integer id) {
        paymentRepository.deleteById(String.valueOf(id));
    }

    @Override
    public Loan findById(Integer id) {
        return (Loan) paymentRepository.findById(String.valueOf(id))
                .orElse(null);
    }

    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }
}
