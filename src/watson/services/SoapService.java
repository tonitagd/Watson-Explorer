package watson.services;

import velocity.VelocityPort;
import velocity.VelocityService;
import velocity.objects.Content;
import velocity.objects.Document;
import velocity.objects.QueryResults;
import velocity.soap.Authentication;
import velocity.types.QuerySearch;

public class SoapService implements WatsonService {

    private static final String ENDPOINT_ADDR = WATSON_EXPLORER_ENGINE_URL
            + "api-soap&wsdl=1&specialize-for=&use-types=true";

    private VelocityService valociryService;

    private VelocityPort port;

    private Authentication authentication;

    public SoapService() {
        super();
        createConnection();
        createAuthentication();
    }

    private void createConnection() {
        this.valociryService = new VelocityService();
        this.port = valociryService.getVelocityPort();
        ((javax.xml.ws.BindingProvider) port).getRequestContext()
                                             .put(javax.xml.ws.BindingProvider.ENDPOINT_ADDRESS_PROPERTY, ENDPOINT_ADDR);
    }

    private void createAuthentication() {
        this.authentication = new Authentication();
        authentication.setUsername("admin");
        authentication.setPassword("admin");
    }

    @Override
    public QueryResults searchFor(String query, String source) {
        QuerySearch querySearch = new QuerySearch();
        querySearch.setSources(source);
        querySearch.setQuery(query);
        querySearch.setAuthentication(authentication);
        velocity.types.QuerySearchResponse querySearchResponse = port.querySearch(querySearch);
        return (QueryResults) querySearchResponse.getAny();
    }

    @Override
    public <T> String stringifyQueryResult(T results) {
        StringBuilder builder = new StringBuilder();
        builder.append("Search result: \n\n");

        builder.append("List: \n[documents=");

        for (Document document : ((QueryResults) results).getList().getDocument()) {
            builder.append("DocumentType: \n[url=");
            builder.append(document.getUrl());
            builder.append(", cache=Cache [url=");
            builder.append(document.getCache().get(0).getUrl());
            builder.append("],\ncontents=\n");
            for (Content content : document.getContent()) {
                builder.append("ContentType [ name=");
                builder.append(content.getName());
                builder.append(", value=");
                builder.append(content.getValue());
                builder.append("]\n");
            }
        }
        builder.append("]\n");
        return builder.toString();
    }
}
