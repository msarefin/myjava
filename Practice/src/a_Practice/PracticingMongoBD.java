package a_Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.ListCollectionsIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.connection.Server;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public class PracticingMongoBD {

	public static void main(String[] args) {
		System.setProperty("jdk.tls.trustNameService", "true");
		String uriString = "mongodb+srv://arefin:qatester@cluster0.ytxrr.mongodb.net/<dbname>?retryWrites=true&w=majority";
		MongoCredential credential = MongoCredential.createCredential("arefin", "MyMongoDB", "qatester".toCharArray()); 
		MongoClient mongoClient = new MongoClient(new MongoClientURI(uriString)); 
		List<String> dbName = mongoClient.getDatabaseNames();
		for(String db : dbName) {
			String n = mongoClient.getDatabase(db).listCollectionNames().toString();
			System.out.println(n);
		}
		System.out.println();
	}

}

class mongodbAtlas{
	
	private final static void MongoDBOnline() {
		System.setProperty("jdk.tls.trustNameService", "true");

		String connectionString = "mongodb+srv://arefin:qatester@cluster0.ytxrr.mongodb.net/<dbname>?retryWrites=true&w=majority";

		MongoCredential credential = MongoCredential.createCredential("arefin", "NewDatabase", "qatester".toCharArray());
		
		MongoClientURI uri = new MongoClientURI(connectionString);
		MongoClient client = new MongoClient(uri);

		MongoDatabase database = client.getDatabase("NewDatabase");
		MongoCollection collection = database.getCollection("NewCollection");

		Document document = new Document("Name", "Daniel Craig").append("Age", 22).append("Country", "United States");
		collection.insertOne(document);
	}
	
	private final static void MongoDBOnlineConnection() {

		MongoClientURI uri = new MongoClientURI(
				"mongodb+srv://automator:automator@cluster0.ytxrr.mongodb.net/NewMongo?retryWrites=true&w=majority");

		MongoClient mongoClient = new MongoClient(uri);

		MongoDatabase mongodatabase = mongoClient.getDatabase("NewMongo");
		MongoCollection collection = mongodatabase.getCollection("MyTest");

		Document document = new Document("Name", "Arefin").append("Sex", "Male").append("age", "22").append("Country",
				"USA");

		collection.insertOne(document);

	}
}

class mongodbLocal {

	private final static void localMongoDB() {
		MongoClient mc = new MongoClient("localhost", 27017);
		MongoDatabase mdb = mc.getDatabase("PeopleNTech");

		MongoCollection<Document> collection = mdb.getCollection("Students");
		Document doc = new Document().append("ID", "2").append("Name", "Donald Duck").append("age", 32)
				.append("Country", "USA").append("State", "New York").append("City", "New York City");
		collection.insertOne(doc);

		doc.clear();
		mc.close();
	}

}
