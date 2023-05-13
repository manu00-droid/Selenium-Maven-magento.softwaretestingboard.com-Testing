package MyUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadCreateAccConfig {
	Properties pro;

	public ReadCreateAccConfig() {
		File src = new File("./Configurations/createAcc.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception occured: " + e.getMessage());
		}
	}

	public String getFirstName() {
		return pro.getProperty("firstName");
	}

	public String getLastName() {
		return pro.getProperty("firstName");

	}

	public String getEmailId() {
		return pro.getProperty("emailId");
	}

	public String getPassword() {
		return pro.getProperty("password");
	}
}
