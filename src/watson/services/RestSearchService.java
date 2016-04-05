package watson.services;

import org.springframework.web.client.RestTemplate;

import watson.models.QueryResultType;

public class RestSearchService implements SearchService {

    private RestTemplate restTemplate = new RestTemplate();

    private static String ENDPOINT_ADDR = WATSON_EXPLORER_ENGINE_URL + "api-rest&v.function=";

    private static final String AUTHENTICATION_FUNCTION = "&v.username=admin&v.password=admin";

    @Override
    public QueryResultType searchFor(String query, String source) {
        String functionName = String.format("%s%s%s%s", "query-search&sources=", source, "&query=", query);
        return executeFunction(functionName, QueryResultType.class);
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
     * 
     * @param functionName
     *        - the name of the function, which will be executed
     * @return a URL to the REST service
     */
    private String getMethodURL(String functionName) {
        return String.format("%s%s%s", ENDPOINT_ADDR, functionName, AUTHENTICATION_FUNCTION);
    }

    @Override
    public <T> String stringifyQueryResult(T results) {
        return results.toString();
    }

}
