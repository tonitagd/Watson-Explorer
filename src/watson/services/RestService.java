package watson.services;

import org.springframework.web.client.RestTemplate;

import watson.rest.models.QueryResult;

public class RestService {

    private RestTemplate restTemplate = new RestTemplate();

    private static String WATSON_EXPLORER_ENGINE_URL = "http://localhost:9080/vivisimo/cgi-bin/velocity.exe?v.app=api-rest&v.function=";

    private static final String AUTHENTICATION_FUNCTION = "&v.username=admin&v.password=admin";

    /**
     * Searches for a query in given source
     * 
     * @param query
     *        - the search query
     * @return The parsed result of the search query
     */
    public QueryResult searchFor(String query, String source) {
        String functionName = String.format("%s%s%s%s", "query-search&sources=", source, "&query=", query);
        return executeFunction(functionName, QueryResult.class);
    }

    /**
     * Executes a Watson Explorer Engine function
     * 
     * @param functionName
     *        - the name of the function, which will be executed
     * @return The parsed result of the executed function 
     */
    private <T> T executeFunction(String functionName, Class<T> clazz) {
        String methodURL = getMethodURL(functionName);
        return restTemplate.postForObject(methodURL, null, clazz);
    }

    /**
     * Generates the URL to the REST call 
     * @param functionName  - the name of the function, which will be executed
     * @return a URL to the REST service
     */
    private String getMethodURL(String functionName) {
        return String.format("%s%s%s", WATSON_EXPLORER_ENGINE_URL, functionName, AUTHENTICATION_FUNCTION);
    }

}
