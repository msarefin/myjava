package a_Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.ListCollectionsIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mysql.cj.jdbc.IterateBlock;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public class PracticingMongoBD {

	public static void main(String[] args) {
		Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
		
		System.setProperty("jdk.tls.trustNameService", "true");
		String uriString = "mongodb+srv://arefin:qatester@cluster0.ytxrr.mongodb.net/<dbname>?retryWrites=true&w=majority";
		MongoClient mongoClient = new MongoClient(new MongoClientURI(uriString));
		MongoIterable<String> dbName = mongoClient.listDatabaseNames();

		for (String db : dbName) {
			System.out.println("=".repeat(db.length()) + db + "=".repeat(db.length()));
			MongoIterable<String> collection = mongoClient.getDatabase(db).listCollectionNames();
			List colList = mongoClient.getDatabase(db).listCollectionNames().into(new ArrayList<String>());
			System.out.println(colList);
			for (String col : collection) {

				System.out.println(col);
				FindIterable<Document> doc = mongoClient.getDatabase(db).getCollection(col).find();
				Iterator it = doc.iterator(); 
				
				while(it.hasNext()) { 
					System.out.println(it.next());
				}

			}
		}
		mongoClient.close();
	}

}

class mongodbAtlas {

	private final static void MongoDBOnline() {
		System.setProperty("jdk.tls.trustNameService", "true");

		String connectionString = "mongodb+srv://arefin:qatester@cluster0.ytxrr.mongodb.net/<dbname>?retryWrites=true&w=majority";

		MongoCredential credential = MongoCredential.createCredential("arefin", "NewDatabase",
				"qatester".toCharArray());

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
