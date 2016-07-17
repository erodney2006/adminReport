package action;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class RegisterServlet extends HttpServlet{/**
 * 
 */
private static final long serialVersionUID = 1L;
public static int cust_id= 1,trans_id=1;
Connection con;
Statement stmt;
//Properties prop =new Properties();
RegisterServlet instance;

public Connection setup(){
	//load and register driver
	
	try
	{
		
		//prop.load(new FileReader("datasource.properties"));
	Class.forName("oracle.jdbc.OracleDriver");
	
	con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","rodney","multivision");
}

catch(ClassNotFoundException cnf)
{
	cnf.printStackTrace();
}
	catch(SQLException sql)
	{
		sql.printStackTrace();
	}
	//catch(FileNotFoundException e){e.printStackTrace();}
//catch(IOException e){e.printStackTrace();}

return con;




}

public void destroyConnection(){
	try {
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void textFile(){
	BufferedReader br=null;

	Statement stmt1;
	try{
		stmt1=con.createStatement();
		ResultSet rs2=stmt1.executeQuery("select ID from  adminreport2");
		rs2.next();
		
		
		cust_id=Integer.parseInt(rs2.getString(1));
		
		
		System.out.println(cust_id);
		
		
		System.out.println("found file, customer id done!");

		
		
	}catch(Exception e){
		try{
			
		System.out.println("create new custID.txt file with 0 for customer 1!");
		
		}catch(Exception w){}
		
	}
	
	
	}

public void updateTransactionFile(){
	BufferedReader br=null;

	Statement stmt1;
	try{
		stmt1=con.createStatement();
		ResultSet rs2=stmt1.executeQuery("select trans_ID from  adminreport2 ");
		rs2.next();
		
		


		trans_id=Integer.parseInt(rs2.getString(1));
		trans_id++;
		
		System.out.println(trans_id);
		
		System.out.println("found file, trans id done!");

		
		
	}catch(Exception e){e.printStackTrace();
		try{
			
		System.out.println("create new transID.txt file with 0 for transaction 1!");
		
		}catch(Exception w){w.printStackTrace();}
		
	}

	
	}
public void insertStudent(int id,String fname, String lname, String addr1, String addr2, String city, String state, String zip, String country,
		String date){
	try
	{
		
		//prop.load(new FileReader("datasource.properties"));
	Class.forName("oracle.jdbc.OracleDriver");
	
	con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","rodney","multivision");
}

catch(ClassNotFoundException cnf)
{
	cnf.printStackTrace();
}
	catch(SQLException sql)
	{
		sql.printStackTrace();
	}
	
try{
	stmt=con.createStatement();
	id++;
	System.out.println("('"+fname+"','"+lname+"','"+addr1+"','"+addr2+"','"+city+"','"+state+"','"+zip+"','"+country+"','"+date+"')");
		//stmt.executeUpdate("insert into ADMINREPORT2(ID,FISTNAME,LASTNAME,ADDRESS1,ADDRESS2,CITY,STATE,ZIP,COUNTRY,TIME) values("+id+",'"+fname+"','"+
	//lname+"','"+addr1+"','"+addr2+"','"+city+"','"+state+"','"+zip+"','"+country+"','"+date+"')");
		//System.out.println("('"+id+"','"+t_id+"','"+day+"','"+type +"','"+amount +"')");
		stmt.executeUpdate("insert into ADMINREPORT2 values("+id+",'"+fname+"','"+
	lname+"','"+addr1+"','"+addr2+"','"+city+"','"+state+"','"+zip+"','"+country+"','"+date+"')");
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}




}

public void updateQuery(){
	
	
	
	BufferedReader br=null;
	Globals.listCust.clear();
Statement stmt1;
	try{
		stmt1=con.createStatement();
		ResultSet rs2=stmt1.executeQuery("SELECT * FROM ADMINREPORT2 ");
		while(rs2.next()){
			
			Globals.listCust.add(rs2.getString(1)+" "+rs2.getString(2)+" "+rs2.getString(3)+" "+rs2.getString(4)+" "+rs2.getString(5)+" "+rs2.getString(6)+" "+rs2.getString(7)+" "+rs2.getString(8)+" "+rs2.getString(9)+" "+rs2.getString(10));
			
		}
		
		


		

		
		
	}catch(Exception e){e.printStackTrace();
		try{
			
		System.out.println("create new transID.txt file with 0 for transaction 1!");
		
		}catch(Exception w){w.printStackTrace();}
		
	}

	
}

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException,NullPointerException {

	String fname= req.getParameter("fname");
	String lname =req.getParameter("lname");
	String addr1= req.getParameter("addr1");
	String addr2 =req.getParameter("addr2");
	String city= req.getParameter("city");
	String state =req.getParameter("state");
	String zip= req.getParameter("zip");
	String country =req.getParameter("country");
	String date1;
	//String numbers=req.getParameter("zip");
	//int numb=Integer.parseInt(numbers);
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	System.out.println(dateFormat.format(date));
	String datestr=dateFormat.format(date);
	instance=new RegisterServlet();
	instance.setup();
	instance.textFile();
	
	instance.updateQuery();
	
	System.out.println(fname+" "+lname+" "+addr1+" "+addr2+" "+city+" "+state+" "+zip+" "+country+" "+datestr);
	
	instance.insertStudent(instance.cust_id,fname,lname,addr1,addr2,city,state,zip,country,datestr);
	
	RequestDispatcher rd;
	rd=req.getRequestDispatcher("Success.jsp");
	rd.forward(req, resp);
} 

}
