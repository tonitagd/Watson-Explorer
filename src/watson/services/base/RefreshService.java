package watson.services.base;

public interface RefreshService {

    /**
     * Triggers staging collection for given collection
     * 
     * @param collection
     *        - the collection's name
     */
    public void refresh(String collection);

}
