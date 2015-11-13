package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DbConn;
import models.Member;

public class GetPlanDataService {
	public ArrayList<Member> members = new ArrayList<Member>();
	
	public String getAllPlanData(){
		ArrayList<String> planIds = new ArrayList<String>();
		ArrayList<String> planLongNames = new ArrayList<String>();
		ArrayList<String> descs = new ArrayList<String>();
		ArrayList<String> costs = new ArrayList<String>();
		ArrayList<String> plans = new ArrayList<String>();
		ArrayList<String> discCosts = new ArrayList<String>();
		
	    DbConn dbc = new DbConn();
	    ResultSet rs;
	
	    try {
	    	
	    	int memFound = 0;
	    	rs = dbc.query("SELECT * FROM PLN");
	    	while(rs.next()){
	    		planIds.add(rs.getString("PLN_ID"));
	    		plans.add(rs.getString("PLN_NM"));
	    		planLongNames.add(rs.getString("PLN_LNG_NM"));
	    		descs.add(rs.getString("PLN_DSCR"));
	    		costs.add(rs.getString("PLN_CST"));
	    		discCosts.add(rs.getString("PLN_DSCNT_CST"));
	    	}
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	    int mbrIdTracker = 0;
	    String daHtml = "";
	    
	    if(planIds.isEmpty()){
	    	daHtml += "No plans were found";
	    } else {
	    	for(String id : planIds){
	    		 daHtml += "<tr>";
	    		 daHtml += "<td>" + plans.get(mbrIdTracker) + "</td>";
	    		 daHtml += "<td>" + planLongNames.get(mbrIdTracker) + "</td>";
	    		 daHtml += "<td>" + descs.get(mbrIdTracker) + "</td>";
	    		 daHtml += "<td>" + costs.get(mbrIdTracker) + "</td>";
	    		 daHtml += "<td>" + discCosts.get(mbrIdTracker) + "</td>";
	    		 daHtml += "</tr>";
	    		 mbrIdTracker++;
	    	}

	    }
	    return daHtml;
	}
}
