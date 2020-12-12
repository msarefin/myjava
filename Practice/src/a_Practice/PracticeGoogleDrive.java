package a_Practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;

public class PracticeGoogleDrive {

	
	public static void main(String[] args) throws IOException {
		String credentialPath = System.getProperty("user.dir") + "/Files/resources/client_secret.json";
		JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
		InputStream in = PracticeGoogleDrive.class.getResourceAsStream(credentialPath);
		NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(jsonFactory, new InputStreamReader(in));

		List<String> scopes = Collections.singletonList(DriveScopes.DRIVE_METADATA_READONLY);
		
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(httpTransport, jsonFactory,
				clientSecrets, scopes).setDataStoreFactory(new FileDataStoreFactory(new File(System.getProperty("user.dir")+"/Files/tokenFiles"))).setAccessType("offline").build();
		LocalServerReceiver receiver  = new LocalServerReceiver();
		Credential credentials = new AuthorizationCodeInstalledApp(flow, receiver).authorize("user"); 
		String appName = "My Drive";
		Drive service = new Drive.Builder(httpTransport, jsonFactory, credentials).setApplicationName(appName).build();
	}
}
