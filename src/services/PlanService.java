package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DbConn;

public class PlanService {
	
	public PlanService(){}

    public String getPlans() throws SQLException{
    	String daHtml = "";
    	ArrayList<String> plans = new ArrayList<String>();
    	
    	DbConn dbc = new DbConn();
    	ResultSet rs;
    	
    	rs = dbc.query("Select pln_nm from pln");
    	while(rs.next()){
    		plans.add(rs.getString("PLN_NM"));
    	}
    	
    	int planTracker = 0;
 	    
 	    if(plans.isEmpty()){
 	    	daHtml += "No members were found";
 	    } else {
 	    	for(String plan : plans){
 	    		 daHtml += "<div class='checkbox'>";
 	    		 daHtml += "<label><input type='radio' name='planname' id='planname' value='" + plans.get(planTracker) + "'>" + plans.get(planTracker) + "<label>";
 	    		 daHtml += "</div>";
 	    		 planTracker++;
 	    	}
 	    }
 	    
    	
    	return daHtml;		
    }
}
