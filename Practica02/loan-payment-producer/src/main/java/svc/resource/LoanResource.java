package svc.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import svc.model.Loan;

import java.util.List;

@RequestMapping("/api/loans")
@RestController
public class LoanResource {

    private final  svc.service.LoanService loanService;

    public LoanResource( svc.service.LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping
    public ResponseEntity<List<Loan>> getLoans(){
        return new ResponseEntity<>(loanService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{number}")
    public ResponseEntity<Loan> getLoan(@PathVariable Integer number){
        Loan currentLoan = loanService.findById(number);
        if( null == currentLoan){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(currentLoan, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Loan> postLoan(@RequestBody Loan loan){
        loanService.create(loan);
        return new ResponseEntity<>(loan, HttpStatus.CREATED);
    }

    @PutMapping("/{number}")
    public ResponseEntity<Loan> putLoan(@PathVariable Integer number,
                                         @RequestBody Loan loan){

        if( null == loanService.findById(number)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        loan.setNumber(number);
        loanService.update(loan);
        return new ResponseEntity<>(loan, HttpStatus.OK);
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<Loan> deleteLoan(@PathVariable Integer number){

        if( null == loanService.findById(number)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        loanService.delete(number);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

