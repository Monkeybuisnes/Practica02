package svc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loan extends Payment {

    @Id
    private Integer Number;
    private String clientName;
    private String clientLastName;
    private Double loanAmount;
    private Double loanRemainingAmount;
    private Integer numberOfPages;

    @JsonIgnoreProperties("loan")
    @OneToMany(mappedBy = "loan", cascade = CascadeType.ALL)
    private List<Payment> payments;

    public void addPayments(List<Payment> payments){
        payments.forEach(a -> a.setLoan(this));
        this.setPayments(payments);
    }
}
