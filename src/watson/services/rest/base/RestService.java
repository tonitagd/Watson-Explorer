package watson.services.rest.base;

import org.springframework.web.client.RestTemplate;

import watson.services.WEXEngineService;

public abstract class RestService implements WEXEngineService {

    private static String ENDPOINT_ADDR = WATSON_EXPLORER_ENGINE_URL + "api-rest&v.function=";

    private static final String AUTHENTICATION_FUNCTION = "&v.username=admin&v.password=admin";

    protected RestTemplate restTemplate = new RestTemplate();

    /**
     * Executes a Watson Explorer Engine function
     * 
     * @param functionName
     *        - the name of the function, which will be executed
     * @param clazz
     *        - the {@link Class} from which type the result is
     * @return The parsed result of the executed function
     */
    protected <T> T executeFunction(String functionName, Class<T> clazz) {
        String methodURL = getMethodURL(functionName);
        return restTemplate.postForObject(methodURL, null, clazz);
    }

    /**
     * Executes a Watson Explorer Engine function without response
     * 
     * @param functionName
     *        - the name of the function, which will be executed
     */
    protected void executeFunction(String functionName) {
        String methodURL = getMethodURL(functionName);
        restTemplate.postForLocation(methodURL, null);
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

}
