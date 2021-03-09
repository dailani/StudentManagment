package studentmanagment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDataOper {

	private static String url = "jdbc:mysql://localhost:3306/my_future?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static String username = "root";
	private static String pass = "dailani123";

	public static void main(String[] args) {

	}

	public static Connection getConnection() throws Exception {
		try {

			Connection conn = DriverManager.getConnection(url, username, pass);
			System.out.println("Connected");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static int saveStudent(StudentMF s) throws Exception {
		int status = 0;
		try {
			Connection conn = DriverManager.getConnection(url, username, pass);
			PreparedStatement ps = conn.prepareStatement("insert into "
					+ "students(firstname,lastname ,phoneno,email, course,fee,date , due  ) " + "values(?,?,?,?,?,?,?,?)");
			ps.setString(1, s.getFirstname());
			ps.setString(2, s.getLastname());
			ps.setString(3, s.getPhoneno());
			ps.setString(4, s.getEmail());
			ps.setString(5, s.getCourse());
			ps.setInt(6, s.getFee());
			ps.setString(7, s.getDate());
			ps.setInt(8, s.getDue());

			status = ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public static int update(StudentMF s){
		int status=0;
		try{
			Connection conn = DriverManager.getConnection(url, username, pass);
			PreparedStatement ps=conn.prepareStatement("update students   set firstname=?, lastname=? , phoneno=?, email=?,course=?,fee=?,date=?,due=? where idstudents=?" );
			ps.setString(1,s.getFirstname());
			ps.setString(2, s.getLastname());
			ps.setString(3, s.getPhoneno());
			ps.setString(4, s.getEmail());
			ps.setString(5, s.getCourse());
			ps.setInt(6, s.getFee());
			ps.setString(7, s.getDate());
			ps.setInt(8, s.getDue());		
			ps.setInt(9, s.getRollno());
			status=ps.executeUpdate();
			conn.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static int delete(int rollno){
		int status=0;
		try{
			Connection conn = DriverManager.getConnection(url, username, pass);
			PreparedStatement ps=conn.prepareStatement("delete from students  where idstudents=?" );
			ps.setInt(1,rollno);
			status = ps.executeUpdate();
			
			conn.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int deleteTask(int id){
		int status=0;
		try{
			Connection conn = DriverManager.getConnection(url, username, pass);
			PreparedStatement ps=conn.prepareStatement("delete from notes  where idnotes=?"  );
			ps.setInt(1,id);
			status = ps.executeUpdate();
//			int statusAI = alterAI(id);
//			if(statusAI < 1) return statusAI;
			conn.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int alterAI(int id){
		int status=0;
		try{
			String sql = "ALTER TABLE notes AUTO_INCREMENT=?";
			Connection conn = DriverManager.getConnection(url, username, pass);
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1,id);
			status = st.executeUpdate();
			
			conn.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	
	
	

	

	
	
	public static List<StudentMF> viewStudent() {
		List<StudentMF> viewStudentList = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(url, username, pass);
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM students ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StudentMF s = new StudentMF(rs.getInt("idstudents") ,rs.getString("firstname"), rs.getString("lastname"),
						rs.getString("phoneno"),rs.getString("email"), rs.getString("course"), rs.getInt("fee"), rs.getString("date"),
						rs.getInt("due"));
				viewStudentList.add(s);
			}
			conn.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return viewStudentList;
	}
	
	public static List<String> viewTitleTask() {
		List<String> viewTitlelst = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(url, username, pass);
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM notes ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				viewTitlelst.add(rs.getInt("idnotes")+ "  " + rs.getString("tasktitle"));
			}
			conn.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return viewTitlelst;
	}
	
	public static StudentMF getStudentByRollno(int rollno){
		StudentMF s= new StudentMF();
		try{
			Connection conn = DriverManager.getConnection(url, username, pass);
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM students WHERE idstudents=? ");
			ps.setInt(1,rollno);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				s.setRollno(rs.getInt("idstudents"));
				s.setFirstname(rs.getString("firstname"));
				s.setLastname(rs.getString("lastname"));
				s.setPhoneno(rs.getString("phoneno"));
				s.setEmail(rs.getString("email"));
				s.setCourse(rs.getString("course"));
				s.setFee(rs.getInt("fee"));
				s.setDate(rs.getString("date"));
				s.setDue(rs.getInt("due"));
				
			}
			conn.close();
		}catch(Exception e){System.out.println(e);}
		return s;
	}
	
	public static List<StudentMF> viewCourse( String c) {
		List<StudentMF> viewCourse = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(url, username, pass);
			PreparedStatement ps = conn.prepareStatement("SELECT * from students WHERE  course LIKE ? ");
			ps.setString(1, "%"+c+ "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StudentMF s = new StudentMF(rs.getInt("idstudents") , rs.getString("firstname"), rs.getString("lastname"),
						rs.getString("phoneno"),rs.getString("email"), rs.getString("course"), rs.getInt("fee"), rs.getString("date"),
						rs.getInt("due"));
				viewCourse.add(s);
			}
			conn.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return viewCourse;
	}
	
	public static List<StudentMF> searchNameOper( String c) {
		List<StudentMF> viewCourse = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(url, username, pass);
			PreparedStatement ps = conn.prepareStatement("SELECT * from students WHERE  firstname LIKE ? OR lastname LIKE ? ");
			ps.setString(1, "%"+c+ "%");
			ps.setString(2, "%"+c+ "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StudentMF s = new StudentMF(rs.getInt("idstudents")  ,rs.getString("firstname"), rs.getString("lastname"),
						rs.getString("phoneno"),rs.getString("email"), rs.getString("course"), rs.getInt("fee"), rs.getString("date"),
						rs.getInt("due"));
				viewCourse.add(s);
			}
			conn.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return viewCourse;
	}
	
	public static List<StudentMF> viewEmails() {
		List<StudentMF> viewEmails = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(url, username, pass);
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM students WHERE email IS NOT NULL ");
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StudentMF s = new StudentMF(rs.getInt("idstudents") ,rs.getString("firstname"), rs.getString("lastname"),
						rs.getString("phoneno"),rs.getString("email"), rs.getString("course"), rs.getInt("fee"), rs.getString("date"),
						rs.getInt("due"));
				viewEmails.add(s);
			}
			conn.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return viewEmails;
	}
	
}
