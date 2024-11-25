package com.proyectoJava.crudmongoback.global.exceptions;

import com.proyectoJava.crudmongoback.global.dto.MessageDto;
import com.proyectoJava.crudmongoback.global.utils.Operations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalException {

    //metodo
    @ExceptionHandler(ResourseNotFoundException.class)
    public ResponseEntity<MessageDto> throwNotFoundException(ResourseNotFoundException resourseNotFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new MessageDto(HttpStatus.NOT_FOUND,resourseNotFoundException.getMessage()));
    }


    //llamada al constructor de AttributeException
    @ExceptionHandler(AttributeException.class) //cabezera del metodo
    //metodo
    public ResponseEntity<MessageDto> throwAttributeException(AttributeException attributeException){
        return ResponseEntity.badRequest()
                .body(new MessageDto(HttpStatus.BAD_REQUEST, attributeException.getMessage()));

    }

    @ExceptionHandler(Exception.class)
    //metodo
    public ResponseEntity<MessageDto> generalException (Exception exception){
        return ResponseEntity.internalServerError()
                .body(new MessageDto(HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage()));

    }

    //exception para controlar las exceptiones que aparecen, que solo aparesca en un solo mensaje
    @ExceptionHandler(MethodArgumentNotValidException.class)
    //metodo
    public ResponseEntity<MessageDto> validationException(MethodArgumentNotValidException methodArgumentNotValidException){
        List<String> messages = new ArrayList<>(); // Se obtiene una lista de errores y se tiene que recorrer
        methodArgumentNotValidException.getBindingResult().getAllErrors().forEach((err) ->{ //obtener los resultados vinculantes, obtener todos los errores y los recorre con el foreach (que obtiene un error)
            messages.add(err.getDefaultMessage());                                //obtiene el error entre parentesis del foreach
        });                                                                            //se llama a operations y al metodo
        return ResponseEntity.badRequest().body(new MessageDto(HttpStatus.BAD_REQUEST, Operations.trimBrackets(messages.toString())));
        //devolvemos la respuesta de la entidad. que es un mala peticion que en el cuerpo traera en un nuevo mensaje del http ststus de la mala peticion y el mensaje (objeto) en un string
        //falta quitar los corchetes, se crea en global.utils
    }


}
