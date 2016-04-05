package watson.services;

import watson.models.QueryResult;

public interface WatsonService {

    public static final String WATSON_EXPLORER_ENGINE_URL = "http://localhost:9080/vivisimo/cgi-bin/velocity.exe?v.app=";

    /**
     * Searches for a query in given source
     * 
     * @param query
     *        - the search query
     * @return The parsed {@link QueryResult} of the search query
     */
    public <T> T searchFor(String query, String source);

    public <T> String stringifyQueryResult(T results);

}
