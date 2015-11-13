package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.MemberService;
import services.PlanService;

/**
 * Servlet implementation class ReturnEmpDash
 */
@WebServlet("/ReturnEmpDash")
public class ReturnEmpDash extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnEmpDash() {
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
