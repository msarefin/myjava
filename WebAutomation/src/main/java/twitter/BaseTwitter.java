package twitter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseTwitter {

	protected String baseURI;

	protected String apiKey;
	protected String apiSecretKey;
	protected String accessToken;
	protected String accessTokenSecret;

	private Properties properties = new Properties();
	private InputStream inputStream;

	public BaseTwitter() {
		this.baseURI = "https://api.twitter.com/1.1";

		try {
			this.inputStream = new FileInputStream(System.getProperty("user.dir") + "/Properties/auth.properties");
			this.properties.load(this.inputStream);

			this.apiKey = this.properties.getProperty("apiKey");
			System.out.println(apiKey);
			this.apiSecretKey = this.properties.getProperty("apiSecretKey");
			System.out.println(apiSecretKey);
			this.accessToken = this.properties.getProperty("accessToken");
			System.out.println(accessToken);
			this.accessTokenSecret = this.properties.getProperty("accessTokenSecret");
			System.out.println(accessTokenSecret);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (this.inputStream != null) {
				try {
					this.inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public String FullURL(String endpoint) {
		return this.baseURI+endpoint; 
	}
}
