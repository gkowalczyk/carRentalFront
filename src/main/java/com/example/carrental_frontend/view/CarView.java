package com.example.carrental_frontend.view;

import com.example.carrental_frontend.domain.Car;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@PageTitle("carlist")
@Route(value = "car")
@Component

public class CarView extends VerticalLayout {

    Grid<Car> carGrid = new Grid<>(Car.class);
    TextField carListFilter = new TextField();

@Autowired
    public CarView() {

        addClassName("car-view");
        setSizeFull();

        configuredGrid();

        add(getToolbar(),
                carGrid);
    }

    private HorizontalLayout getToolbar() {

        carListFilter.setPlaceholder("Filter by name...");
        carListFilter.setClearButtonVisible(true);
        carListFilter.setValueChangeMode(ValueChangeMode.EAGER);

        Button addCarButton = new Button("Add car");

        HorizontalLayout toolbar = new HorizontalLayout(carListFilter, addCarButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void configuredGrid() {
        carGrid.addClassName("car-grid");
        carGrid.setSizeFull();
        carGrid.setColumns("category");
    }
}
