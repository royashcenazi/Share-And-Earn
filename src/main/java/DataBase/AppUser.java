package DataBase;

public class AppUser  {

    private String faceBookId;

    private String name;

    public AppUser() {
    }

    public String getFaceBookId() {
        return faceBookId;
    }

    public void setFaceBookId(String faceBookId) {
        this.faceBookId = faceBookId;
//        this.setKey(faceBookId);
//        this.setCollectionName(MongoConstants.UsersCollection);
//        this.setInheritedClass(this.getClass());
//        this.setKey(this.getFaceBookId());

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
