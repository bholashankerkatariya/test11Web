package utils;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiCallForOtp {
	
	public String GetOtp(String mobileNo) {
		
		try {
			URL url = new URL("https://n2.myteam11.com/users/sentotpforqa");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			con.setDoOutput(true);
			con.setRequestMethod("POST");

			con.setRequestProperty("Mobile_Number", mobileNo);

			try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {

			}

			StringBuilder content;

			try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()))) {

				String line;
				content = new StringBuilder();

				while ((line = br.readLine()) != null) {
					content.append(line);
					content.append(System.lineSeparator());
				}
			}

			Data data = new Gson().fromJson(content.toString(), Data.class);

			// System.out.println(content.toString());
			// System.out.println("API OTP : "+data.getMessage());

			String OTP = data.getMessage();
			// return data.getMessage();
			return OTP;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}
}

class Data {

	private boolean TokenExpire;
	private String Message;
	private String NotificationKey;
	private String PollKey;
	private boolean IsAutoScrollHeader;
	private int Maxteam;
	private int CurrentDate;
	private String Response;
	private boolean Status;

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return Status;
	}

	/**
	 * @return the tokenExpire
	 */
	public boolean isTokenExpire() {
		return TokenExpire;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return Message;
	}

	/**
	 * @return the notificationKey
	 */
	public String getNotificationKey() {
		return NotificationKey;
	}

	/**
	 * @return the pollKey
	 */
	public String getPollKey() {
		return PollKey;
	}

	/**
	 * @return the isAutoScrollHeader
	 */
	public boolean isIsAutoScrollHeader() {
		return IsAutoScrollHeader;
	}

	/**
	 * @return the maxteam
	 */
	public int getMaxteam() {
		return Maxteam;
	}

	/**
	 * @return the currentDate
	 */
	public int getCurrentDate() {
		return CurrentDate;
	}

	/**
	 * @return the response
	 */
	public String getResponse() {
		return Response;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		Status = status;
	}

	/**
	 * @param tokenExpire the tokenExpire to set
	 */
	public void setTokenExpire(boolean tokenExpire) {
		TokenExpire = tokenExpire;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		Message = message;
	}

	/**
	 * @param notificationKey the notificationKey to set
	 */
	public void setNotificationKey(String notificationKey) {
		NotificationKey = notificationKey;
	}

	/**
	 * @param pollKey the pollKey to set
	 */
	public void setPollKey(String pollKey) {
		PollKey = pollKey;
	}

	/**
	 * @param isAutoScrollHeader the isAutoScrollHeader to set
	 */
	public void setIsAutoScrollHeader(boolean isAutoScrollHeader) {
		IsAutoScrollHeader = isAutoScrollHeader;
	}

	/**
	 * @param maxteam the maxteam to set
	 */
	public void setMaxteam(int maxteam) {
		Maxteam = maxteam;
	}

	/**
	 * @param currentDate the currentDate to set
	 */
	public void setCurrentDate(int currentDate) {
		CurrentDate = currentDate;
	}

	/**
	 * @param response the response to set
	 */
	public void setResponse(String response) {
		Response = response;
	}

}

