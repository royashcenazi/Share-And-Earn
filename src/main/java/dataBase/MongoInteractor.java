package dataBase;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import model.Company;
import model.User;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import java.util.ArrayList;
import java.util.List;
import static com.mongodb.client.model.Filters.*;
import static dataBase.MongoConstants.*;
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


    public Company getCompanyByName(String companyName) {
        MongoCollection<Company> companiesCollection = db.getCollection(CompanyCollection, Company.class);
        Company company = companiesCollection.find(eq(CompanyKey, companyName)).first();
        return company;
    }


    public void saveAppUserDetailsToDataBase(String name, String id) {
        MongoCollection<User> collection = db.getCollection(UsersCollection, User.class);
        User appUser;
        boolean userExistInDataBase = true;
        appUser = collection.find(eq(AppUserKey, id)).first();

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
        MongoCollection<Company> collection = db.getCollection(CompanyCollection, Company.class);
        Company searchCompany;
        searchCompany = collection.find(eq(CompanyKey, company.getName())).first();

        if (searchCompany == null) {
            collection.insertOne(company);
        }
    }

    public boolean updateCompanyInDataBase(Company company) {
        MongoCollection<Company> collection = db.getCollection(CompanyCollection, Company.class);
        Company searchCompany;
        searchCompany = collection.find(eq(CompanyKey, company.getName())).first();

        if (searchCompany != null) {
            collection.replaceOne(eq(CompanyKey, company.getName()), company);
        }
        else {
            return false;
        }
        return true;
    }


    public boolean updateUserInDataBase(User user) {
        MongoCollection<User> collection = db.getCollection(UsersCollection, User.class);
        User searchUser;
        searchUser = collection.find(eq(AppUserKey, user.getFaceBookId())).first();

        if (searchUser != null) {
            collection.replaceOne(eq(AppUserKey, user.getFaceBookId()), user);
        }
        else {
            return false;
        }
        return true;
    }

    public boolean isCompanyExistInDataBase(Company company) {
        boolean companyExistInDB;
        MongoCollection<Company> collection = db.getCollection(CompanyCollection, Company.class);
        Company searchCompany;

        searchCompany = collection.find(eq(CompanyCollection, company.getName())).first();
        companyExistInDB = (searchCompany != null);

        return companyExistInDB;
    }

    public List<Company> getAllCompanies() {
        List<Company> companies = new ArrayList<Company>();
        MongoCollection<Company> collection = db.getCollection(CompanyCollection, Company.class);
        MongoCursor<Company> cur = collection.find().iterator();

        while (cur.hasNext()) {
            companies.add(cur.next());
        }

        return companies;
    }

}
