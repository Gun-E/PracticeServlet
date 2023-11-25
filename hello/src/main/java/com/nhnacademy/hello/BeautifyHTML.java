package com.nhnacademy.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;

@WebServlet("/beautifyHTML")
public class BeautifyHTML extends HttpServlet {
    private static final Logger log = Logger.getLogger(BeautifyHTML.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String html = req.getParameter("html");
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");

        try(PrintWriter out = resp.getWriter()){
            out.println(Jsoup.parse(html));
        }catch (Exception ex){
            log.info(ex.getMessage());
        }
    }
}