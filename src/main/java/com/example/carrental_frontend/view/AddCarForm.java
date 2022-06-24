package com.example.carrental_frontend.view;

import com.example.carrental_frontend.domain.Equipment;
import com.example.carrental_frontend.domain.Rent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.util.List;

@PageTitle("addcarform")
@Route(value = "carform")
public class AddCarForm extends FormLayout {

    TextField id = new TextField("Id");
    TextField category = new TextField("Category");
    TextField company = new TextField("Company");
    TextField model = new TextField("Model");
    TextField registration = new TextField("Registration");
    TextField gearbox = new TextField("Gear Box");
    TextField dailyCost = new TextField("Daily Cost");
    TextField isAvailable = new TextField("Availability");
    TextField fuelConsumption = new TextField("Fuel consumption");
    ComboBox<Equipment> equipmentComboBox = new ComboBox<>("Equipment");
    ComboBox<Rent> rentComboBox = new ComboBox<>("Rent");

    Button save = new Button("Save");
    Button delete = new Button("Delete");
    Button close = new Button("Update");

            public AddCarForm(List<Equipment>equipmentList, List<Rent> rentList) {
        addClassName("addCar-form");

        equipmentComboBox.setItems(equipmentList);
        equipmentComboBox.setItemLabelGenerator(Equipment::getDescription);

        rentComboBox.setItems(rentList);
        rentComboBox.setItemLabelGenerator(Rent::toString);

        add(    id,
                category,
                model,
                registration,
                gearbox,
                dailyCost,
                isAvailable,
                fuelConsumption,
                rentComboBox,
                equipmentComboBox,
                createButtonLayout()
        );

            }

    private Component createButtonLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        save.addClickShortcut(Key.ENTER);
        close.addClickShortcut(Key.ESCAPE);
        return new HorizontalLayout(save, delete, close);
    }

}



