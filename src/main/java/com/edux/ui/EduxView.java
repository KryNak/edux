package com.edux.ui;

import com.edux.model.Answer;
import com.edux.model.Question;
import com.edux.service.AnswerService;
import com.edux.service.QuestionService;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Route(value = "edux", layout = MainLayout.class)
public class EduxView extends VerticalLayout implements BeforeEnterObserver {

    private static String subject;
    private int score;

    public EduxView(@Autowired QuestionService questionService, @Autowired AnswerService answerService){

        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        setSizeUndefined();

        List<MyComponent> componentsList = new ArrayList<>();

        List<Question> questionList = questionService.findQuestionsBySubjectName(subject);

        questionList.forEach(e -> {
            componentsList.add(new MyComponent(
                    e,
                    answerService.findAnswersByQuestion(e),
                    answerService.findCorrectAnswerByQuestion(e)
            ));
        });

        VerticalLayout layout = new VerticalLayout();
        componentsList.forEach(layout::add);
        add(layout);

        Button backButton = new Button("back");
        backButton.addClickListener(e ->{
            UI.getCurrent().navigate("");
            backButton.setVisible(false);
        });

        Button submitButton = new Button("submit");
        submitButton.addClickListener(e->{
            componentsList.forEach(component -> {
                if(component.getCorrectAnswer().equals(component.getCheckedAnswer())) score++;
                component.setVisible(false);
                submitButton.setVisible(false);
                setSizeFull();
            });

            H1 scoreTitle = new H1("Your score is: ");
            add(scoreTitle);

            H1 score = new H1(this.score + "");
            add(score);

            add(backButton);
        });
        if(componentsList.size() > 0) add(submitButton);
        if(componentsList.size() == 0) add(backButton);

    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        if (subject == null) {
            beforeEnterEvent.rerouteTo("");
        }

    }

    public static void setSubject(String subject) {
        EduxView.subject = subject;
    }
}

class MyComponent extends VerticalLayout{

    private RadioButtonGroup<String> answersRadioGroup;
    private Answer correctAnswer;

    public MyComponent(){

    }

    MyComponent(Question question, List<Answer> answers, Answer correctAnswer){
        this.correctAnswer = correctAnswer;

        setJustifyContentMode(JustifyContentMode.START);
        setAlignItems(Alignment.START);

        Text text = new Text(question.getQuestion_content());
        answersRadioGroup = new RadioButtonGroup<>();
        answersRadioGroup.setItems(answers.stream().map(Answer::getAnswer_contend).collect(Collectors.toList()));
        answersRadioGroup.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);

        add(text, answersRadioGroup);
    }

    public String getCorrectAnswer() {
        return correctAnswer.getAnswer_contend();
    }

    public String getCheckedAnswer() {
        return answersRadioGroup.getValue();
    }
}
