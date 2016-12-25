package mybean.data;

public class ModifyMessage {
	String logname = "", newAdvertiseTitle = "", newEmail = "", newPhone = "",
			newMessage = "", backNews;

	public void setLogname(String name) {
		logname = name;
	}

	public String getLogname() {
		return logname;
	}

	public void setNewAdvertiseTitle(String s) {
		newAdvertiseTitle = s;
	}

	public String getNewAdvertiseTitle() {
		return newAdvertiseTitle;
	}

	public void setNewEmail(String em) {
		newEmail = em;
	}

	public String getNewEmail() {
		return newEmail;

	}

	public void setNewPhone(String ph) {
		newPhone = ph;
	}

	public String getNewPhone() {
		return newPhone;
	}

	public String getNewMessage() {
		return newMessage;
	}

	public void setNewMessage(String m) {
		newMessage = m;
	}

	public String getBackNews() {
		return backNews;
	}

	public void setBackNews(String s) {
		backNews = s;
	}
}