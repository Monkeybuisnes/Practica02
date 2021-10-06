package svc.loader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import svc.model.Loan;
import svc.model.Payment;
import svc.repository.PaymentRepository;

import java.time.LocalDate;
import java.util.GregorianCalendar;

@Configuration
public class PaymentLoader implements CommandLineRunner {

    private final PaymentRepository paymentRepository;
    private Object GregorianCalendar;
    private Object Loan;

    public PaymentLoader(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Payment payment = new Payment();
        payment.setNumber(40120835);
        payment.setPaymentDate((LocalDate) GregorianCalendar);
        payment.setAmount(1542.02);
        payment.setLoan((svc.model.Loan) Loan);

        paymentRepository.save(payment);
    }
}
