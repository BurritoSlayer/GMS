package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DbConn;
import models.Member;

public class MemberDAOImpl implements MemberDAO{
   //list is working as a database
   List<Member> members;
   DbConn dbc = new DbConn();
   ResultSet rs;

   public MemberDAOImpl(){
	      members = new ArrayList<Member>();
   }

	@Override
	public List<models.Member> getAllMembers() {
		try {			
			rs = dbc.query("Select * from mbr where active = '1'");
			while(rs.next()){
				Member member = new Member();
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public models.Member getMember(int memID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStudent(models.Member member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteStudent(models.Member member) {
		// TODO Auto-generated method stub
		
	}
}
