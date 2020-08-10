package pl.sda.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

@Controller
public class CalculatorController {

    private CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @RequestMapping("/calculate")
    String calculate(String inputValue, Model model){
        BigDecimal result = calculatorService.calculate(inputValue);
        model.addAttribute("result",result);
        model.addAttribute("inputValue",inputValue);
        return "CalculatorForm";
    }
    @RequestMapping("/calculator")
    String calculateForm(){
        return "CalculatorForm";
    }

    @ResponseBody // tak oznaczona metoda może zwracać JSONa
    @RequestMapping("/somethingInJson")
    public InputValueWrapper json(){
        return new InputValueWrapper();
    }
}
