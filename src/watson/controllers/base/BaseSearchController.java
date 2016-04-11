package watson.controllers.base;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import watson.services.base.SearchService;

//TODO Think of a way to extract logic from BaseSearchController and BaseRefreshController
public abstract class BaseSearchController {

    private String source;

    private String message;

    private SearchService service;

    public BaseSearchController(SearchService service) {
        this(service, "DB_Search");
    }

    public BaseSearchController(SearchService service, String source) {
        super();
        this.source = source;
        this.service = service;
    }

    /**
     * Executes a request to the WEX Engine using specified service and writes the result to the
     * {@link HttpServletResponse}
     * 
     * @param response
     *        - the {@link HttpServletResponse} to which the result is written
     * @param query
     *        - the search query, for which will be searched in WEX Engine's source
     * @throws IOException
     *         when the response cannot be written
     */
    protected <T> void search(HttpServletResponse response, String query) throws IOException {
        T searchResult = service.searchFor(query, source);
        String resultToString = service.stringifyQueryResult(searchResult);
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
