package watson.controllers.soap;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import watson.controllers.base.BaseRefreshController;
import watson.services.soap.stage.SoapRefreshService;

@Controller
@RequestMapping("/soap")
public class SoapRefreshController extends BaseRefreshController {

    public SoapRefreshController() {
        super(new SoapRefreshService());
    }

    /**
     * Forces the staging collection to be recrawled via WEX Explorer REST API in DB_Search Collection.
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
