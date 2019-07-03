package accessingMongoDB;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;;

public class WritingToMongodb {

	public static void main(String[] args) {

		MongoClient mongo = new MongoClient("localhost", 27017);

		MongoCredential credencial;
		credencial = MongoCredential.createCredential("arefin", "pnt", "abc123".toCharArray());

		MongoDatabase database = mongo.getDatabase("pnt");
		
		try {
			database.createCollection("SimpleCollection");
		}catch (Exception e) {
			System.err.println("Collection already exist !!");
		}
		
		MongoCollection<Document> collection = database.getCollection("SimpleCollection");

		Document document = new Document("title");
		
	}
}
