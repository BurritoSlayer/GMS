package dao;

import java.util.List;

import models.Member;

public interface MemberDAO {
	 public List<Member> getAllMembers();
	 public Member getMember(int memID);
	 public void updateStudent(Member member);
	 public void deleteStudent(Member member);
}
