package watson.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import watson.rest.models.QueryResult;
import watson.services.RestService;

@Controller
public class Application {

    @RequestMapping(value = "restSearchForOrder")
    public void sayHi(HttpServletResponse response) throws IOException {

        RestService restService = new RestService();

        QueryResult searchForOrder = restService.searchFor("order", "DB_Search");
        response.getWriter().write(searchForOrder.toString());
    }
}
