package pl.sda.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

@Controller
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @RequestMapping("/calculate")
    String calculate(String inputValue, Model model){
        BigDecimal result = calculatorService.calculate(inputValue);
        model.addAttribute("result",result);

        return "CalculatorForm";
    }
    @RequestMapping("/calculator")
    String calculateForm(){
        return "CalculatorForm";
    }
}
