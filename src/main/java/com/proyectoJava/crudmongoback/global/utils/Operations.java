package com.proyectoJava.crudmongoback.global.utils;

public class Operations {

    //metodo estattico
    //se crea el metodo a utilizar en globalExceptions operations.trimbrackets
    //para remplasar en el mensaje  de name y price required los corchetes por vacio
    public static String trimBrackets(String message){
        return message.replaceAll("[\\[\\]]","");
    }
}
