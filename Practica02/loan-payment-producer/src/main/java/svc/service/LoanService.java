package svc.service;

import org.springframework.stereotype.Service;
import svc.model.Loan;
import svc.repository.LoanRepository;

import java.util.List;

@Service
public class LoanService implements CrudService<Loan, Integer>{

    private final LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public void create(Loan loan) {
        loan.addPayments(loan.getPayments());
        loanRepository.save(loan);
    }

    @Override
    public void update(Loan loan) {
        loanRepository.save(loan);
    }

    @Override
    public void delete(Integer id) {
        loanRepository.deleteById(String.valueOf(id));
    }

    @Override
    public Loan findById(Integer id) {
        return loanRepository.findById(String.valueOf(id))
                .orElse(null);
    }

    @Override
    public List<Loan> findAll() {
        return loanRepository.findAll();
    }
}
