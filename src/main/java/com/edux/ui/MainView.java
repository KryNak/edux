package com.edux.ui;

import com.edux.model.Student;
import com.edux.service.StudentService;
import com.edux.service.SubjectService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;


@Route(value = "", layout = MainLayout.class)
public class MainView extends VerticalLayout {

    public MainView(@Autowired SubjectService subjectService, @Autowired StudentService studentService) {
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        if(user instanceof UserDetails){
            username = ((UserDetails)user).getUsername();
        }

        Student student = studentService.findStudentByLogin(username);
        List<String> subjects = subjectService.findSubjectsByStudent(student);
                //new ArrayList<>(Arrays.asList("1", "2", "3"));

        add(new H1("Select your course: "));
        ListBox<String> listBox = new ListBox<>();
        listBox.setItems(subjects);
        add(listBox);
        Button selectButton = new Button("Select");
        selectButton.addClickListener(e -> {
            EduxView.setSubject(listBox.getValue());
            UI.getCurrent().navigate("edux");
        });
        add(selectButton);

        setHeightFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
    }

}
