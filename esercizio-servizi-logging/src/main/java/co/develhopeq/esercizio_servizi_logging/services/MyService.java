package co.develhopeq.esercizio_servizi_logging.services;

import co.develhopeq.esercizio_servizi_logging.Exceptions.MyCustomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    private static final Logger logger = LoggerFactory.getLogger(MyService.class);

    public int calculatePower(int base, int exponent) {
        logger.debug("Logger DEBUG Message: Starting calculation with base {} and exponent {}", base, exponent);

        int result = (int) Math.pow(base, exponent);
        logger.debug("Logger DEBUG Message: Calculation result: {}", result);
        return result;
    }

    public void logCustomError() {
        logger.error("Logger ERROR message: Custom error occurred!");
        throw new MyCustomException("Custom error message");
    }
}
