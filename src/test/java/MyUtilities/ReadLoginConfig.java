package MyUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadLoginConfig {
	Properties pro;

	public ReadLoginConfig() {
		File src = new File("./Configurations/login.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception occured: " + e.getMessage());
		}
	}

	public String getEmailId() {
		String emailId = pro.getProperty("email");
		return emailId;
	}

	public String getPassword() {
		String pass = pro.getProperty("password");
		return pass;
	}
}
