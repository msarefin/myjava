package accessingMongoDB;

import java.util.Iterator;

import javax.print.Doc;

import org.bson.Document;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoOnline {

	public static void main(String[] args) {
		String link = "mongodb+srv://arefin:qatester@cluster0-bqtnc.mongodb.net/test?retryWrites=true&w=majority";
		link = "mongodb+srv://arefin:qatester@cluster0.ytxrr.mongodb.net/pnt?retryWrites=true&w=majority";
		MongoClientURI uri = new MongoClientURI(link);

		MongoClient mongoClient = new MongoClient(uri);
		
		MongoCredential credential = MongoCredential.createCredential("arefin", "pnt", "qatester".toCharArray());
		
		MongoDatabase database = mongoClient.getDatabase("pnt");
		
		try {
			
			database.createCollection("Tutorial");
			System.out.println("collection created");
			
		}catch (Exception e) {
			System.out.println("collection already exits");
		}
		
		MongoCollection<Document> collection  = database.getCollection("Tutorial");
		System.out.println("Collection selection");
		
		
		Document document  = new Document("Title","QA Tester")
				.append("Name", "Daniel")
				.append("Description", "Web Applipcation Tester")
				.append("company", "amazon.com")
				.append("Location", "Boston, MA");
		
		collection.insertOne(document);

	}
}
