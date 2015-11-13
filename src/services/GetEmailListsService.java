package services;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.DbConn;

public class GetEmailListsService {
	String emailList = "";
	
	public String getEmailList(String emailtype) throws SQLException{
		
		DbConn dbc = new DbConn();
		ResultSet rs;
		
		if(emailtype.equals("Active")){
			rs = dbc.query("Select eml from mbr left join prsn on mbr.prsn_id = prsn.prsn_id where mbr.active=1");
			while(rs.next()){
				emailList += rs.getString("eml");
				emailList += "\r\n";
			}
		} else if (emailtype.equals("Discurrent")){
			rs = dbc.query("Select eml from mbr left join prsn on mbr.prsn_id = prsn.prsn_id " +
							" where mbr.active = 1 and lst_lg_dt < date_sub(sysdate(), INTERVAL 2 MONTH); ");
			while(rs.next()){
				emailList += rs.getString("eml");
				emailList += "\r\n";
			}
		} else if (emailtype.equals("Inactive")){
			rs = dbc.query("Select eml from mbr left join prsn on mbr.prsn_id = prsn.prsn_id where mbr.active=0");
			while(rs.next()){
				emailList += rs.getString("eml");
				emailList += "\r\n";
			}
		}
		//TODO filter nulls
		
		System.out.println("Email List: " + emailList);
		return emailList;
	}
}
