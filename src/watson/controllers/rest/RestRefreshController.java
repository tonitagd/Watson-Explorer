package watson.controllers.rest;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import watson.controllers.base.BaseRefreshController;
import watson.services.rest.stage.RestRefreshService;

@Controller
@RequestMapping("/rest")
public class RestRefreshController extends BaseRefreshController {

    public RestRefreshController() {
        super(new RestRefreshService());
    }

    /**
     * Forces the staging collection to be re-crawled in DB_Search Collection via WEX Explorer REST API.
     * 
     * @param response
     *        - {@link HttpServletResponse} passed from Spring
     * @throws IOException
     *         - when the response cannot be written
     */
    @RequestMapping(value = "refresh")
    public void refresh(HttpServletResponse response) throws IOException {
        super.refresh(response);
    }
}
