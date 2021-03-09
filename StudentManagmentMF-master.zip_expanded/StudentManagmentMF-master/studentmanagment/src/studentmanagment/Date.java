package studentmanagment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;

import javax.swing.Timer;

public class Date {

	private static String url = "jdbc:mysql://localhost:3306/my_future?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static String username = "root";
	private static String pass = "dailani123";

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		Calendar due = Calendar.getInstance();
		due.set(2020, 10, 07, 11, 50);

		if (calendar.DATE == due.DATE) {
			int status = 0;
			try {
				Connection conn = DriverManager.getConnection(url, username, pass);
				PreparedStatement ps = conn.prepareStatement("UPDATE students SET due = -6000 ");
				status = ps.executeUpdate();
				conn.close();
		}

			catch (Exception e) {
				e.printStackTrace();
			}
		}
//
//	public static void main(String[] args) {
//		int the1st = 7;
//		int at16hrs = 11;
//
//		MonthlyTimer t = MonthlyTimer.schedule(new Runnable() {
//			public void run() {
//				int status = 0;
//				try {
//					Connection conn = DriverManager.getConnection(url, username, pass);
//					PreparedStatement ps = conn.prepareStatement("UPDATE students SET due = -6000 ");
//					status = ps.executeUpdate();
//					conn.close();
//				}
//	
//				catch (Exception e) {
//					e.printStackTrace();
//				}
//				
//			}
//		}, the1st, at16hrs);
		
		
		// will print "Hola" every 1st at 16:00 hrs.
		// if needed you can cancel with:
		//t.cancelCurrent();

	}
}
