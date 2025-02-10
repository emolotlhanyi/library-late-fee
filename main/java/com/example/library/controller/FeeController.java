package main.java.com.example.library.controller;

import main.java.com.example.library.model.Loan;
import main.java.com.example.library.service.FeeCalculationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/late-fee")
public class FeeController {

    private final FeeCalculationService feeService;

    public FeeController(FeeCalculationService feeService) {
        this.feeService = feeService;
    }

    @PostMapping("/calculate")
    public double calculate(@RequestBody Loan loan) {
        return feeService.calculateLateFee(loan);
    }
}
