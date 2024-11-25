package com.proyectoJava.crudmongoback.CRUD.repository;

import com.proyectoJava.crudmongoback.CRUD.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//anotacion para repository
@Repository
/*interface de acceso publico de tipo ProductRepository que extiende
de MongoRepository de tipo product y un integer por la clabe primaria (id) es un int */
public interface ProductRepository extends MongoRepository <Product,Integer> {

    //public String name = null;

    //En una interface los metodos no se implemetan solo se declaran
    //crear metodo para ver si existe el nombre del producto para no guardar de manera duplicada
        boolean existsByName(String name);

    //otro metodo que seria un optional para ver si ya existe el producto por su nombre
    Optional<Product> findByName(String name);

}

/*

LA PALABRA EXIST YA ESTA RESERVADA Y ESTA CAUSA ALGUN CONFLICTO ASI QUE SE UTILIZA "EXISTS"

""""" boolean existsByName(String name);   """"

 */
