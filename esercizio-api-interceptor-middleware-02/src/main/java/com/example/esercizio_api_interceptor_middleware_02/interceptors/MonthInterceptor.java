package com.example.esercizio_api_interceptor_middleware_02.interceptors;

import com.example.esercizio_api_interceptor_middleware_02.entities.Month;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Component
public class MonthInterceptor implements HandlerInterceptor {
    private List<Month> months = new ArrayList<>();

    public MonthInterceptor() {
        // Inizializzo la lista con 6 mesi di esempio
        months.add(new Month(1, "January", "Gennaio", "Januar"));
        months.add(new Month(2, "February", "Febbraio", "Februar"));
        months.add(new Month(3, "March", "Marzo", "März"));
        months.add(new Month(4, "April", "Aprile", "April"));
        months.add(new Month(5, "May", "Maggio", "Mai"));
        months.add(new Month(6, "June", "Giugno", "Juni"));
        }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            // Prendiamo l'header monthNumber dalla richiesta
            String monthNumberStr = request.getHeader("monthNumber");

        // Se monthNumber non è presente o è vuoto, restituisco un oggetto Month vuoto con i nomi impostati su "nope"
        if(monthNumberStr == null || monthNumberStr.isEmpty()) {
            Month emptyMonth = new Month(0, "nope", "nope", "nope");
            request.setAttribute("month", emptyMonth);
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            return false;
        }
        int monthNumber;
        try {
            monthNumber = Integer.parseInt(monthNumberStr);
        } catch (NumberFormatException e) {
            // Se monthNumber non è un numero valido, restituiscoo un oggetto Month vuoto con i nomi impostati su "nope"
            Month emptyMonth = new Month(0, "nope", "nope", "nope");
            request.setAttribute("month", emptyMonth);
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            return false;
        }
        Month foundMonth = null;
        for (Month month : months) {
            if (month.getMonthNumber() == monthNumber) {
                foundMonth = month;
                break;
            }
        }
        // Se il mese è stato trovato, lo aggiungo come attributo della richiesta
        // Altrimenti, restituisco un oggetto Month vuoto con i nomi impostati su "nope"
        if (foundMonth != null) {
            request.setAttribute("month", foundMonth);
            response.setStatus(HttpStatus.OK.value());
            return true;
        } else {
            Month emptyMonth = new Month(0, "nope", "nope", "nope");
            request.setAttribute("month", emptyMonth);
            response.setStatus(HttpStatus.OK.value());
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
