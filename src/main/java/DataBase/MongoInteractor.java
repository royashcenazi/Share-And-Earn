package DataBase;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import static com.mongodb.client.model.Filters.*;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MongoInteractor {
    private String mongoUrl;
    private static MongoInteractor mongoInteractorInstance;
    private CodecRegistry pojoCodecRegistry;
    private MongoClientOptions.Builder mongoOptionBuilder;
    private MongoClientURI mongoClientURI;
    private MongoClient mongoClient;

    private MongoInteractor() {
       this.mongoUrl = MongoConstants.MONGO_URI;
       this.pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(), fromProviders(PojoCodecProvider.builder().automatic(true).build()));
       this.mongoOptionBuilder =  new MongoClientOptions.Builder();
       this.mongoOptionBuilder.maxConnectionIdleTime(60000);
       this.mongoOptionBuilder.codecRegistry(pojoCodecRegistry);
       this.mongoClientURI = new MongoClientURI("mongodb+srv://royashcenazi:mongodb@facebookdatabase-yyc55.mongodb.net/test\n", mongoOptionBuilder);
       this.mongoClient = new MongoClient(mongoClientURI);
    }

    public static MongoInteractor getInstance(){

        if(mongoInteractorInstance == null){
            mongoInteractorInstance = new MongoInteractor();
        }

        return mongoInteractorInstance;
    }

    public String saveDetailsToDataBase(Facebook facebook) {
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<AppUser> collection = database.getCollection("users", AppUser.class);
        AppUser appUser = null;
        boolean userExistInDataBase = true;
        String userName = null;
        try {
            appUser = collection.find(eq("name", "Roy Ashcenazi")).first();
            if(appUser == null)
                userExistInDataBase = false;
            userName = facebook.getName();
        }catch (FacebookException fe){
            fe.printStackTrace();
        }

        if(userExistInDataBase == false){
            try {
                appUser = new AppUser();
                appUser.setId(facebook.getId());
                appUser.setName(facebook.getName());
                collection.insertOne(appUser);
            }catch (FacebookException fe){
                fe.printStackTrace();
            }
        }
        return userName;
    }
}
