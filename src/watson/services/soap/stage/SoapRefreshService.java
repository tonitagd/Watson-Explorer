package watson.services.soap.stage;

import velocity.types.SearchCollectionPushStaging;
import watson.services.base.RefreshService;
import watson.services.soap.base.SoapService;

public class SoapRefreshService extends SoapService implements RefreshService {

    public void refresh(String collection) {
        SearchCollectionPushStaging pushStaging = new SearchCollectionPushStaging();
        pushStaging.setAuthentication(authentication);
        pushStaging.setCollection(collection);
        port.searchCollectionPushStaging(pushStaging);
    }
}
