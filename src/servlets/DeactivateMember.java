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
 * Servlet implementation class DeactivateMember
 */
@WebServlet("/DeactivateMember")
public class DeactivateMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeactivateMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = null;
		
		DbConn dbc = new DbConn();
		
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		
		try {
			dbc.update("Update prsn set active = 0 where prsn_id ='" + GO.updatePersonID + "';");
			dbc.update("Update mbr set active = 0 where mbr_id = '" + GO.updateMemberID + "';");
			dbc.update("Update mbr_dts set end_dt = '" + sqlDate + "' where mbr_id = '" + GO.updateMemberID + "';");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MemberService ms = new MemberService();
		PlanService pls = new PlanService();
		
		request.setAttribute("PN", globals.GO.cUser.getPersonName());
		
		request.setAttribute("mbrtable", ms.getAllMemberData());
		try {
			request.setAttribute("plans", pls.getPlans());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		requestDispatcher = request.getRequestDispatcher("EmpDash.jsp");
		requestDispatcher.forward(request, response);
	}

}
