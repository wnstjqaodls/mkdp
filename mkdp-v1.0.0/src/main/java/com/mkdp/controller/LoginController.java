package com.mkdp.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mkdp.mapper.MemberMapper;
import com.mkdp.service.MemberService;
import com.mkdp.vo.MemberVO;

@CrossOrigin("*")
@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	MemberService service;
	
	@Autowired
	private SqlSessionFactory ssf;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)//
	public String login(HttpServletRequest request, HttpServletResponse response, @RequestBody HashMap<String, Object> credentials) throws UnsupportedEncodingException , Exception {
		boolean isLoginValid = false;
	    String email = (String) credentials.get("email");
	    String password = credentials.get("password").toString();
	    List<MemberVO> memberList = new ArrayList<MemberVO>();
		
		String decodedPasswd = URLDecoder.decode(password, "UTF-8");
		String enpassword = this.encryptPassword(decodedPasswd); //암호화 된 비밀번호
	   
	    logger.debug("로그인 요청 프로토콜 : "+request.getProtocol());
	    logger.debug("이메일 아이디는  	   : "+email);
	    logger.debug("비밀번호는  			   : "+password);
		
		// TODO : 쿼리로직 추가되어야함 (email, password 를 가지고 DB에 조회하는쿼리
	    SqlSession session = ssf.openSession();
	    MemberMapper mapper = session.getMapper(MemberMapper.class);
	    
	    memberList = mapper.getMemberInfo();

	    MemberVO memberResult = memberList.get(0);
	    String memName = (String) memberResult.getMem_name();
	    // TODO : getKiwoom_password 이 아닌 user 의 password 멤버변수를 가져와야함. 없으면 필드생성후 게터세터 생성해야함
	    String memPassword = (String) memberResult.getMem_password();
	    
		if ( memName.equals(email) && memPassword.equals(password) ) {
			isLoginValid = true;
			request.setAttribute("result", "성공");
			logger.info("로그인 성공  			   : ");
		}
		
		return "login";//login.jsp
	}
	
    /**
     * 비밀번호를 암호화하는 기능(복호화가 되면 안되므로 SHA-256 인코딩 방식 적용)
     *
     * @param data 암호화할 비밀번호
     * @return  result 암호화된 비밀번호
     * @exception Exception
     */
    private  String encryptPassword(String data) throws Exception {

		if (data == null) {
		    return "";
		}

		byte[] plainText = null;
		byte[] hashValue = null;
		plainText = data.getBytes();

		MessageDigest md = MessageDigest.getInstance("SHA-256");
		hashValue = md.digest(plainText);

		/*
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(hashValue);
		*/
		return new String(Base64.encodeBase64(hashValue));
    }

}
