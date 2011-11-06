package com.digitalnatura.jsonparser;

//import com.digitalnatura.filemanager.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;

import com.google.api.client.json.JsonParser;
import com.google.api.client.json.JsonToken;
import com.google.api.client.json.jackson.JacksonFactory;

public class JsonParserActivity extends Activity {
    private static final String LOGTAG = null;
	private String TAG = "logaritmo";
	private InputStream celdas;
	private String intext;
	private String dianoche;
	private String lugar;
	private String accion;
	private String personajes;
	private ArrayList<ObjetoEscaleta> oEscaleta;


	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        AssetManager am = getAssets();
//        String myString = IOUtils.toString(myInputStream, "UTF-8");
//        am.

       
			 try {
				celdas =am.open("celdas.json");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 	try {
					parserarJson();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		  
			
			
		     
		     
		     
		     
		 
		
		
    }
    
    public String convertStreamToString(InputStream is)
    throws IOException {
/*
 * To convert the InputStream to String we use the
 * Reader.read(char[] buffer) method. We iterate until the
 * Reader return -1 which means there's no more data to
 * read. We use the StringWriter class to produce the string.
 */
if (is != null) {
    Writer writer = new StringWriter();

    char[] buffer = new char[1024];
    try {
        Reader reader = new BufferedReader(
                new InputStreamReader(is, "UTF-8"));
        int n;
        while ((n = reader.read(buffer)) != -1) {
            writer.write(buffer, 0, n);
        }
    } finally {
        is.close();
    }
    return writer.toString();
} else {        
    return "";
}
}

	private void parserarJson() throws IOException {
		// TODO Auto-generated method stub
		oEscaleta = new ArrayList<ObjetoEscaleta>();
		JacksonFactory f = new JacksonFactory();     
	     
		JsonParser jParser = f.createJsonParser(convertStreamToString(celdas));
		
		 while (jParser.nextToken() != JsonToken.END_OBJECT) {
			 while (jParser.nextToken() != JsonToken.END_OBJECT) {
				 String fieldname = jParser.getCurrentName();

				 while (jParser.nextToken() != JsonToken.END_OBJECT) {

	        	 if ("openSearch$totalResults".equals(fieldname)){
//	        		 while (jParser.nextToken() != JsonToken.END_OBJECT) {
            	            	 String id1 = jParser.getText();
            					 Log.e(JsonParserActivity.LOGTAG,"algo "+ id1);


	        		 }   	
	        	 if ("gsx$intext".equals(fieldname)){
//	        		 while (jParser.nextToken() != JsonToken.END_OBJECT) {
            	            	 intext = jParser.getText();
//            					 Log.e(JsonParserActivity.LOGTAG,"algo "+ id1);


	        		 }   
	        	 if ("gsx$dianoche".equals(fieldname)){
//	        		 while (jParser.nextToken() != JsonToken.END_OBJECT) {
            	            	 dianoche = jParser.getText();
//            					 Log.e(JsonParserActivity.LOGTAG,"algo "+ id1);


	        		 }   
	        	 if ("gsx$lugar".equals(fieldname)){
//	        		 while (jParser.nextToken() != JsonToken.END_OBJECT) {
            	            	 lugar= jParser.getText();
//            					 Log.e(JsonParserActivity.LOGTAG,"algo "+ id1);


	        		 }   
	        	 if ("gsx$accion".equals(fieldname)){
//	        		 while (jParser.nextToken() != JsonToken.END_OBJECT) {
            	            	 accion = jParser.getText();
//            					 Log.e(JsonParserActivity.LOGTAG,"algo "+ id1);


	        		 }   
	        	 if ("gsx$personajes".equals(fieldname)){
//	        		 while (jParser.nextToken() != JsonToken.END_OBJECT) {
            	            	 personajes = jParser.getText();
//            					 Log.e(JsonParserActivity.LOGTAG,"algo "+ id1);


	        		 }   
				 }   
				
			 }   		
			 if (intext != null){
			 oEscaleta.add(new ObjetoEscaleta(intext, dianoche, lugar, accion, personajes));
	 }}
		 oEscaleta.remove(oEscaleta.size()-1);
		 Log.e(JsonParserActivity.LOGTAG,"algo "+ oEscaleta.toString());
	 jParser.close();
		
		
		
		
		
		
		
		
		
//		Log.e(TAG   , celdas);
	}
    
}
