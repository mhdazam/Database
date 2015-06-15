package mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;
import java.util.Arrays;

public class RetriveData {
	
	   public static void main( String args[] ){
		      try{   
			 // To connect to mongodb server
		         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
		         // Now connect to your databases
		         DB db = mongoClient.getDB( "test" );
		         System.out.println("Connect to database successfully");
		         //boolean auth = db.authenticate("ziyadusa", "ziyad05".toCharArray());
		         //System.out.println("Authentication: "+auth);         
		         DBCollection coll = db.getCollection("mycol");
		         System.out.println("Collection mycol selected successfully");
		         DBCursor cursor = coll.find();
		         int i=1;
		         while (cursor.hasNext()) { 
		            System.out.println("Inserted Document: "+i); 
		            System.out.println(cursor.next()); 
		            i++;
		         }
		      }catch(Exception e){
			     System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			  }
	   }
}
