package svc.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import svc.model.Payment;
import svc.service.PaymentService;

import java.util.List;

@RequestMapping("/api/payments")
@RestController
public class PaymentResource {

    private final PaymentService paymentService;

    public PaymentResource(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public ResponseEntity<List<Payment>> getPayments(){
        return new ResponseEntity<>(paymentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{number}")
    public ResponseEntity<Payment> getPayment(@PathVariable Integer number){
        Payment currentPayment = paymentService.findById(number);
        if( null == currentPayment){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(currentPayment, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Payment> postPayment(@RequestBody Payment loan){
        paymentService.create(loan);
        return new ResponseEntity<>(loan, HttpStatus.CREATED);
    }

    @PutMapping("/{number}")
    public ResponseEntity<Payment> putPayment(@PathVariable Integer number,
                                        @RequestBody Payment loan){

        if( null == paymentService.findById(number)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        loan.setNumber(number);
        paymentService.update(loan);
        return new ResponseEntity<>(loan, HttpStatus.OK);
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<Payment> deletePayment(@PathVariable Integer number){

        if( null == paymentService.findById(number)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        paymentService.delete(number);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
