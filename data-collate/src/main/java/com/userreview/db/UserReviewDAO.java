package com.userreview.db;

import com.userreview.exception.BusinessException;
import com.userreview.model.AppInstance;
import com.userreview.util.DbUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

public class UserReviewDAO {

	public List<String[]> getUserList(String query, String appName, AppInstance instance) throws SQLException, BusinessException, IllegalBlockSizeException, BadPaddingException, ClassNotFoundException {
		List<String[]> users = new ArrayList<String[]>();
		Connection con = DbUtil.getConnection(instance);
		if (con != null) {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				//total 8 columns
				users.add(new String[] { appName, //application name
						instance.getInstanceName(), //instance name
						rs.getString(1), // userId
						rs.getString(2), //userName
						rs.getString(3), //creationDate
						rs.getString(4), //lastLoginDate
						rs.getString(5), //instanceName,
						rs.getString(6) });
			}
			con.close();
		} else {
			throw new BusinessException("Connection is null for application:" + appName + " and instance" + instance.getInstanceName());
		}

		return users;
	}
}
