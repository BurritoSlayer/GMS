package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.AddPlanService;
import services.GetPlanDataService;

/**
 * Servlet implementation class AddPlan
 */
@WebServlet("/AddPlan")
public class AddPlan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPlan() {
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
		AddPlanService aps = new AddPlanService();
		try {
			aps.addNewPlan(request.getParameter("planName"), request.getParameter("planLName"), request.getParameter("desc"), request.getParameter("cost"), request.getParameter("discount"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("PN", globals.GO.cUser.getPersonName());
		GetPlanDataService gpds = new GetPlanDataService();
		request.setAttribute("Plans", gpds.getAllPlanData());
		requestDispatcher = request.getRequestDispatcher("Plans.jsp");
		requestDispatcher.forward(request, response);
	}

}
