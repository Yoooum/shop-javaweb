package com.prprv.shop.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author 未確認の庭師
 */
@WebFilter(filterName = "RouterFilter", urlPatterns = "/*")
public class RouterFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String path = servletRequest.getServletContext().getContextPath();
//        System.out.println(path);
        //放行
        filterChain.doFilter(servletRequest, servletResponse);
        String uri = servletRequest.getServletContext().getContextPath();
        System.out.println(uri);

    }
}
