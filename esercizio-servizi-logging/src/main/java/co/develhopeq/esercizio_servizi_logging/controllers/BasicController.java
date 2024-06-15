package co.develhopeq.esercizio_servizi_logging.controllers;

import co.develhopeq.esercizio_servizi_logging.Exceptions.MyCustomException;
import co.develhopeq.esercizio_servizi_logging.services.MyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BasicController {

    private static final Logger logger = LoggerFactory.getLogger(BasicController.class);

    @Autowired
    private MyService myService;

    @GetMapping("/")
    public String welcome() {
        logger.info("Logger INFO message");
        return "It's just a Welcome Message!";
    }

    @GetMapping("/exp")
    public String calculatePower() {
        int base = 2;
        int exponent = 8;
        logger.info("Logger INFO message: Starting calculation with base {} and exponent {}", base, exponent);
        int result = myService.calculatePower(base, exponent);
        logger.info("Logger INFO message: Calculation result: {}", result);
        return "Power calculation result: " + result;
    }

    @GetMapping("/get-errors")
    public String triggerError() {
        try {
            myService.logCustomError();
        } catch (MyCustomException e) {
            return "Error occurred: " + e.getMessage();
        }
        return "Error triggered successfully!";
    }
}
