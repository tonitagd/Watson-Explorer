package watson.services.soap.search;

import velocity.objects.Content;
import velocity.objects.Document;
import velocity.objects.QueryResults;
import velocity.types.QuerySearch;
import watson.services.base.SearchService;
import watson.services.soap.base.SoapService;

public class SoapSearchService extends SoapService implements SearchService {

    @Override
    public QueryResults searchFor(String query, String source) {
        QuerySearch querySearch = new QuerySearch();
        querySearch.setSources(source);
        querySearch.setQuery(query);
        querySearch.setAuthentication(authentication);
        velocity.types.QuerySearchResponse querySearchResponse = port.querySearch(querySearch);
        return (QueryResults) querySearchResponse.getAny() ;
    }

    @Override
    public <T> String stringifyQueryResult(T results) {
        StringBuilder builder = new StringBuilder();
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
