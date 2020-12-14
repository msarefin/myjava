package a_Practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
import com.google.api.services.drive.model.FileList;

public class PracticeGoogleDrive {

	public static void main(String[] args) throws IOException, GeneralSecurityException {
		Logger.getLogger("com.google.apis").setLevel(Level.WARNING);
		System.out.println("Google\ndrive");
		String credentialFile = System.getProperty("user.dir") + "/resources/client_secret.json";
		String tokenDirectoryPath = System.getProperty("user.dir") + "/GoogleToken/token/";
		List<String> scopes = Collections.singletonList(DriveScopes.DRIVE_METADATA_READONLY);

		NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
		JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
		InputStream inp = new FileInputStream(
				new File(System.getProperty("user.dir") + "/resources/client_secret.json"));
//		InputStream in = PracticeGoogleDrive.class.getResourceAsStream(System.getProperty("user.dir")+"/resources/client_secret.json");
		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(jsonFactory, new InputStreamReader(inp));
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(httpTransport, jsonFactory,
				clientSecrets, scopes).setDataStoreFactory(new FileDataStoreFactory(new File(tokenDirectoryPath)))
						.setAccessType("offline").build();
		LocalServerReceiver receiver = new LocalServerReceiver();
//		LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();

		Drive service = new Drive.Builder(httpTransport, jsonFactory,
				new AuthorizationCodeInstalledApp(flow, receiver).authorize("user")).setApplicationName("My Drive")
						.build();

//		-- Google Drive

		FileList result = service.files().list().setPageSize(100).setFields("nextPageToken,files(id, name)").execute();

		List<com.google.api.services.drive.model.File> files = result.getFiles();

		List fileName = new ArrayList();
		for (com.google.api.services.drive.model.File f : files) {
//			System.out.printf("%s (%s)\n", f.getName(), f.getId());
			String n = f.getName(); 
			String id = f.getId(); 
//			System.out.println(n+"--->"+id);
			
			if(n.equals("My SpreadSheet")) {
				System.out.println(n+"--->"+id);
//				service.files().delete(id).execute();
				
			}

		}

		System.out.println("-".repeat(10));
		for (int i = 0; i < fileName.size(); i++) {
			System.out.println(fileName.get(i));
		}

	}
}
