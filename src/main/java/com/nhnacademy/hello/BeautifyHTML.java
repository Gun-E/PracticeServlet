package com.nhnacademy.hello;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;

@WebServlet(name = "beautifyHTML", urlPatterns = "/beautify")
public class BeautifyHTML extends HttpServlet {
    private static final Logger log = Logger.getLogger(BeautifyHTML.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String html = req.getParameter("html");
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");

        try (PrintWriter out = resp.getWriter()) {
            out.println(Jsoup.parse(html));
        } catch (Exception ex) {
            log.info(ex.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        try (BufferedReader reader = new BufferedReader(new FileReader(getServletContext().getRealPath("/WEB-INF/beautify.html")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                resp.getWriter().println(line);
            }
        }
    }
}