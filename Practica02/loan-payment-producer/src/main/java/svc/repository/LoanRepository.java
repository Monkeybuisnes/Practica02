package svc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import svc.model.Loan;

public interface LoanRepository extends JpaRepository<Loan, String> {
}
