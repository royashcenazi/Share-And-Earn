package DataBase;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import model.Company;
import model.CompanyBuilder;
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

    private MongoInteractor() {
        this.mongoUrl = MongoConstants.MONGO_URI;
        this.pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(), fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        this.mongoOptionBuilder = new MongoClientOptions.Builder();
        this.mongoOptionBuilder.maxConnectionIdleTime(60000);
        this.mongoOptionBuilder.codecRegistry(pojoCodecRegistry);
        this.mongoClientURI = new MongoClientURI("mongodb+srv://royashcenazi:mongodb@facebookdatabase-yyc55.mongodb.net/test\n", mongoOptionBuilder);
        this.mongoClient = new MongoClient(mongoClientURI);
    }

    public static MongoInteractor getInstance() {

        if (mongoInteractorInstance == null) {
            mongoInteractorInstance = new MongoInteractor();
        }

        return mongoInteractorInstance;
    }

    @Deprecated
    public String saveDetailsToDataBase2(Facebook facebook) {
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<User> collection = database.getCollection("users", User.class);
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
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<MongoElement> collection = database.getCollection(mongoElement.getCollectionName(), mongoElement.getInClass());
        boolean companyExistInDataBase = true;
        searchElem = collection.find(eq(mongoElement.getCollectionName(), mongoElement.getKey())).first();

        if (searchElem == null)
            companyExistInDataBase = false;

        if (companyExistInDataBase == false) {
            collection.insertOne(mongoElement);
        }
    }


    public void saveAppUserDetailsToDataBase(String name, String id) {
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<User> collection = database.getCollection("users", User.class);
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
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Company> collection = database.getCollection("companies", Company.class);
        Company searchCompany;
        searchCompany = collection.find(eq("name", company.getName())).first();

        if (searchCompany == null) {
            collection.insertOne(company);
        }
    }


    public boolean isCompanyExistInDataBase(Company company) {
        boolean companyExistInDB;
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Company> collection = database.getCollection("companies", Company.class);
        Company searchCompany;

        searchCompany = collection.find(eq(MongoConstants.CompanyCollection, company.getName())).first();
        companyExistInDB = (searchCompany != null);

        return companyExistInDB;
    }

    public List<Company> getAllCompanies() {
        //this method should return all companies on data base.
        List<Company> companies = new ArrayList<Company>();

        Company company1 = new CompanyBuilder()
                .setName("castro")
                .setLogoUrl("imgs/Castro.png").createCompany();

        companies.add(company1);

        Company company2 = new CompanyBuilder()
                .setName("dominos")
                .setLogoUrl("imgs/Dominos.png").createCompany();
        companies.add(company2);

        return companies;
    }
}
