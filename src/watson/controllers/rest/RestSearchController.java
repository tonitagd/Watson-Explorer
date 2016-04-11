package watson.controllers.rest;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import watson.controllers.base.BaseSearchController;
import watson.services.rest.search.RestSearchService;

@Controller
@RequestMapping("/rest")
public class RestSearchController extends BaseSearchController {

    public RestSearchController() {
        super(new RestSearchService());
    }

    /**
     * Used to search via WEX Explorer REST API in DB_Search Source for query = order. Writes the results in response
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
     * * Used to search via WEX Explorer REST API in DB_Search Source with predefined filters for query = green and
     * filter KPI_STATUS. Returns the results in response
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
