package watson.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import watson.services.RestService;
import watson.services.SoapService;
import watson.services.WatsonService;

@Controller
public class Application {

    @RequestMapping(value = "restSearchForOrder")
    public void searchForOrderRest(HttpServletResponse response) throws IOException {
        search(response, new RestService());
    }

    @RequestMapping(value = "soapSearchForOrder")
    public void searchForOrderSoap(HttpServletResponse response) throws IOException {
        search(response, new SoapService());
    }

    private <T> void search(HttpServletResponse response, WatsonService soapService) throws IOException {
        T searchForOrder = soapService.searchFor("order", "DB_Search");
        String resultToString = soapService.stringifyQueryResult(searchForOrder);
        response.getWriter().write(resultToString);
    }
}
