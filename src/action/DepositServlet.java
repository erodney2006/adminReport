package action;

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

public class DepositServlet extends HttpServlet {
	
	Connection con;
	Statement stmt;
	//Properties prop =new Properties();
	LoginServlet instance;
	
	String un="",ps="";
	
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
	public void updateStudent(int id, int amount,int trans_id){try{
		
		stmt=con.createStatement();
		
		ResultSet rs=stmt.executeQuery("select amount from BANKACCOUNT where cust_id="+id);
		rs.next();
		int oldnum= Integer.parseInt( rs.getString(1));
		oldnum+=amount;
		
		Globals.amount=oldnum;
		
		stmt.executeUpdate("update bankaccount set amount=" + oldnum + " where cust_id=" + id);
		stmt.executeUpdate("update bankaccount set trans_id=" + trans_id + " where cust_id=" + id);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		String datestr=dateFormat.format(date);
		Globals.day=datestr;
		stmt.executeUpdate("update bankaccount set day=" + datestr + " where cust_id=" + id);
		stmt.executeUpdate("update bankaccount set type=" + "deposit" + " where cust_id=" + id);
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	RequestDispatcher rd;
	
	if(Globals.ddscreen==true)
	{
		setup();
		Globals.trans_id++;
		updateStudent(Globals.cust_id,Globals.amount,Globals.trans_id);
		
		rd=req.getRequestDispatcher("/inbox.jsp");
		rd.forward(req, resp);
		Globals.ddscreen=false;
		
	}
	else if(Globals.ddscreen==false){
	rd=req.getRequestDispatcher("/deposit.jsp");
	rd.forward(req, resp);
	Globals.ddscreen=true;
	}
}
}
