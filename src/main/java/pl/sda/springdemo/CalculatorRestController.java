package pl.sda.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
