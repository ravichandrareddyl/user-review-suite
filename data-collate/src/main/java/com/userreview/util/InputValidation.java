package com.userreview.util;

import java.io.File;
import java.nio.file.Files;

import com.userreview.exception.BusinessException;
import com.userreview.model.App;
import com.userreview.model.ApplicationProperties;

import org.apache.commons.lang3.StringUtils;

public class InputValidation{
    public static void validateInput(App app) throws BusinessException {
        validateQuery(app);
    }

    public static void validateArgs(String filePath, String passPhrase) throws BusinessException {
        validateSecret(passPhrase);
        validateFilePath(filePath);
    }

    public static void validateFilePath(String filePath) throws BusinessException {
        File file = new File(filePath); 
        if (!file.exists() || !file.isDirectory()) {
            throw new BusinessException("Filepath provided is not a directory");
        }
    }



    public static void validateQuery(App app) throws BusinessException {
        String query = app.getQuery();
        if(StringUtils.isEmpty(query)) {
            throw new BusinessException("Application:"+ app.getName()+ " Query should not be Empty");
        }
        query = query.toUpperCase();
        int index = StringUtils.indexOfAny(query, new String[]{"INSERT", "DELETE", "DROP", "UPDATE", "TRUNCATE", "ALTER"});
        if (index > -1){
            throw new BusinessException("Application:"+ app.getName()+ " Query should be only select clause");
        }
    }

    public static void validateSecret(String secret) throws BusinessException{
        if(secret == null || (secret != null && secret.length() != 16)) {
            throw new BusinessException("Secret should be of length 16");
        }
    }
}