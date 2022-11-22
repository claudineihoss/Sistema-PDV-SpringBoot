package com.pdv.controller;

import com.pdv.entity.Product;
import com.pdv.entity.User;
import com.pdv.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(@Autowired ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    @GetMapping()
    public ResponseEntity getAll(){

        return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity post(@RequestBody Product product ){
        try {
            return new ResponseEntity<>(productRepository.save(product),HttpStatus.CREATED);
        }
        catch (Exception error){
            return new ResponseEntity<>(error.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping()
    public ResponseEntity put(@RequestBody  Product product) {

            productRepository.save(product);
            return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        try{
            productRepository.deleteById(id);
            return new ResponseEntity<>("Produto removido com Sucesso", HttpStatus.OK);
        }
        catch (Exception error){
            return new ResponseEntity<>(error.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
