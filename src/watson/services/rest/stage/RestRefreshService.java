package watson.services.rest.stage;

import watson.services.base.RefreshService;
import watson.services.rest.base.RestService;

public class RestRefreshService extends RestService implements RefreshService {

    public void refresh(String collection) {
        String functionName = String.format("%s%s%s",
                                            "search-collection-crawler-start&collection=",
                                            collection,
                                            "&subcollection=staging&type=refresh-new");
        executeFunction(functionName);
    }
}
