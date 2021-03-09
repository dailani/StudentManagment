package studentmanagment;

public class AccountantMF {
	private int id;
	private String name,password,email,phoneno;
	public AccountantMF() {}
	public AccountantMF(String name, String password, String email, String phoneno) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.phoneno = phoneno;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
}
