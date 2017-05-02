package lt.vu.feedback_system.dao;

import lt.vu.feedback_system.entities.answers.SelectedCheckbox;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class SelectedCheckboxDAO {
    @Inject
    private EntityManager em;

    public void create(SelectedCheckbox selectedCheckbox) {
        em.persist(selectedCheckbox);
    }

}