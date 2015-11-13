package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import database.DbConn;
import globals.GO;

public class AddMemberService {
	
	public Boolean addNewMember(String firstName, String lastName, String midInitial, String phoneNum, 
			String address, String email, String contactName, String contactRelationship, String contactPhone,
			String planName, String discountEligible) throws SQLException
	{
		DbConn dbc = new DbConn();
		ResultSet rs;
		
		String prsnId = null;
		String planId = null;
		String contactId = null;
		Boolean discElig = false; 
		String empId = null;
		String mbrId = null;
		
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		
		if(discountEligible.equals("yes")){
			discElig = true;
		}
		
		rs = dbc.query("Select EMP_ID FROM EMP WHERE PRSN_ID = '" + GO.cUser.getPersonid() + "'");
		while(rs.next()){
			empId = rs.getString("EMP_ID");
		}
		
		
		dbc.update("Insert into EMRGNCY_CNTCT (CNTCT_NM, REL, PHN_NUM) values ('" + contactName + "', '" + contactRelationship + "', '" + contactPhone + "')");
		rs = dbc.query("Select ID FROM EMRGNCY_CNTCT WHERE CNTCT_NM LIKE '" + contactName + "' and REL LIKE '" + contactRelationship +  "' AND PHN_NUM LIKE '" + contactPhone + "'");
		while (rs.next()){
			contactId = rs.getString("ID");
		}
		
		dbc.update("Insert into Prsn (FRST_NM, LST_NM, MID_INIT, ADDRS, PHN_NUM, EML, EMRGNCY_CNTCT, ACTIVE) values ('" + firstName + "', '"  + lastName + "', '"
				+ midInitial + "', '" + address + "', '" + phoneNum + "', '" + email + "',  '" + contactId + "', 1)");
		rs = dbc.query("Select PRSN_ID from prsn where FRST_NM LIKE '" + firstName + "' and LST_NM like '" + lastName + "' and EML like '" + email + "'");
		while(rs.next()){
			prsnId = rs.getString("PRSN_ID");
		}
		
		
		rs = dbc.query("SELECT PLN_ID FROM PLN WHERE PLN_NM LIKE '" + planName + "'"); 
		while(rs.next())
		{
			planId = rs.getString("PLN_ID");
		}
		
		System.out.println("discElig: " + discElig);
		dbc.update("INSERT INTO MBR (PRSN_ID, PLN, DSCNT_ELGBLE, ACTIVE, EMP_SBMTTR, STRT_DT, LST_LG_DT) VALUES ('" + prsnId + "',  '" + planId + "', " + discElig + ", 1, '" + empId + "', '" + sqlDate + "', '" + sqlDate + "')");
		
		rs = dbc.query("SELECT MBR_ID FROM MBR WHERE PRSN_ID LIKE '" + prsnId + "'");
		while(rs.next()){
			
			mbrId = rs.getString("MBR_ID");
		}
		
		dbc.update("Insert into mbr_dts (mbr_id, strt_dt) values ('" + mbrId + "', '" + sqlDate +  "')");

		
		return true;
	}
}
