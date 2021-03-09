package studentmanagment;



public class StudentMF {

	private int rollno;
	private String firstname,lastname , phoneno, course , date , email;
	private int fee,  due;

	
	public StudentMF() {}
	
	public StudentMF(String firstname ,String lastname , String phoneno ,String email,  String course ,   int fee , String date , int due) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.phoneno = phoneno;
		this.email = email;
		this.course = course;		
		this.fee = fee;
		this.date = date;
		this.due = due;
	}
	
	public StudentMF(int rollno , String firstname ,String lastname ,  String phoneno ,String email, String course , int fee , String date , int due) {
		super();
		this.rollno = rollno;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phoneno = phoneno;
		this.email = email;
		this.course = course;
		this.fee = fee;
		this.date = date;
		this.due = due;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
	

	// Sa paguan zakonisht
	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String month) {
		this.date = month;
	}

	public int getDue() {
		return due;
	}

	public void setDue(int due) {
		this.due = due;
	}
}
