package io.ccserver.ccsc.storage;

/**
 * Created by JJOL on 15/08/2015.
 */
public interface StorageManager {

    public void saveResource(StorageDataContent dataContent);


    public StorageDataContent loadResource(StorageDataContent dataContent);





}
