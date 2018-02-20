package com.userreview.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import com.userreview.db.UserReviewDAO;
import com.userreview.exception.BusinessException;
import com.userreview.model.App;
import com.userreview.model.AppInstance;
import com.userreview.model.ApplicationProperties;
import com.userreview.util.FileEncryptionUtil;
import com.userreview.util.InputValidation;
import com.userreview.util.JSONParserUtil;

import org.apache.commons.lang3.StringUtils;

public class GenerateExtract {

	private String filePath;
	private String passPhrase;

	public GenerateExtract(String filePath, String passPhrase) {
		this.filePath = filePath;
		this.passPhrase = passPhrase;
	}

	public void generateExtract() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, BusinessException, IllegalBlockSizeException, BadPaddingException, ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		ApplicationProperties appProperties = JSONParserUtil.readProperties(filePath);

		StringBuilder sb = new StringBuilder();
		List<String[]> userList = null;
		FileEncryptionUtil.setCiphers(this.passPhrase, this.filePath);
		for (App application : appProperties.getApplications()) {
			System.out.println("application====>" + application.getName());
			InputValidation.validateInput(application);
			for (AppInstance instance : application.getInstances()) {
				//System.out.println("instance name====>" + instance.getInstanceName());
				userList = fetchDataByInstance(application.getQuery(), application.getName(), instance);
				for (String[] user : userList) {
					String csList = StringUtils.join(user, ",");
					sb.append(csList != null ? csList : "").append(System.getProperty("line.separator"));
				}
			}
		}
		FileEncryptionUtil.writeToFile(sb.toString());
		String output = FileEncryptionUtil.readFromFile(passPhrase, filePath);
		System.out.println("output after encryption" + output);
		System.out.println("printed output");
		//System.out.println("priting complete string" + sb.toString()); 
	}

	public List<String[]> fetchDataByInstance(String query, String appName, AppInstance instance) throws SQLException,
			BusinessException, IllegalBlockSizeException, BadPaddingException, ClassNotFoundException {
		List<String[]> userList = null;
		UserReviewDAO dao = new UserReviewDAO();
		userList = dao.getUserList(query, appName, instance);
		return userList;
	}

}
