package services;

import java.sql.SQLException;

import database.DbConn;

public class AddPlanService {
	
	public void addNewPlan(String planName, String planLName, String desc, String cost, String discount) throws SQLException{
		DbConn dbc = new DbConn();
		dbc.update("INSERT INTO PLN (PLN_NM, PLN_LNG_NM, PLN_DSCR, PLN_CST, PLN_DSCNT_CST) VALUES ('" +
				planName + "', '" + planLName + "', '" + desc + "', '" + cost + "', '" + discount + "')");
	}
}
