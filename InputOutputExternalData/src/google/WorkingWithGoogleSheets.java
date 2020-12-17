package google;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Arrays;
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
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;

public class WorkingWithGoogleSheets {

	public static void main(String[] args) throws IOException, GeneralSecurityException {
		
/*
 * 		Establishing the connection to Google Sheet on Google server
 */
		File file = new File(System.getProperty("user.dir")+"/resources/client_secret.json"); 
		//Locating the file
		InputStream in = new FileInputStream(file); //
		InputStreamReader credentialLocation = new InputStreamReader(in);
		JsonFactory jsonFactory = JacksonFactory.getDefaultInstance(); 
		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(jsonFactory, credentialLocation);
		
		NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport(); 
		List<String> scopes = Arrays.asList(SheetsScopes.SPREADSHEETS);
		
		FileDataStoreFactory dataStoreFactory = new FileDataStoreFactory(new File(".credencials/sheets-googleapis"));
		
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(httpTransport, jsonFactory, clientSecrets, scopes).setDataStoreFactory(dataStoreFactory).setAccessType("offline").build();
		
		LocalServerReceiver receiver = new LocalServerReceiver(); 
		
		Credential credentials = new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
		
		String applicationName = "I am not sure of the purpose of this Section !!!!"; 
		
		Sheets sheets = new Sheets.Builder(httpTransport, jsonFactory, credentials).setApplicationName(applicationName).build(); 
		
		
		
	}
}
