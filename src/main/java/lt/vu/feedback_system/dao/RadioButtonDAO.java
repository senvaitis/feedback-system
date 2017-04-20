package lt.vu.feedback_system.dao;

import lt.vu.feedback_system.entities.questions.Checkbox;
import lt.vu.feedback_system.entities.questions.RadioButton;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class RadioButtonDAO {
    @Inject
    private EntityManager em;

    public void create(RadioButton radioButton) {
        em.persist(radioButton);
    }
}
