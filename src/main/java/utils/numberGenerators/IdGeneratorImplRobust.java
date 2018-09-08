package utils.numberGenerators;

import dataBase.MongoConstants;
import dataBase.MongoInteractor;


public class IdGeneratorImplRobust implements IRobustNumberGenerator {
    private int nextId;
    private String uniqueKey;
    private static IRobustNumberGenerator instance;


    public static IRobustNumberGenerator getInstance() {
        if (instance == null)
           getInstanceFromDbOrInitiate();

        return instance;
    }

    private static void getInstanceFromDbOrInitiate() {
        instance = MongoInteractor.getInstance().getIdGenerator();
        if (instance == null)
            instance = new IdGeneratorImplRobust();
    }

    public IdGeneratorImplRobust(){
        this.nextId = 0;
        uniqueKey = MongoConstants.UniqueCollectionKey;
    }

    public String getUniqueKey() {
        return uniqueKey;
    }

    public void setUniqueKey(String uniqueKey) {
        this.uniqueKey = uniqueKey;
    }

    public int generateNumber() {
        nextId++;
        Thread thread = new Thread(()->MongoInteractor.getInstance().saveIdGeneratorToDb(this));
        thread.start();
        return nextId;
    }

    public int getNextId() {
        return nextId;
    }

    public void setNextId(int nextId) {
        this.nextId = nextId;
    }

}
