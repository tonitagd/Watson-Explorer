package watson.services.base;

import watson.models.QueryResultType;

public interface SearchService {

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
