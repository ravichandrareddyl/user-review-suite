package com.userreview.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import com.userreview.model.AppInstance;

public class DbUtil {

	public static Connection getConnection(AppInstance instance)
			throws IllegalBlockSizeException, BadPaddingException, ClassNotFoundException, SQLException {
		Connection con = null;
		String driver = instance.getDbClass();
		String url = instance.getDbUrl();
		String cipherUserName = instance.getUser();
		String cipherpassword = instance.getPassword();
		String userName = FileEncryptionUtil.decrypt(cipherUserName);
		String password = FileEncryptionUtil.decrypt(cipherpassword);
		Class.forName(driver);
		con = DriverManager.getConnection(url, userName, password);
		return con;
	}
}
