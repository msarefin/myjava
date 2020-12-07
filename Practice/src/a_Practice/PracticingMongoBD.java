package a_Practice;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class PracticingMongoBD {

	public static void main(String[] args) {
		
		

		System.setProperty("jdk.tls.trustNameService", "true"); 

		String connectionString = "mongodb+srv://arefin:qatester@cluster0.ytxrr.mongodb.net/<dbname>?retryWrites=true&w=majority";
		MongoClientURI uri = new MongoClientURI(connectionString);
		MongoClient client = new MongoClient(uri); 
		
		MongoDatabase database= client.getDatabase("NewDatabase"); 
		MongoCollection collection = database.getCollection("NewCollection"); 
		
		Document document = new Document("Name", "Arefin").append("Age", 25); 
		collection.insertOne(document);
		
		
		
	}

}

//class mongodbAtlas{
//	private final static void MongoDBOnlineConnection() {
//
//		MongoClientURI uri = new MongoClientURI(
//				"mongodb+srv://automator:automator@cluster0.ytxrr.mongodb.net/NewMongo?retryWrites=true&w=majority");
//
//		MongoClient mongoClient = new MongoClient(uri);
//
//		MongoDatabase mongodatabase = mongoClient.getDatabase("NewMongo");
//		MongoCollection collection = mongodatabase.getCollection("MyTest");
//
//		Document document = new Document("Name", "Arefin").append("Sex", "Male").append("age", "22").append("Country",
//				"USA");
//
//		collection.insertOne(document);
//
//	}
//}
//
//class mongodbLocal {
//
//	private final static void localMongoDB() {
//		MongoClient mc = new MongoClient("localhost", 27017);
//		MongoDatabase mdb = mc.getDatabase("PeopleNTech");
//
//		MongoCollection<Document> collection = mdb.getCollection("Students");
//		Document doc = new Document().append("ID", "2").append("Name", "Donald Duck").append("age", 32)
//				.append("Country", "USA").append("State", "New York").append("City", "New York City");
//		collection.insertOne(doc);
//
//		doc.clear();
//		mc.close();
//	}
//
//}
