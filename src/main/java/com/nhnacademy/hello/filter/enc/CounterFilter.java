package com.nhnacademy.hello.filter.enc;

import com.nhnacademy.hello.CounterUtils;
import java.io.IOException;
import javax.servlet.*;

public class CounterFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        CounterUtils.increaseCounter(servletRequest.getServletContext());
        filterChain.doFilter(servletRequest,servletResponse);
        }
}
