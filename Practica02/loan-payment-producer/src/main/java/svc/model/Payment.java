package svc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    private Integer Number;
    private LocalDate paymentDate;
    private Double amount;
//    @Column(name = "loanNumber")
//    private Integer loanNumber;

//    @JsonIgnoreProperties("payment") Payment
//    @ManyToOne
//    @JoinColumn(name = "loan_number", insertable = false, updatable = false)
    @ManyToOne
    @JoinColumn(name = "loan_number")
    private Loan loan;
}
