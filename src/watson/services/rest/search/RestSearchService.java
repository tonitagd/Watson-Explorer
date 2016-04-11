package watson.services.rest.search;

import watson.models.QueryResultType;
import watson.services.base.SearchService;
import watson.services.rest.base.RestService;

public class RestSearchService extends RestService implements SearchService {

    @Override
    public QueryResultType searchFor(String query, String source) {
        String functionName = String.format("%s%s%s%s", "query-search&sources=", source, "&query=", query);
        return executeFunction(functionName, QueryResultType.class);
    }

    @Override
    public <T> String stringifyQueryResult(T results) {
        return results.toString();
    }

}
