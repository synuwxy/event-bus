package com.synuwxy.demo.eventbus.web.filter;


import com.synuwxy.demo.eventbus.common.observer.ThreadObserver;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "ThreadFilter",urlPatterns = {"/obs/hello","/obs/world"})
public class ThreadFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        synchronized (this) {
            try {
                // 查库
                ThreadObserver.newInstance().add("userID",this);
                this.wait();
                filterChain.doFilter(servletRequest, servletResponse);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
