package com.nhnacademy.hello.login;

import com.nhnacademy.hello.MultiServlet2;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private String initParamId;
    private String initParamPwd;
    private static final Logger log = Logger.getLogger(LoginServlet.class.getName());

    @Override
    public void init(ServletConfig config) throws ServletException {

        initParamId = config.getInitParameter("id");
        initParamPwd = config.getInitParameter("pwd");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // session이 있으면 가져오고 없으면 null
        HttpSession session = req.getSession(false);
        if(Objects.isNull(session) || Objects.isNull(session.getAttribute("id")) ){
            resp.sendRedirect("/login.html");
        }else{
            resp.sendRedirect("/index.jsp");
//            resp.setContentType("text/html");
//            resp.setCharacterEncoding("utf-8");

//            try(PrintWriter out = resp.getWriter()){
//                out.println("<!DOCTYPE html>");
//                out.println("<html>");
//                out.println("<head>");
//                out.println("<meta charset='utf-8'>");
//                out.println("</head>");
//                out.println("<body>");
//                out.println("login success : id =" + session.getAttribute("id") + "<br/>");
//                out.println("<a href='/index'>서블릿 홈페이지</a>");
//                out.println("<a href='/logout'>logout</a>");
//                out.println("</body>");
//                out.println("</html>");
//            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");

        if(initParamId.equals(id) && initParamPwd.equals(pwd)){
            //session 있으면 가져오고 없으면 생성
            HttpSession session = req.getSession();
            session.setAttribute("id",id);
            resp.sendRedirect("/login");
        }else{
            log.info("아이디/패스워드가 일치하지 않습니다.");
            resp.sendRedirect("/login.html");
        }

    }

}