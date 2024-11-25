package com.proyectoJava.crudmongoback.global.dto;

import org.springframework.http.HttpStatus;

//para devolver siempre un mensaje ya sea un producto o una lista
public class MessageDto {

    //clase con dos atributos o propiedades
    private HttpStatus status;
    private String message;

    //constructor vacio
    public MessageDto() {
    }

    //constructor con todos los atributos
    public MessageDto(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    //constructores getters y setters
    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //añadir como un controlador para exceptiones
    //cuando se ejecute un metodo en el restcontroller
    //cada exception llamara a la clase de Global exception
}
