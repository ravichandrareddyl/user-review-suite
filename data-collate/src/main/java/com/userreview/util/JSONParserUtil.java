package com.userreview.util;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.userreview.model.App;
import com.userreview.model.ApplicationProperties;

public class JSONParserUtil{

    private static final String fileName="properties.json";
    
    public static ApplicationProperties readProperties (String filePath) {
        ApplicationProperties applications= null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
			applications = objectMapper.readValue(new File(filePath+File.separator+fileName), ApplicationProperties.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return applications;
    }
}