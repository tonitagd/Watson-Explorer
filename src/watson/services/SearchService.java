package watson.services;

import watson.models.QueryResultType;

public interface SearchService {

    public static final String WATSON_EXPLORER_ENGINE_URL = "http://localhost:9080/vivisimo/cgi-bin/velocity.exe?v.app=";

    /**
     * Searches for a query in given source
     * 
     * @param query
     *        - the search query
     * @param source
     *        - the source in which to search
     * @return The parsed {@link QueryResultType} of the search query
     */
    public <T> T searchFor(String query, String source);

    /**
     * Converts search search result to {@link String}
     * 
     * @param results
     *        - the result which will be converted to {@link String}
     * @return Stringified result
     */
    public <T> String stringifyQueryResult(T results);

}
