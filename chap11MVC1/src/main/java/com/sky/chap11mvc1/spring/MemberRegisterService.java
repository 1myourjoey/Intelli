package com.sky.chap11mvc1.spring;



import com.sky.chap11mvc1.repository.MemberBatisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class MemberRegisterService {
	@Autowired
	private MemberBatisDao memberBatisDao;



	public Long regist(RegisterRequest req) {
		Member member = memberBatisDao.selectByEmail(req.getEmail());
		if (member != null) {
			throw new DuplicateMemberException("dup email " + req.getEmail());
		}
		Member newMember = new Member(
				req.getEmail(), req.getName(), req.getPassword(), LocalDateTime.now());
		memberBatisDao.insert(newMember);
		return newMember.getId();
	}
}
