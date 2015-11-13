package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DbConn;
import globals.GO;
import services.MemberService;
import services.PlanService;

/**
 * Servlet implementation class 
 */
@WebServlet(name="login",urlPatterns={"/login"})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = null;
		
		String username = request.getParameter("username");
		String psswrd = request.getParameter("password");

		DbConn dbc = new DbConn();
		ResultSet rs;
		
		/*
		 * Attempt to query user's inputted username and select their record.
		 * The global variable global user will then be updated with this user's info 
		 * from the result set returned from the query.
		 * Then try to match the current user object's password with the user inputted
		 * password. If success, then redirect to dashboard based on user's role.
		 */
		if(username != "" && username != null){
			try {
				rs = dbc.query("Select * from usr where usr_nm = '" + username + "'");
				while(rs.next()){
							GO.cUser.setUserID(rs.getInt("ID"));
							GO.cUser.setUsername(username);
							GO.cUser.setPassword(rs.getString("PSSWRD"));
							GO.cUser.setPersonid(rs.getInt("PRSN_ID"));
							System.out.println(GO.cUser.getPersonid());
							GO.cUser.setUserRole(rs.getInt("USR_RL"));		
				}
				
				if(GO.cUser.getPassword().equals(psswrd)){
					
					rs = dbc.query("Select FRST_NM FROM PRSN where prsn_id = '" + GO.cUser.getPersonid() + "'");
					while(rs.next()){
						GO.cUser.setPersonName(rs.getString("FRST_NM"));
					}
					
					String PN = GO.cUser.getPersonName();
					if(PN != "" && PN != null ){
						request.setAttribute("PN", PN);
					} else { 
						request.setAttribute("PN", "Uknown User");
					}
					
					rs = dbc.query("Select RL_NM from USR_RL where ID = '" + GO.cUser.getUserRole() + "'");
					while(rs.next()){
						GO.cUser.setUserRoleName(rs.getString("RL_NM"));
					}
					
					MemberService ms = new MemberService();
					PlanService pls = new PlanService();
					
					if (GO.cUser.getUserRoleName().equals("Admin")) {						
						request.setAttribute("mbrtable", ms.getAllMemberData());
						request.setAttribute("plans", pls.getPlans());
						
						requestDispatcher = request.getRequestDispatcher("EmpDash.jsp");
						requestDispatcher.forward(request, response);
					}
					
					if (GO.cUser.getUserRoleName().equals("Employee")) {
						request.setAttribute("mbrtable", ms.getAllMemberData());
						
						requestDispatcher = request.getRequestDispatcher("EmpDash.jsp");
						requestDispatcher.forward(request, response);
					}
					
					if (GO.cUser.getUserRoleName().equals("Guest")) {
						requestDispatcher = request.getRequestDispatcher("FailLogin.jsp"); //no guest dash yet
						requestDispatcher.forward(request, response);
					}
					 
					//add additional user role redirects if needed here..
				} else {
					requestDispatcher = request.getRequestDispatcher("FailLogin.jsp");
					requestDispatcher.forward(request, response);
				}
			
			} catch (SQLException e) {
				System.out.println("SQL error while querying username" + e);
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println(e);
			}
	    } else {

		requestDispatcher = request.getRequestDispatcher("FailLogin.jsp");
		requestDispatcher.forward(request, response);
	    }
	}

}

