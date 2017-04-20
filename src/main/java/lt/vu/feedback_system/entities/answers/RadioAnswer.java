package lt.vu.feedback_system.entities.answers;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lt.vu.feedback_system.entities.AnsweredSurvey;
import lt.vu.feedback_system.entities.questions.CheckboxQuestion;
import lt.vu.feedback_system.entities.questions.RadioButton;
import lt.vu.feedback_system.entities.questions.RadioQuestion;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "feedback", name = "radio_answers")
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString(of = {"id", "question"})
public class RadioAnswer implements Answer {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Transient
    private final String type = "text";

    @JoinColumn(name = "question_id", referencedColumnName = "id")
    @ManyToOne
    private RadioQuestion question;

    @JoinColumn(name = "answered_survey_id", referencedColumnName = "id")
    @ManyToOne
    private AnsweredSurvey answeredSurvey;

    @OneToOne
    @JoinColumn(name = "radio_button_id", referencedColumnName = "id")
    private RadioButton radioButton;

}