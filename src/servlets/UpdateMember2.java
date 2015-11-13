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

/**
 * Servlet implementation class UpdateMember
 */
@WebServlet("/UpdateMember2")
public class UpdateMember2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMember2() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	public String addHtml(
		String planname,
		String firstname,
		String lastname,
		String middleinit,
		String address,
		String phonenum,
		String email,
		String cntctname,
		String cntctrel,
		String cntctphone) {
		String daHtml = "";
		
		System.out.println(planname + firstname + lastname + middleinit);
		
		daHtml += "<div class='row'><div class='col-lg-6'>First Name:<input type='text' class='form-control' name='firstname' id='firstname' value='" + firstname + "'></div></div>";
		daHtml += "<div class='row'><div class='col-lg-6'>Last Name:<input type='text' class='form-control' name='lastname' id='lastname' value='" + lastname + "'></div></div>";
		daHtml += "<div class='row'><div class='col-lg-6'>Middle Initial:<input type='text' class='form-control' name='midinit' id='midinit' value='" + middleinit + "'></div></div>";
		daHtml += "<div class='row'><div class='col-lg-6'>Address:<input type='text' class='form-control' name='address' id='address' value='" + address + "'></div></div>";
		daHtml += "<div class='row'><div class='col-lg-6'>Phone Number:<input type='text' class='form-control' name='phonenum' id='phonenum' value='" + phonenum + "'></div></div>";
		daHtml += "<div class='row'><div class='col-lg-6'>Email: <input type='text' class='form-control' name='email' id='email' value='" + email + "'></div></div>";
		daHtml += "<div class='row'><div class='col-lg-6'>Contact Name:<input type='text' class='form-control' name='cntctname' id='cntctname' value='" + cntctname + "'></div></div>";
		daHtml += "<div class='row'><div class='col-lg-6'>Contact's Relationship to Member:<input type='text' class='form-control' name='cntctrel' id='cntctrel' value='" + cntctrel + "'></div></div>";
		daHtml += "<div class='row'><div class='col-lg-6'>Contact's Phone number:<input type='text' class='form-control' name='cntctphn' id='cntctphn' value='" + cntctphone + "'></div></div>";
		daHtml += "<div class='row'><div class='col-lg-6'>Plan Name:<input type='text' class='form-control' name='planname' id='planname' value='" + planname + "'></div></div>";
		
		
		
		return daHtml;
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher requestDispatcher = null;
		DbConn dbc = new DbConn();
		ResultSet rs;
		
		String planid = "";
		String planname = "";
		String firstname = "";
		String lastname = "";
		String middleinit = "";
		String address = "";
		String phonenum = "";
		String email = "";
		String cntctname = "";
		String cntctrel = "";
		String cntctphone = ""; 
		String emrgncycntct = "";
		
		if(request.getParameter("memid") != "" && request.getParameter("memid") != "null"){
			try {
				rs = dbc.query("Select mbr.*, prsn.* from mbr left join prsn on mbr.prsn_id = prsn.prsn_id where mbr.MBR_ID='" + request.getParameter("memid") + "'");
				while(rs.next()){
					GO.updatePersonID = rs.getString("PRSN_ID");
					GO.updateMemberID = rs.getString("MBR_ID");
					planid = rs.getString("PLN");
					firstname = rs.getString("FRST_NM");
					lastname = rs.getString("LST_NM");
					middleinit = rs.getString("MID_INIT");
					address = rs.getString("ADDRS");
					phonenum = rs.getString("PHN_NUM");
					email = rs.getString("EML");
					emrgncycntct= rs.getString("EMRGNCY_CNTCT");
				}
				rs = dbc.query("Select * from emrgncy_cntct where id = '" + emrgncycntct +"'");
				while(rs.next()){
					cntctname = rs.getString("CNTCT_NM");
					cntctrel = rs.getString("REL");
					cntctphone = rs.getString("PHN_NUM");
				}
				rs = dbc.query("Select PLN_NM from pln where pln_id = '" + planid + "'");
				while(rs.next()) {
					planname = rs.getString("PLN_NM");
				}
				
				rs = dbc.query("Select mbr.*, prsn.* from mbr left join prsn on mbr.prsn_id = prsn.prsn_id where mbr.MBR_ID='" + request.getParameter("memid") + "'");
				while(rs.next()){
					GO.updatePersonID = rs.getString("PRSN_ID");
					GO.updateMemberID = rs.getString("MBR_ID");
					planid = rs.getString("PLN");
					firstname = rs.getString("FRST_NM");
					lastname = rs.getString("LST_NM");
					middleinit = rs.getString("MID_INIT");
					address = rs.getString("ADDRS");
					phonenum = rs.getString("PHN_NUM");
					email = rs.getString("EML");
					emrgncycntct= rs.getString("EMRGNCY_CNTCT");
				}
				rs = dbc.query("Select * from emrgncy_cntct where id = '" + emrgncycntct +"'");
				while(rs.next()){
					cntctname = rs.getString("CNTCT_NM");
					cntctrel = rs.getString("REL");
					cntctphone = rs.getString("PHN_NUM");
				}
				rs = dbc.query("Select PLN_NM from pln where pln_id = '" + planid + "'");
				while(rs.next()) {
					planname = rs.getString("PLN_NM");
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("Mbrdata", addHtml (planname,
					firstname,
					lastname,
					middleinit,
					address,
					phonenum,
					email,
					cntctname,
				    cntctrel,
					cntctphone));
			
		} else if (request.getParameter("email") != "" && request.getParameter("email") != "null") {
			try {
				rs = dbc.query("Select mbr.*, prsn.* from mbr left join prsn on mbr.prsn_id = prsn.prsn_id where mbr.MBR_ID='" + request.getParameter("memid") + "'");
				while(rs.next()){
					GO.updatePersonID = rs.getString("PRSN_ID");
					GO.updateMemberID = rs.getString("MBR_ID");
					planid = rs.getString("PLN");
					firstname = rs.getString("FRST_NM");
					lastname = rs.getString("LST_NM");
					middleinit = rs.getString("MID_INIT");
					address = rs.getString("ADDRS");
					phonenum = rs.getString("PHN_NUM");
					email = rs.getString("EML");
					emrgncycntct= rs.getString("EMRGNCY_CNTCT");
				}
				rs = dbc.query("Select * from emrgncy_cntct where id = '" + emrgncycntct +"'");
				while(rs.next()){
					cntctname = rs.getString("CNTCT_NM");
					cntctrel = rs.getString("REL");
					cntctphone = rs.getString("PHN_NUM");
				}
				rs = dbc.query("Select PLN_NM from pln where pln_id = '" + planid + "'");
				while(rs.next()) {
					planname = rs.getString("PLN_NM");
				}
				
				rs = dbc.query("Select mbr.*, prsn.* from mbr left join prsn on mbr.prsn_id = prsn.prsn_id where prsn.eml='" + request.getParameter("email") + "'");
				while(rs.next()){
					GO.updatePersonID = rs.getString("PRSN_ID");
					GO.updateMemberID = rs.getString("MBR_ID");
					planid = rs.getString("PLN_ID");
					firstname = rs.getString("FRST_NM");
					lastname = rs.getString("LST_NM");
					middleinit = rs.getString("MID_INIT");
					address = rs.getString("ADDRS");
					phonenum = rs.getString("PHN_NUM");
					email = rs.getString("EML");
					emrgncycntct= rs.getString("EMRGNCY_CNTCT");
				}
				rs = dbc.query("Select * from emrgncy_cntct where id = '" + emrgncycntct +"'");
				while(rs.next()){
					cntctname = rs.getString("CNTCT_NM");
					cntctrel = rs.getString("REL");
					cntctphone = rs.getString("PHN_NUM");
				}
				rs = dbc.query("Select PLN_NM from pln where pln_id = '" + planid + "'");
				while(rs.next()) {
					planname = rs.getString("PLN_NM");
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("Mbrdata", addHtml (planname,
					firstname,
					lastname,
					middleinit,
					address,
					phonenum,
					email,
					cntctname,
				    cntctrel,
					cntctphone));
			
		} else if ((request.getParameter("memfirstname") != "" && request.getParameter("memfirstname") != "null") && (
				request.getParameter("memlastname") != "" && request.getParameter("memlastname") != "null")){
			try {
				rs = dbc.query("Select mbr.*, prsn.* from mbr left join prsn on mbr.prsn_id = prsn.prsn_id where mbr.MBR_ID='" + request.getParameter("memid") + "'");
				while(rs.next()){
					GO.updatePersonID = rs.getString("PRSN_ID");
					GO.updateMemberID = rs.getString("MBR_ID");
					planid = rs.getString("PLN_ID");
					firstname = rs.getString("FRST_NM");
					lastname = rs.getString("LST_NM");
					middleinit = rs.getString("MID_INIT");
					address = rs.getString("ADDRS");
					phonenum = rs.getString("PHN_NUM");
					email = rs.getString("EML");
					emrgncycntct= rs.getString("EMRGNCY_CNTCT");
				}
				rs = dbc.query("Select * from emrgncy_cntct where id = '" + emrgncycntct +"'");
				while(rs.next()){
					cntctname = rs.getString("CNTCT_NM");
					cntctrel = rs.getString("REL");
					cntctphone = rs.getString("PHN_NUM");
				}
				rs = dbc.query("Select PLN_NM from pln where pln_id = '" + planid + "'");
				while(rs.next()) {
					planname = rs.getString("PLN_NM");
				}
				
				rs = dbc.query("Select mbr.*, prsn.* from mbr left join prsn on mbr.prsn_id = prsn.prsn_id where prsn.frst_nm like '" + request.getParameter("memfirstname") + "' and prsn.lst_nm like '" + request.getParameter("memlastname") + "'");
				while(rs.next()){
					GO.updatePersonID = rs.getString("PRSN_ID");
					GO.updateMemberID = rs.getString("MBR_ID");
					planid = rs.getString("PLN_ID");
					firstname = rs.getString("FRST_NM");
					lastname = rs.getString("LST_NM");
					middleinit = rs.getString("MID_INIT");
					address = rs.getString("ADDRS");
					phonenum = rs.getString("PHN_NUM");
					email = rs.getString("EML");
					emrgncycntct= rs.getString("EMRGNCY_CNTCT");
				}
				rs = dbc.query("Select * from emrgncy_cntct where id = '" + emrgncycntct +"'");
				while(rs.next()){
					cntctname = rs.getString("CNTCT_NM");
					cntctrel = rs.getString("REL");
					cntctphone = rs.getString("PHN_NUM");
				}
				rs = dbc.query("Select PLN_NM from pln where pln_id = '" + planid + "'");
				while(rs.next()) {
					planname = rs.getString("PLN_NM");
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("Mbrdata", addHtml (planname,
					firstname,
					lastname,
					middleinit,
					address,
					phonenum,
					email,
					cntctname,
				    cntctrel,
					cntctphone));
			
		} else {
			requestDispatcher = request.getRequestDispatcher(""
					+ "NonMemInput.jsp");
			requestDispatcher.forward(request, response);
		}
		
		request.setAttribute("PN", globals.GO.cUser.getPersonName());
		
		requestDispatcher = request.getRequestDispatcher("UpdateMember2.jsp");
		requestDispatcher.forward(request, response);
	}

}

