package servlets;

import java.io.IOException;
import java.sql.PreparedStatement;
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
 * Servlet implementation class UpdateMember3
 */
@WebServlet("/UpdateMember3")
public class UpdateMember3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMember3() {
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
		ResultSet rs = null;

		String planName = request.getParameter("planname");
		String planID = "";
		String contactID = "";
		String contactName = request.getParameter("cntctname");
		String rel = request.getParameter("cntctrel");
		String contactPhone = request.getParameter("cntctphn");
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String middleInit = request.getParameter("midinit");
		String address = request.getParameter("address");
		String phoneNum = request.getParameter("phonenum");
		String email = request.getParameter("email");

		System.out.println("cname " + contactName);
		
		try {
			rs = dbc.query("Select pln_id from pln where pln_nm like '" + planName + "'");
			while(rs.next()){
				planID = rs.getString("pln_id");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try {
			rs = dbc.query("Select emrgncy_cntct from prsn where prsn_id='" + GO.updatePersonID + "'");
			while(rs.next()){
				contactID = rs.getString("emrgncy_cntct");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		if(contactID == null || contactID == ""){
			try {
				dbc.update(
						"INSERT INTO emrgncy_cntct (cntct_nm, rel, phn_num) VALUES ('" + contactName + "', '" + rel + "', '" + contactPhone + "') " 
						  // + "ON DUPLICATE KEY UPDATE emrgncy_cntct set cntct_nm='" + contactName + "', rel='" + rel + "', phn_num='" + contactPhone + "' where id='" + contactID + "'"
				);
				rs = dbc.query("Select id from emrgncy_cntct where cntct_nm = '" + contactName + "' and phn_num = '" + contactPhone + "'");
				while(rs.next()){
					contactID = rs.getString("id");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			try {
				dbc.update("UPDATE emrgncy_cntct set cntct_nm='" + contactName + "', rel='" + rel + "', phn_num='" + contactPhone + "' where id='" + contactID + "'"
				);

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		try {
			dbc.update(
					//"INSERT INTO prsn (frst_nm, lst_nm, mid_init, addrs, phn_num, eml) VALUES ('" + firstName + "', '" + lastName + "', '" + middleInit + "', '" + address + "', '" + phoneNum + "', '" + email + "') where prsn_id='" + GO.updatePersonID + "' "  
					"UPDATE prsn set frst_nm='" + firstName + "', lst_nm='" + lastName + "', mid_init='" + middleInit + "', addrs='" + address + "', phn_num='" + phoneNum + "', eml='" + email + "', emrgncy_cntct='" + contactID + "' where prsn_id='" + GO.updatePersonID + "'"
			);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			dbc.update(
					// "INSERT INTO mbr (pln) VALUES ('" + planID + "') where mbr_id= '" + GO.updateMemberID + "' " +
					"UPDATE mbr set pln='" + planID + "' where mbr_id='" + GO.updateMemberID + "' "
			);
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
