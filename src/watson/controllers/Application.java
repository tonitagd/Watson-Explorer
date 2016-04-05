package watson.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import watson.services.RestSearchService;
import watson.services.SoapSearchService;
import watson.services.SearchService;

@Controller
public class Application {

    @RequestMapping(value = "restSearchForOrder")
    public void searchForOrderRest(HttpServletResponse response) throws IOException {
        search(response, new RestSearchService());
    }

    @RequestMapping(value = "soapSearchForOrder")
    public void searchForOrderSoap(HttpServletResponse response) throws IOException {
        search(response, new SoapSearchService());
    }

    /**
     * Executes a request to the WEX SOAP or REST API using given service and writes the result to the
     * {@link HttpServletResponse}
     * 
     * @param response
     *        - the {@link HttpServletResponse} to which the result is written
     * @param service
     *        - the {@link SearchService} from which the call is made
     * @throws IOException
     *         when the response cannot be written
     */
    private <T> void search(HttpServletResponse response, SearchService service) throws IOException {
        T searchForOrder = service.searchFor("order", "DB_Search");
        String resultToString = service.stringifyQueryResult(searchForOrder);
        response.getWriter().write(resultToString);
    }
}
