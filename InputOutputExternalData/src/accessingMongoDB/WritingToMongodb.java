package accessingMongoDB;

import java.util.Iterator;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;;

public class WritingToMongodb {

	public static void main(String[] args) {

//		create mongoClient
		MongoClient mongo = new MongoClient("localhost",27017);
		System.out.println("MongoClient Created");
		
		String bdName = "PTT1";
		
//		create credenctial
		MongoCredential credencial = MongoCredential.createCredential("arefin", bdName, "abc123".toCharArray());
		System.out.println("mongoCredencial Created");
		
		//accessing database
		MongoDatabase database = mongo.getDatabase(bdName);
		System.out.println("database accessed");
//		System.out.println("Credencials: "+credencial);
		
		
		
//		creating collection 
		try {
			database.createCollection("MySampleCollection");
			System.out.println("new collection added");
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("collection already exit!!");
		}
		
//		retreiving collection 
		MongoCollection<Document> collection = database.getCollection("MySampleCollection");
		System.out.println("collection selected");
		
//		adding dcoument to collection
		Document document = new Document("title","QA Tester")
				.append("id", 1).append("name", "Mohammed")
				.append("description", "Web Automation")
				.append("company", "amazon.com")
				.append("location", "California, USA");
		
		collection.insertOne(document);
		
		collection.updateOne(Filters.eq("id",1), Updates.set("name", "Danny"));
		
		collection.deleteMany(Filters.all("name", "Mohammed"));
		
		
		collection = database.getCollection("MySampleCollection");
		System.out.println("collection selected");
		
//		get iterable object 
		
		FindIterable<Document> iterDoc = collection.find(); 
		
		
		int i = 1; 
		
		Iterator it = iterDoc.iterator(); 
		
		while(it.hasNext()) {
			System.out.println(it.next());
			i++; 
		}

	}
}
