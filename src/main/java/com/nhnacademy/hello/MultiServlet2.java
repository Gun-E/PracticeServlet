package com.nhnacademy.hello;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@WebServlet(name = "multiServlet2",urlPatterns = "/multi2")
public class MultiServlet2 extends HttpServlet {
    private static final Logger log = Logger.getLogger(MultiServlet2.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] values = req.getParameterValues("class");
        String url = getServletContext().getInitParameter("url");
        try(PrintWriter out = resp.getWriter()){
            out.println(String.join(",", values));
            out.printf("url:%s\n",url);
        }catch (IOException ex){
            log.info(ex.getMessage());
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        try (BufferedReader reader = new BufferedReader(new FileReader(getServletContext().getRealPath("/WEB-INF/multi2.html")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                resp.getWriter().println(line);
            }
        }
    }
}
