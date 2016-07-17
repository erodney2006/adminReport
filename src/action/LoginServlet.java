package action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class LoginServlet extends HttpServlet{

	
	
	Connection con;
	Statement stmt;
	//Properties prop =new Properties();
	LoginServlet instance;
	static boolean accept=false;
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
	
	public void destroyConnection(){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	public void retrieveStudent(String user, String pass){
		Globals global=new Globals();
		try{
		Statement stmt=con.createStatement();
		//store tuples from db table into a result set
		ResultSet rs=stmt.executeQuery("select cust_ID,username,password from BANKACCOUNTUSER");
		//display records
		while(rs.next())
		{
			un=rs.getString(2);ps=rs.getString(3);
			System.out.println("user:"+ un+" "+user+"pass:"+ps+" "+pass);
			if((user.equals(un))&&(pass.equals(ps)))
			{
				global.cust_id=Integer.parseInt(rs.getString(1));
				global.username=un;global.password=ps;
				Statement stmt2=con.createStatement();
				
				ResultSet rs2=stmt2.executeQuery("select cust_ID,trans_ID,day,type,amount from  bankaccount where cust_id="+global.cust_id+"");
				rs2.next();
				global.trans_id=Integer.parseInt(rs2.getString(2));
						global.day=rs2.getString(3);
						global.amount=Integer.parseInt(rs2.getString(5));
						
						
				
				accept=true;
			}
			System.out.println(accept);
		}
		stmt.close();
		}catch(SQLException sql){sql.printStackTrace();}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username= req.getParameter("username");
		String password =req.getParameter("password");
		instance=new LoginServlet();
		instance.setup();
		
		System.out.println(username);
		System.out.println(password);
		instance.retrieveStudent(username, password);
		if(accept==true){
		RequestDispatcher rd;
		rd=req.getRequestDispatcher("inbox.jsp");
		rd.forward(req, resp);
		System.out.println(accept);
		accept=false;
		}
		
		if(accept==false){
			RequestDispatcher rd;
			rd=req.getRequestDispatcher("login.jsp");
			//rd.forward(req, resp);
			System.out.println(accept);
			accept=false;
			}
		
}}
