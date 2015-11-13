package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ecs.html.Html;

import org.apache.ecs.xhtml.h3;
import org.apache.ecs.xhtml.td;
import org.apache.ecs.xhtml.th;
import org.apache.ecs.xhtml.tr;

import database.DbConn;
import models.Member;

public class MemberService {
	public ArrayList<Member> members = new ArrayList<Member>();
	
	public String getAllMemberData(){
		ArrayList<String> memberIds = new ArrayList<String>();
		ArrayList<String> personIds = new ArrayList<String>();
		ArrayList<String> firstNames = new ArrayList<String>();
		ArrayList<String> lastNames = new ArrayList<String>();
		ArrayList<String> plans = new ArrayList<String>();
		ArrayList<String> startDates = new ArrayList<String>();
		ArrayList<String> lastLog = new ArrayList<String>();
				
	    DbConn dbc = new DbConn();
	    ResultSet rs;
	
	    try {
	    	
	    	int memFound = 0;
	    	rs = dbc.query("SELECT MBR.*, PRSN.FRST_NM, PRSN.LST_NM, PLN.PLN_NM FROM MBR "
	    			+ "LEFT JOIN PRSN ON MBR.PRSN_ID = PRSN.PRSN_ID "
	    			+ "LEFT JOIN PLN ON MBR.PLN = PLN.PLN_ID "
	    			+ "WHERE MBR.ACTIVE = '1' ORDER BY MBR_ID ASC");
	    	while(rs.next()){
	    		memberIds.add(rs.getString("MBR_ID"));
	    		plans.add(rs.getString("PLN_NM"));
	    		firstNames.add(rs.getString("FRST_NM"));
	    		lastNames.add(rs.getString("LST_NM"));
	    		startDates.add(rs.getString("STRT_DT"));
	    		lastLog.add(rs.getString("LST_LG_DT"));
	    	}

	    	/*
			rs = dbc.query("Select * from mbr where active = '1'");
			 while(rs.next()){
				 memberIds.add(rs.getInt("MBR_ID"));
				 planIDs.add(rs.getInt("PLN"));
				 personIds.add(rs.getInt("PRSN_ID"));
				 System.out.println("Member found " + memFound);
				 memFound++;
			 }
			 
			 for(Integer id : personIds){
				 rs = dbc.query("Select FRST_NM, LST_NM FROM PRSN WHERE PRSN_ID='" + id + "'");
				 while(rs.next()){
					 firstNames.add("FRST_NM");
					 lastNames.add("LST_NM");
				 }
			 }
			 
			 for(Integer id : planIDs){
				 rs = dbc.query("Select PLN_NM FROM PLN WHERE PLN_ID='" + id + "'");
				 while(rs.next()){
					 plans.add("PLN_NM");
				 }
			 }
			 */
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	    int mbrIdTracker = 0;
	    String daHtml = "";
	    
	    if(memberIds.isEmpty()){
	    	daHtml += "No members were found";
	    } else {
	    	for(String id : memberIds){
	    		 daHtml += "<tr>";
	    		 daHtml += "<td>" + id + "</td>";
	    		 daHtml += "<td>" + firstNames.get(mbrIdTracker) + "</td>";
	    		 daHtml += "<td>" + lastNames.get(mbrIdTracker) + "</td>";
	    		 daHtml += "<td>" + plans.get(mbrIdTracker) + "</td>";
	    		 daHtml += "<td>" + startDates.get(mbrIdTracker) + "</td>";
	    		 daHtml += "<td>" + lastLog.get(mbrIdTracker) + "</td>";
	    		 daHtml += "</tr>";
	    		 mbrIdTracker++;
	    	}
	    	/*
		    for(Integer id : personIds){
		    	html.addElement(new tr(
		    			new td(firstNames.get(prsnIdTracker))(
		    					new td(lastNames.get(prsnIdTracker))));
		    	html.addElement(new th(plans.get(prsnIdTracker)));
		    	html.addElement(new th());
		    	html.addElement(new th());
		    	prsnIdTracker++;
		    }
		    */
	    }
	
	    /*
	    htmlString = html.toString();
	    String removeHtml = "<html>";
	    String removeEndHtml = "</html>";
	    htmlString = htmlString.replaceAll(removeHtml, "");
	    htmlString = htmlString.replaceAll(removeEndHtml, "");
	    */
	    
	return daHtml;
	}
}
