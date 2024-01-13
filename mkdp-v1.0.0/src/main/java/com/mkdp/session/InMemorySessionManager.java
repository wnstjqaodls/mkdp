package com.mkdp.session;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.mkdp.controller.LoginController;;

public class InMemorySessionManager implements SessionManager {

	private static final String LOGIN_MEMBER = "loginMember";
	
	@Autowired
	private UserSession userSession;
	
	@Override
    public void createSession(HttpSession session, String userId) {
        session.setAttribute(LOGIN_MEMBER, userId);
    }

	@Override
	public UserSession getSession(String sessionId) {
		// TODO Auto-generated method stub
		return (UserSession) userSession.getSessionInfoMap(sessionId);
	}
	
	@Override
    public void invalidateSession(HttpSession session) {
        String userId = (String) session.getAttribute(LOGIN_MEMBER);
        // 세션에 유저 ID가 있는지 확인
        session.invalidate();
    }

}