package com.mkdp.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkdp.mapper.MemberMapper;
import com.mkdp.vo.MemberVO;

@Service
public class MemberService implements MemberServiceIF{
	
	@Autowired
	private SqlSessionFactory ssf;
	
	@Override
	public List<MemberVO> getMemberInfo() {
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		
		try (SqlSession session = ssf.openSession()) {
			MemberMapper mapper = session.getMapper(MemberMapper.class);

			memberList = mapper.getMemberInfo();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return memberList;
	}

}
