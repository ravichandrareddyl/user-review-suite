package com.userreview;

import com.userreview.controller.GenerateExtract;
import com.userreview.exception.BusinessException;
import com.userreview.util.InputValidation;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

public class Application {
	
	public static void main(String[] args) throws BusinessException {
		try {
			if(args != null  && args.length == 2) {
				String dbFilePath = args[0];
				String passPhrase = args[1];
				InputValidation.validateArgs(dbFilePath, passPhrase);
				//System.out.println("arg1 ===>" + dbFilePath);
				//System.out.println("arg2 ===>" + passPhrase);
				GenerateExtract gen = new GenerateExtract(dbFilePath, passPhrase);
				gen.generateExtract();
			} else {
				//throw new BusinessException("Args missing");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("Handing unhandled exceptions");
			e.printStackTrace();
		}
		
	}
}
