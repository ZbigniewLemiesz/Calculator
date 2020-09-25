package pl.sda.springdemo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String inputValue;
    private BigDecimal result;

    public Operation() {
    }

    public Operation(String inputValue, BigDecimal result) {
        this.inputValue = inputValue;
        this.result = result;
    }

    public static Operation createNewFromOperationDTO(OperationDTO operationDTO) {
        return new Operation(operationDTO.getInputValue(), operationDTO.getResult());
    }
}
