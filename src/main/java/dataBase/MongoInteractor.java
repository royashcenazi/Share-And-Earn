package dataBase;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import model.Company;
import model.User;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.List;

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
    private MongoDatabase db;

    private MongoInteractor() {
        this.mongoUrl = MongoConstants.MONGO_URI;
        this.pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(), fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        this.mongoOptionBuilder = new MongoClientOptions.Builder();
        this.mongoOptionBuilder.maxConnectionIdleTime(60000);
        this.mongoOptionBuilder.codecRegistry(pojoCodecRegistry);
        this.mongoClientURI = new MongoClientURI("mongodb+srv://royashcenazi:mongodb@facebookdatabase-yyc55.mongodb.net/test\n", mongoOptionBuilder);
        this.mongoClient = new MongoClient(mongoClientURI);
        this.db = mongoClient.getDatabase("test");
    }

    public static MongoInteractor getInstance() {

        if (mongoInteractorInstance == null) {
            mongoInteractorInstance = new MongoInteractor();
        }

        return mongoInteractorInstance;
    }

    @Deprecated
    public String saveDetailsToDataBase2(Facebook facebook) {
        MongoCollection<User> collection = db.getCollection("users", User.class);
        User appUser = null;
        boolean userExistInDataBase = true;
        String userName = null;
        try {
            appUser = collection.find(eq(MongoConstants.AppUserId, facebook.getId())).first();
            if (appUser.getFaceBookId() == null)
                userExistInDataBase = false;
            userName = facebook.getName();
        } catch (FacebookException fe) {
            fe.printStackTrace();
        }

        if (userExistInDataBase == false) {
            try {
                appUser = new User();
                appUser.setFaceBookId(facebook.getId());
                appUser.setName(facebook.getName());
                collection.insertOne(appUser);
            } catch (FacebookException fe) {
                fe.printStackTrace();
            }
        }
        return userName;
    }

    public void saveDetailsToDataBase(MongoElement mongoElement) {
        MongoElement searchElem;
        MongoCollection<MongoElement> collection = db.getCollection(mongoElement.getCollectionName(), mongoElement.getInClass());
        boolean companyExistInDataBase = true;
        searchElem = collection.find(eq(mongoElement.getCollectionName(), mongoElement.getKey())).first();

        if (searchElem == null)
            companyExistInDataBase = false;

        if (companyExistInDataBase == false) {
            collection.insertOne(mongoElement);
        }
    }

    public void saveAppUserDetailsToDataBase(String name, String id) {
        MongoCollection<User> collection = db.getCollection("users", User.class);
        User appUser;
        boolean userExistInDataBase = true;
        appUser = collection.find(eq(MongoConstants.AppUserId, id)).first();

        if (appUser == null)
            userExistInDataBase = false;

        if (userExistInDataBase == false) {
            appUser = new User();
            appUser.setFaceBookId(id);
            appUser.setName(name);
            collection.insertOne(appUser);
        }
    }

    public void saveCompanyToDataBase(Company company) {
        MongoCollection<Company> collection = db.getCollection("companies", Company.class);
        Company searchCompany;
        searchCompany = collection.find(eq("name", company.getName())).first();

        if (searchCompany == null) {
            collection.insertOne(company);
        }
    }

    public boolean isCompanyExistInDataBase(Company company) {
        boolean companyExistInDB;
        MongoCollection<Company> collection = db.getCollection("companies", Company.class);
        Company searchCompany;

        searchCompany = collection.find(eq(MongoConstants.CompanyCollection, company.getName())).first();
        companyExistInDB = (searchCompany != null);

        return companyExistInDB;
    }

    public List<Company> getAllCompanies() {
        List<Company> companies = new ArrayList<Company>();
        MongoCollection<Company> collection = db.getCollection("companies", Company.class);
        MongoCursor<Company> cur = collection.find().iterator();

        while (cur.hasNext()) {
            companies.add(cur.next());
        }

        return companies;
    }

    public MongoDatabase getDb() {
        return db;
    }

    public void setDb(MongoDatabase db) {
        this.db = db;
    }
}
