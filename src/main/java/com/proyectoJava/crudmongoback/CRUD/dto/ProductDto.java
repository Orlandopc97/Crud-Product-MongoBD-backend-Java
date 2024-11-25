package com.proyectoJava.crudmongoback.CRUD.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

//Clase para crear productos
//tendra todos los campos de la entidad excepto el id
public class ProductDto {

    //El nombre no puede ser nulo, se usa @NotBlank
    @NotBlank(message = "PRODUCT NAME IS REQUIRED")
    private String name;

    @Min(value = 1, message = "PRODUCT PRICE IS REQUIRED")
    private int price;

    //constructor vacio
    public ProductDto() {
    }

    //constructor con todas las propiedades
    public ProductDto(String name, int price) {
        this.name = name;
        this.price = price;
    }

    //generamos los metodos getters and setters de las propiedades

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
