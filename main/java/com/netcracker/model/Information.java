package com.netcracker.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

public class Information {
    private String userAgent;
    private String time;

    public void setMessage(HttpServletRequest request) {
        HttpSession session = request.getSession();
        userAgent="User-Agent: " + request.getHeader("User-Agent");
        time ="Time: " + new Date().toString();
    }

    public String getUserAgent() {
        return userAgent;
    }

    public String getTime() {
        return time;
    }
}
