package watson.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import watson.services.SearchService;

public abstract class BaseController {

    private String source;

    private String message;

    private SearchService service;

    public BaseController(SearchService service) {
        super();
        this.source = "DB_Search";
        this.service = service;
    }

    public BaseController(SearchService service, String source) {
        super();
        this.source = source;
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
    protected <T> void search(HttpServletResponse response, String query) throws IOException {
        T searchForOrder = service.searchFor(query, source);
        String resultToString = service.stringifyQueryResult(searchForOrder);
        response.getWriter().write(getMessage(query) + resultToString);
    }

    /**
     * Generates a message which is displayed in the top of the result page
     * 
     * @return a message that gives search information
     */
    protected String getMessage(String query) {
        message = String.format("The search result from %s with DataSource name:'%s' and query:'%s' is:\n\n",
                                service.getClass().getCanonicalName(),
                                getSource(),
                                query);
        return message;
    }

    protected String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
