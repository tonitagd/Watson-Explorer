package watson.services.soap.stage;

import velocity.types.SearchCollectionCrawlerStart;
import watson.services.base.RefreshService;
import watson.services.soap.base.SoapService;

public class SoapRefreshService extends SoapService implements RefreshService {

    public void refresh(String collection) {
        SearchCollectionCrawlerStart pushStaging = new SearchCollectionCrawlerStart();
        pushStaging.setAuthentication(authentication);
        pushStaging.setCollection(collection);
        pushStaging.setType("refresh-new");
        pushStaging.setSubcollection("staging");
        port.searchCollectionCrawlerStart(pushStaging);
    }
}
