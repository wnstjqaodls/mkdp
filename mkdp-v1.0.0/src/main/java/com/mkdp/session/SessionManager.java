package com.mkdp.session;

import javax.servlet.http.HttpSession;

public interface SessionManager {
	
    void createSession(HttpSession session, String userId);    
    UserSession getSession(String sessionId);    
    void invalidateSession(HttpSession sessionId);
    
}

