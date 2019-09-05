package twitter;

import static io.restassured.RestAssured.given;

import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;

import io.restassured.response.Response;

public class TwitterClient extends BaseTwitter {

	protected final static String USER_TIMELINE_ENDPOINT = "/statuses/user_timeline.json"; 
	protected final static String TWEET_ENDPOINT = "/statuses/update.json";
	protected final static String  DESTROY_ENDPOINT = "/statuses/destroy.json";
	
	public void getUserTimeline() {
		given()
		.auth()
		.oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
		.when()
		.get(this.FullURL(USER_TIMELINE_ENDPOINT))
		.then()
		.statusCode(HttpStatus.SC_OK);
	}
	
	public Response createTweet(String tweet) {
	return 	given()
		.auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
		.param("status", tweet)
		.when()
		.post(this.FullURL(TWEET_ENDPOINT));
		
	}
	
	public Response deleteTweet(long tweetID) throws Exception{
		return given()
				.auth()
				.oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
				.queryParam("id", tweetID)
				.when()
				.post(this.FullURL(DESTROY_ENDPOINT));
				
		
	}
}
