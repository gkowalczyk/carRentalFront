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
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.stereotype.Component;

import java.util.Collections;


@PageTitle("carlist")
@Route(value = "car")
@UIScope
@Component

public class CarView extends VerticalLayout {

    Grid<Car> carGrid = new Grid<>(Car.class);
    TextField carListFilter = new TextField();
    AddCarForm addCarForm;


    public CarView() {

        addClassName("car-view");
        setSizeFull();

        configuredGrid();
        configuredForm();// for AddCarForm.class

        add(getToolbar(),
                getContent());
    }

    private HorizontalLayout getContent() {
        HorizontalLayout content = new HorizontalLayout(carGrid, addCarForm);
        content.setFlexGrow(2, carGrid);
        content.setFlexGrow(1,addCarForm);
        content.addClassName("content");
        content.setSizeFull();
        return content;
    }

    private void configuredForm() {

        addCarForm = new AddCarForm(Collections.emptyList(), Collections.emptyList());
        addCarForm.setWidth("25em");


    }

    private HorizontalLayout getToolbar() {

        carListFilter.setPlaceholder("Filter by name...");
        carListFilter.setClearButtonVisible(true);
        carListFilter.setValueChangeMode(ValueChangeMode.LAZY);

        Button addCarButton = new Button("Add car");

        HorizontalLayout toolbar = new HorizontalLayout(carListFilter, addCarButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void configuredGrid() {
        carGrid.addClassName("car-grid");
        carGrid.setColumns();
        carGrid.addColumn(Car::getId).setHeader("Id");
        carGrid.addColumn(Car::getCategory).setHeader("Category");
        carGrid.addColumn(Car::getCompany).setHeader("Company");
        carGrid.addColumn(Car::getModel).setHeader("Model");
        carGrid.addColumn(Car::getRegistration).setHeader("Registration");
        carGrid.addColumn(Car::getGearBox).setHeader("Gear Box");
        carGrid.addColumn(Car::getDailyCost).setHeader("Daily Cost");
        carGrid.addColumn(Car::getEquipmentList).setHeader("Equipment");
        carGrid.addColumn(Car::getFuelConsumption).setHeader("Fuel Consumption");
        carGrid.addColumn(Car::isAvailable).setHeader("Availability");
        carGrid.setSizeFull();
        carGrid.getColumns().forEach(col -> col.setAutoWidth(true));
            }
}



