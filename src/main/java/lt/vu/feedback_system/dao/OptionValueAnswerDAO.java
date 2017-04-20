package lt.vu.feedback_system.dao;

import lt.vu.feedback_system.entities.answers.OptionValueAnswer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class OptionValueAnswerDAO {
    @Inject
    private EntityManager em;

    public void create(OptionValueAnswer optionValueAnswer) {
        em.persist(optionValueAnswer);
    }

}
