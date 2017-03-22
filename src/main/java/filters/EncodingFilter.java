package filters;

        import javax.servlet.*;
        import java.io.IOException;


public class EncodingFilter implements Filter{

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig=filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        ServletContext servletContext=filterConfig.getServletContext();
        servletResponse.setContentType("text/html; charset=UTF-8");

        servletResponse.setCharacterEncoding("utf-8");
        servletRequest.setCharacterEncoding("utf-8");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        filterConfig=null;
    }
}