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

    public static String saveDetailsToDataBase(Facebook facebook) {
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(), fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoClientOptions.Builder options_builder = new MongoClientOptions.Builder();
        options_builder.maxConnectionIdleTime(60000);
        //options_builder.codecRegistry(pojoCodecRegistry);
        options_builder.socketKeepAlive(true);
        MongoClientURI uri = new MongoClientURI("mongodb+srv://royashcenazi:mongodb@facebookdatabase-yyc55.mongodb.net/test\n", options_builder);
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase("test");
        database = database.withCodecRegistry(pojoCodecRegistry);
        MongoCollection<AppUser> collection = database.getCollection("users", AppUser.class);
        AppUser appUser = null;
        String userName = null;
        try {
            appUser = collection.find().first();
            userName = facebook.getName();
        }catch (FacebookException fe){
            fe.printStackTrace();
        }

        if(appUser == null){
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

    public static void testQueryFromDataBase() {
        MongoClientURI uri = new MongoClientURI("mongodb+srv://royashcenazi:mongodb@facebookdatabase-yyc55.mongodb.net/test");
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(), fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<AppUser> collection = database.getCollection("users", AppUser.class);
        collection=collection.withCodecRegistry(pojoCodecRegistry);
        AppUser check = collection.find().first();
    }
}
