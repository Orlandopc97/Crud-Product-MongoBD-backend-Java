package com.proyectoJava.crudmongoback.CRUD.service;

import com.proyectoJava.crudmongoback.CRUD.dto.ProductDto;
import com.proyectoJava.crudmongoback.CRUD.entity.Product;
import com.proyectoJava.crudmongoback.CRUD.repository.ProductRepository;
import com.proyectoJava.crudmongoback.global.exceptions.AttributeException;
import com.proyectoJava.crudmongoback.global.exceptions.ResourseNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.Comparator;
import java.util.List;

@Service
public class ProductService {

    //Injectamos product repository (interface)
    @Autowired
    ProductRepository productRepository;

    //metodo obtener todos los productos en una lista
    public List<Product> getAllProducts () {
        return productRepository.findAll();

    }

    //metodo obtener un producto
    public Product getOneProduct (int id) throws ResourseNotFoundException {
        return productRepository.findById(id).orElseThrow(()-> new ResourseNotFoundException("PRODUCT NOT FOUND"));

    }

    //metodo guardar un producto
    public Product saveProduct (ProductDto productDto) throws AttributeException {

        if (productRepository.existsByName(productDto.getName())) throw new AttributeException("NAME ALREADY IN USE");

        int id = autoIncrementId();
        Product product = new Product(id,productDto.getName(),productDto.getPrice());
        return productRepository.save(product);

        /*
        int id = 1;
        Product product = new Product(id,dto.getName(),dto.getPrice());
        return productRepository.save(product);
        */

    }

    //metodo de actualizar un producto
    public Product updateProduct (int id, ProductDto productDto) throws ResourseNotFoundException, AttributeException {
        Product product = productRepository.findById(id).orElseThrow(()-> new ResourseNotFoundException("PRODUCT NOT FOUND"));

        if(productRepository.existsByName(productDto.getName()) && productRepository.findByName(productDto.getName()).get().getId()!=id)
            throw new AttributeException("NAME ALREADY IN USE");

        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        return productRepository.save(product);

    }

    //metodo de borrar producto
    public Product deleteProduct(int id) throws ResourseNotFoundException{
        Product product = productRepository.findById(id).orElseThrow(()-> new ResourseNotFoundException("PRODUCT NOT FOUND"));
        productRepository.delete(product);
        return product;
    }



    // metodo privado id autoincrementable para save product
    private int autoIncrementId (){

        List<Product> products = productRepository.findAll();
                                            //si esta vacio? / regresa 1
        return productRepository.findAll().isEmpty()? 1:
                //caso contrario vas a traer de product el id (max())lo obtienes (get()) y le aumentas 1
        products.stream().max(Comparator.comparing(Product::getId)).get().getId() + 1;
    }

}
