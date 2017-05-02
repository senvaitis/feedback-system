package lt.vu.feedback_system.usecases.surveys;

import lt.vu.feedback_system.businesslogic.users.UserContext;
import lt.vu.feedback_system.dao.SurveyDAO;
import lt.vu.feedback_system.entities.Survey;
import lt.vu.feedback_system.entities.User;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class RequestSurveysController implements Serializable {
    @Inject
    private SurveyDAO surveyDAO;
    @Inject
    private UserContext userContext;

    private User user;

    @PostConstruct
    public void loadUser() {
        user = userContext.getUser();
    }

    public List<Survey> getAllSurveys(){
        return surveyDAO.getAllSurveys();
    }

    public List<Survey> getAllUserSurveys(){
        return surveyDAO.getSurveysByCreatorId(user.getId());
    }
}