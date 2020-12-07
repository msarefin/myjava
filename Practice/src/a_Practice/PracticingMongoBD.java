package a_Practice;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class PracticingMongoBD {

	public static void main(String[] args) {
//		MongoDBOnlineConnection();

		com.mongodb.client.MongoClient mongoClient = MongoClients.create(
				"mongodb+srv://automator:<password>@cluster0.ytxrr.mongodb.net/<dbname>?retryWrites=true&w=majority");
		MongoDatabase database = mongoClient.getDatabase("test");

		MongoCollection collection = database.getCollection("table1");

		Document document = new Document("Name", "Arefin").append("Sex", "Male").append("age", "22").append("Country",
				"USA");

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
