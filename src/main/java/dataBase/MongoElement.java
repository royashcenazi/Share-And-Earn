package dataBase;

public interface MongoElement {

    String getCollectionName();

    String getKey();

    Class getInClass();

    String getFieldName();
}
