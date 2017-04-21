package lt.vu.feedback_system.filters;

import lt.vu.feedback_system.businesslogic.users.Session;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Null;
import java.io.IOException;

/**
 * Filter checks if user is survey's creator.
 * If it isn't then request is being redirected to the index.xhml page.
 *
 */
public class SurveyCreatorPermissionFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (!response.isCommitted()) {
            Session session = (Session) ((HttpServletRequest) request).getSession().getAttribute("session");

            try {
                Integer surveyId = Integer.parseInt(request.getParameter("id"));

                if (!session.isAdmin() && !session.isSurveyCreator(surveyId)) {
                    String contextPath = ((HttpServletRequest) request).getContextPath();
                    ((HttpServletResponse) response).sendRedirect(contextPath + "/index.html");
                }

            } catch (NullPointerException ex) {
            } catch (NumberFormatException ex) {
            }
        }

        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }
}
