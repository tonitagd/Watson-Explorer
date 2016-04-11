package watson.services.soap.base;

import velocity.VelocityPort;
import velocity.VelocityService;
import velocity.soap.Authentication;
import watson.services.WEXEngineService;

public abstract class SoapService implements WEXEngineService {

    private static final String ENDPOINT_ADDR = WATSON_EXPLORER_ENGINE_URL
            + "api-soap&wsdl=1&specialize-for=&use-types=true";

    private VelocityService valociryService;

    protected VelocityPort port;

    protected Authentication authentication;

    public SoapService() {
        super();
        createConnection();
        createAuthentication();
    }

    /**
     * Creates a connection to the WEX Engine server
     */
    private void createConnection() {
        valociryService = new VelocityService();
        port = valociryService.getVelocityPort();
        ((javax.xml.ws.BindingProvider) port).getRequestContext()
                                             .put(javax.xml.ws.BindingProvider.ENDPOINT_ADDRESS_PROPERTY, ENDPOINT_ADDR);
    }

    /**
     * Creates SOAP authentication against the WEX Engine server
     */
    private void createAuthentication() {
        authentication = new Authentication();
        authentication.setUsername("admin");
        authentication.setPassword("admin");
    }
}
