package watson.controllers.base;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import watson.services.base.RefreshService;

public abstract class BaseRefreshController {

    private String collection;

    private String message;

    private RefreshService service;

    public BaseRefreshController(RefreshService service) {
        this(service,"DB_Search");
    }

    public BaseRefreshController(RefreshService service, String collection) {
        super();
        this.collection = collection;
        this.service = service;
    }

    /**
     * Invokes a refresh of the staging status of given collection
     * 
     * @param response
     *        - the {@link HttpServletResponse} to which to write the result
     * @throws IOException
     *         - when the result cannot be written
     */
    protected void refresh(HttpServletResponse response) throws IOException {
        service.refresh(collection);
        response.getWriter().write(getMessage());
    }

    /**
     * Generates a message which is displayed in the top of the result page
     * 
     * @return a message that gives search information
     */
    protected String getMessage() {
        message = String.format("%s invoked a refresh of the staging status for collection '%s'.",
                                service.getClass().getCanonicalName(),
                                getCollection());
        return message;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String source) {
        this.collection = source;
    }
}
