package apiTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

import org.apache.http.HttpStatus;
import org.junit.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.not; 

import Practice.reporting;
import io.restassured.response.Response;
import twitter.TwitterClient;

public class TweetsTest {

	protected TwitterClient tweetsClient;
	protected long tweetID;
	protected List<Long> tweetIDLIst;

	@BeforeClass
	public void setup() {
		tweetsClient = new TwitterClient();
		this.tweetIDLIst = new ArrayList<Long>();  
	}

	@Test
	public void test() {
		tweetsClient.getUserTimeline();
	}

	@Test
	public void testUserCanTweet() throws Exception {
		String tweet = "Life is beautiful" + UUID.randomUUID();
		Response response = this.tweetsClient.createTweet(tweet);
		response.then().statusCode(HttpStatus.SC_OK);
		this.tweetID = response.path("id");
		this.tweetIDLIst.add(tweetID);
	}

	public void useCannotTweetTheSameResponseTwice() throws Exception {
		String tweet = "Eat a balanced meal!" + UUID.randomUUID();
		Response response = this.tweetsClient.createTweet(tweet);
		response.then().statusCode(HttpStatus.SC_OK);
		response = this.tweetsClient.createTweet(tweet);
		response.then().statusCode(HttpStatus.SC_FORBIDDEN);
		this.tweetID = response.path("id");
		this.tweetIDLIst.add(tweetID);

	}

	@Test(dependsOnMethods = { "testUserCanTweet" })
	public void userCanDeleteTweet() throws Exception {
		Response response = this.tweetsClient.deleteTweet(this.tweetID);
		response.then().statusCode(HttpStatus.SC_OK)
		.and()
		.body("$", not(this.tweetID))
		;
		this.tweetID = response.path("id");
		this.tweetIDLIst.add(tweetID);
	}
	
	@AfterClass
	public void cleanup() throws Exception	{
		if(this.tweetIDLIst != null) {
			for(Long tweetID : tweetIDLIst) {
				this.tweetsClient.deleteTweet(tweetID);
			}
		}
	}
}
