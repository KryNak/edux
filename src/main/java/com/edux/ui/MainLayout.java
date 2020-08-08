package com.edux.ui;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.RouterLayout;

public class MainLayout extends AppLayout implements RouterLayout {

    public MainLayout(){

        Anchor logout = new Anchor("/logout", "Log out");
        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logout);
        header.setWidth("100%");
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);

        addToNavbar(header);
    }
}
