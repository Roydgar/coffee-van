package ua.training.filter;

import ua.training.util.constants.GlobalConstants;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig){
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        servletResponse.setContentType(GlobalConstants.CONTENT_TYPE);
        servletResponse.setCharacterEncoding(GlobalConstants.CHARACTER_ENCODING);
        servletRequest.setCharacterEncoding(GlobalConstants.CHARACTER_ENCODING);

        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
    }
}
