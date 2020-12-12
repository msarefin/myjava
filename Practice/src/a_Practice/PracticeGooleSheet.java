package a_Practice;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import javax.security.sasl.AuthenticationException;

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
import com.google.api.services.drive.model.FileList;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.mysql.cj.jdbc.jmx.LoadBalanceConnectionGroupManager;

public class PracticeGooleSheet {

	static JsonFactory  jsonFactory = JacksonFactory.getDefaultInstance(); 
	
	public static void main(String[] args) throws Exception {
//		Connect to Google API
		
		JsonFactory  jsonF	actory = JacksonFactory.getDefaultInstance();
		File file = new File(System.getProperty("user.dir")+"/Files/resources/client_secret.json");
		FileDataStoreFactory dataStroeFactory = new FileDataStoreFactory(file); 
		NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
		InputStream inputStream = PracticeGooleSheet.class.getResourceAsStream("client_secret.json");
		InputStreamReader credencialLocation = new InputStreamReader(inputStream); 
		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(jsonFactory, credencialLocation); 
		List<String> scopes = Arrays.asList(SheetsScopes.SPREADSHEETS);
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(httpTransport, jsonFactory, clientSecrets, scopes).setDataStoreFactory(dataStroeFactory).setAccessType("offline").build();
		LocalServerReceiver receiver = new LocalServerReceiver(); 
		Credential credential = new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
		
//		Obtain Drive service
		
		
		
//		Obtain sheet service
		
//		String appname= "MyGoogleSheet"; 
//		
//		Sheets sheets = new Sheets.Builder(httpTransport, jsonFactory, credential).setApplicationName(appname).build(); 
//		
////		Single range write 
//		
//		String spreadsheetId =""; 
//		String range = "A1"; 
//		
//		ValueRange content = new ValueRange().setValues(Arrays.asList(Arrays.asList("Expense January"), Arrays.asList("books","30"),Arrays.asList("pens","10"), Arrays.asList("Expense February"),Arrays.asList("cloths","30"),Arrays.asList("shoes","5"))); 
//		UpdateValuesResponse result = sheets.spreadsheets().values().update(spreadsheetId, range, content).setValueInputOption("RAW").execute(); 
		
	}

}


