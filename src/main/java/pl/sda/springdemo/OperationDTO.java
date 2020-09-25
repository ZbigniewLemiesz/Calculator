package pl.sda.springdemo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OperationDTO {

    private Long id;
    private String inputValue;
    private BigDecimal result;


    public OperationDTO() {
    }

    public OperationDTO(String inputValue, BigDecimal result) {
        this.inputValue = inputValue;
        this.result = result;
    }

    public OperationDTO(Long id, String inputValue, BigDecimal result) {
        this.id = id;
        this.inputValue = inputValue;
        this.result = result;
    }

    public static OperationDTO fromOperation(Operation operation) {

        return new OperationDTO(operation.getId(), operation.getInputValue(), operation.getResult());
    }


}


