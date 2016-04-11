package watson.controllers.soap;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import watson.controllers.base.BaseSearchController;
import watson.services.soap.search.SoapSearchService;

@Controller
@RequestMapping("/soap")
public class SoapSearchController extends BaseSearchController {

    public SoapSearchController() {
        super(new SoapSearchService());
    }

    /**
     * Used to search via WEX Explorer SOAP API in DB_Search Source for query = order. Writes the results in response
     * 
     * @param response
     *        - {@link HttpServletResponse} passed from Spring
     * @throws IOException
     *         - when the response cannot be written
     */
    @RequestMapping(value = "search")
    public void search(HttpServletResponse response) throws IOException {
        search(response, "order");
    }

    /**
     * * Used to search with predefined filters via WEX Explorer SOAP API in DB_Search Source for query =
     * KPI_STATUS:green. Returns the results in response
     * 
     * @param response
     *        - {@link HttpServletResponse} passed from Spring
     * @throws IOException
     *         - when the response cannot be written
     */
    @RequestMapping(value = "searchWithFilter")
    public void searchWithFilter(HttpServletResponse response) throws IOException {
        search(response, "KPI_STATUS:green");
    }
}
