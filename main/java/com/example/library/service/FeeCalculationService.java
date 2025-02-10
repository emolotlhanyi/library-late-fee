package main.java.com.example.library.service;

import main.java.com.example.library.model.Loan;
import main.java.com.example.library.model.UserType;


@Service
public class FeeCalculationService {

    public double calculateLateFee(Loan loan) {
        double dailyFee = getDailyFee(loan);
        double baseFee = dailyFee * loan.getDaysLate();

        double extraPenalty = (loan.getDaysLate() / 10) * 5;

        if (loan.getBook().isLost()) {
            return baseFee + extraPenalty + 50;
        }

        return baseFee + extraPenalty;
    }

    private double getDailyFee(Loan loan) {
      UserType userType = loan.getUser().getUserType();
        return switch (userType) {
            case STUDENT -> 1;
            case TEACHER -> 0.50;
            case GUEST -> 2;
            case VIP -> 0;
            default -> 1;
        };
    }
}

