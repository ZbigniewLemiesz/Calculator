package pl.sda.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RequestMapping("/api")
@RestController //kontroller, który przyjmuje i zwraca JSON-y
public class CalculatorRestController {
    @Autowired
    private CalculatorService calculatorService;



//    @RequestMapping(value = "/calculate" , method = RequestMethod.POST)
    @PostMapping(value = "/calculate")
    BigDecimal calculate(@RequestBody InputValueWrapper inputValueWrapper){
        return calculatorService.calculate(inputValueWrapper.getInputValue());

    }
}
