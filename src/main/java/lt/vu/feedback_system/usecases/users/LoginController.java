package lt.vu.feedback_system.usecases.users;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import lt.vu.feedback_system.businesslogic.users.Session;
import org.primefaces.component.password.Password;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Model
@Slf4j
public class LoginController {

    @Getter @Setter
    private String email;
    @Getter @Setter
    private String password;
    @Getter @Setter
    private String redirectUrl;

    @Inject
    private Session session;

    @Inject
    private NavigationBean navigationBean;

    public String doLogin() {
        session.login(email, password);

        if (session.isLoggedIn()) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getSessionMap().put("session", session);

            if (redirectUrl != null && !redirectUrl.isEmpty()) {
                return navigationBean.redirectTo(redirectUrl);
            } else {
                return navigationBean.redirectToIndex();
            }
        } else {
            FacesMessage msg = new FacesMessage("Wrong email or password!", "No details.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, msg);

            return navigationBean.toLogin();
        }
    }

    public String doLogout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

        session.logout();

        return navigationBean.toIndex();
    }

    public boolean isLoggedIn() {
        return session.isLoggedIn();
    }

    public boolean isAdmin() {
        return session.isAdmin();
    }

}
