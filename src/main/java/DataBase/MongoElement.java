package DataBase;

public class MongoElement {
    private String key;
    private String collectionName;
    private Class inheritedClass;

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Class getInheritedClass() {
        return inheritedClass;
    }

    public void setInheritedClass(Class inheritedClass) {
        this.inheritedClass = inheritedClass;
    }
}
