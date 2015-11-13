package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import globals.GO;
import services.AddMemberService;
import services.MemberService;
import services.PlanService;

/**
 * Servlet implementation class EmpDashController
 */
@WebServlet("/EmpDashController")
public class EmpDashController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void addAllDashParams (HttpServletRequest request) throws SQLException{
		MemberService ms = new MemberService();
		PlanService pls = new PlanService();
		
		request.setAttribute("PN", GO.cUser.getPersonName());
		request.setAttribute("plans", pls.getPlans());
		request.setAttribute("mbrtable", ms.getAllMemberData());
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
		
		AddMemberService ams = new AddMemberService();

		try {
			ams.addNewMember(request.getParameter("firstname"), request.getParameter("lastname"), request.getParameter("middleinit"),
					request.getParameter("phonenum"), request.getParameter("address"), request.getParameter("email"), request.getParameter("cname"), 
					request.getParameter("rel"), request.getParameter("cphone"), request.getParameter("planname"), request.getParameter("elig"));
			
			addAllDashParams(request);
		} catch (SQLException e) {
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
