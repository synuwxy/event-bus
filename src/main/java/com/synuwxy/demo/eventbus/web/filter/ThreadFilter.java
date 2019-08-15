package com.synuwxy.demo.eventbus.web.filter;


import com.synuwxy.demo.eventbus.common.observer.ThreadObserver;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "ThreadFilter",urlPatterns = {"/obs/hello","/obs/world"})
public class ThreadFilter implements Filter {
    @Autowired
    private ThreadObserver threadObserver;


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        synchronized (this) {
            try {
                // 阻塞
                threadObserver.add("userID",this);
                this.wait();
                filterChain.doFilter(servletRequest, servletResponse);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
