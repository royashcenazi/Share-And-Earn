package DataBase;

public interface MongoElement {

    String getCollectionName();

    String getKey();

    Class getInClass();

    String getFieldName();
}
