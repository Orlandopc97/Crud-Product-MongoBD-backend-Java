package com.proyectoJava.crudmongoback.CRUD.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//es una bd no relacional
//@Entity relacional y @document no relacional, que recibe como parametro una coleccion y es un json
@Document(collection = "Products")
public class Product {

    //propiedades de la entidad
    //declaracion de las variables tipo de dato y acceso

    @Id
    private int id;
    private String name;
    private int price;

    //generamos los constructores uno vacio
    public Product() {
    }
    //un constructor con todas las propiedades
    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    //generamos los metodos getters y setters para las propiedades de la entidad
    //metodo getter
    public int getId() {
        return id;
    }

    //metodo setter
    public void setId(int id) {
        this.id = id;
    }

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