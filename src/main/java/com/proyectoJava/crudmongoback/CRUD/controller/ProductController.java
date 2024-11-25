package com.proyectoJava.crudmongoback.CRUD.controller;

import com.proyectoJava.crudmongoback.CRUD.dto.ProductDto;
import com.proyectoJava.crudmongoback.CRUD.entity.Product;
import com.proyectoJava.crudmongoback.CRUD.service.ProductService;
import com.proyectoJava.crudmongoback.global.dto.MessageDto;
import com.proyectoJava.crudmongoback.global.exceptions.AttributeException;
import com.proyectoJava.crudmongoback.global.exceptions.ResourseNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//anotacion para el controlador
@RestController
@RequestMapping("/product")
@CrossOrigin // debe ir encima de product controller por que si no no funciona
public class ProductController {

    //anotacion para inyectar dependencias del service
    @Autowired
    ProductService productService;

    @GetMapping
    //metodo de lista de todos los productos
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    //obtener mapeo de id
    @GetMapping("/{id}")
    //obtener un producto
    public ResponseEntity<Product> getOneProduct (@PathVariable("id") int id) throws ResourseNotFoundException {
        return ResponseEntity.ok(productService.getOneProduct(id));
    }

    //
    @PostMapping
    //metodo de guardar un producto           //valid para vaidar el campo
    public ResponseEntity<MessageDto> saveProduct(@Valid @RequestBody ProductDto productDto) throws AttributeException {
        Product product = productService.saveProduct(productDto);
        String message = "product " + product.getName() + " have been saved"; // ya no regresa un producto si no el mensaje message
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));

    }
    //
    @PutMapping("/{id}")
    //metodo actualizar un producto                                         //Se crea una nueva exceptcion para validar los campos
    public ResponseEntity<MessageDto> updateProduct(@PathVariable("id") int id, @Valid @RequestBody ProductDto productDto) throws ResourseNotFoundException, AttributeException {
        Product product = productService.updateProduct(id,productDto);
        String message = "product " + product.getName() + " have been updated";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }

    @DeleteMapping("/{id}")
    //metodo borrrar un producto
    public ResponseEntity<MessageDto> deleteProduct(@PathVariable("id") int id) throws ResourseNotFoundException {
        Product product = productService.deleteProduct(id);
        String message = "product " + product.getName() + " have been deleted";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }

}
