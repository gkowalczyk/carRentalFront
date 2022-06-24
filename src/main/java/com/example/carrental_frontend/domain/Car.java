package com.example.carrental_frontend.domain;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@NamedNativeQuery(
        name = "Car.findByDate",
        query = "SELECT *  FROM CARS C WHERE " +
                "ID NOT IN " +
                "(SELECT R.CAR_ID FROM RENTS R WHERE " +
                "(:START_RENT BETWEEN R.DATE_START_RENT AND R.DATE_END_RENT) OR" +
                "(:END_RENT BETWEEN R.DATE_START_RENT AND R.DATE_END_RENT) OR " +
                "(:START_RENT >= R.DATE_START_RENT AND :END_RENT <= DATE_END_RENT  )" +
                "AND C.CATEGORY = :CAR_CLASS)",
        resultClass = Car.class
)


@Entity()

public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    private String registration;


    private String model;


    private String company;


    private String category;


    private String gearBox;


    private BigDecimal dailyCost;


    private boolean isAvailable;


    private BigDecimal fuelConsumption;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "JOIN_CAR_EQUIPMENT",
            joinColumns = {@JoinColumn(name = "CAR_ID")},
            inverseJoinColumns = {@JoinColumn(name = "EQUIPMENT_ID")}
    )
    private List<Equipment> equipmentList;

    @OneToMany(
            targetEntity = Rent.class,
            mappedBy = "car",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY)

    private List<Rent> rentList;

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGearBox() {
        return gearBox;
    }

    public void setGearBox(String gearBox) {
        this.gearBox = gearBox;
    }

    public BigDecimal getDailyCost() {
        return dailyCost;
    }

    public void setDailyCost(BigDecimal dailyCost) {
        this.dailyCost = dailyCost;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public BigDecimal getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(BigDecimal fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public List<Equipment> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(List<Equipment> equipmentList) {
        this.equipmentList = equipmentList;
    }

    public List<Rent> getRentList() {
        return rentList;
    }

    public void setRentList(List<Rent> rentList) {
        this.rentList = rentList;
    }

    public Long getId() {
        return id;


    }


    }


