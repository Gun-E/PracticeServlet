package com.nhnacademy.hello.login;

import java.io.IOException;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/logoutServlet")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //session 있으면 가져오고 없으면 null
        HttpSession session = req.getSession(false);

        if(Objects.nonNull(session)) {
            session.invalidate();
        }

        Cookie cookie = new Cookie(req.getLocalName(),"JSESSIONID");
        if(Objects.nonNull(cookie)){
            cookie.setValue("");
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
        }

        resp.sendRedirect("/login.html");
    }
}
