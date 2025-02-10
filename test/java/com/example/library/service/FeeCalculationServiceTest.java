package test.java.com.example.library.service;

import main.java.com.example.library.model.*;
import main.java.com.example.library.service.FeeCalculationService;
import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;

class FeeCalculationServiceTest {
    private final FeeCalculationService feeService = new FeeCalculationService();

    @Test
    void testStudentLateFee() {
        User user = new User("Ernest", UserType.STUDENT);
        Book book = new Book("Java Basics", false);
        Loan loan = new Loan(user, book, 15);
        assertEquals(20, feeService.calculateLateFee(loan));
    }

    @Test
    void testTeacherLateFee() {
        User user = new User("Ratie", UserType.TEACHER);
        Book book = new Book("Spring Boot Guide", false);
        Loan loan = new Loan(user, book, 10);
        assertEquals(10, feeService.calculateLateFee(loan));
    }

   @Test
    void testGuestLateFee() {
        User user = new User("Moffat", UserType.GUEST);
        Book book = new Book("AI for Beginners", false);
        Loan loan = new Loan(user, book, 5);
        assertEquals(10, feeService.calculateLateFee(loan));
    }

   @Test
    void testLostBookFee() {
        User user = new User("Kgotso", UserType.STUDENT);
        Book book = new Book("Java Crash Course", true);
        Loan loan = new Loan(user, book, 20);
        assertEquals(90, feeService.calculateLateFee(loan));
    }
}

