package ua.training.filter;

import com.sun.deploy.net.HttpRequest;
import ua.training.model.entity.User;
import ua.training.util.constants.AttributeNames;
import ua.training.util.constants.GlobalConstants;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.training.util.constants.URLs.LOGIN_PAGE;

public class AuthFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;

        User user = (User)req.getSession().getAttribute(AttributeNames.USER);
        String url =  req.getRequestURI();

        if (url.contains(GlobalConstants.ADMIN_PATTERN) && !user.isAdmin()){
            resp.sendRedirect(LOGIN_PAGE);
            return;
        }
        chain.doFilter(req, response);
    }

    @Override
    public void destroy() {

    }
}
