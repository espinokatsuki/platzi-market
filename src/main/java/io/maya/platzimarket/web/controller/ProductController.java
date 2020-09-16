package io.maya.platzimarket.web.controller;

import io.maya.platzimarket.domain.ProductDomain;
import io.maya.platzimarket.domain.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    @ApiOperation("Get all super market products")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<ProductDomain>> getAll() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "NOT FOUND")
    })
    public ResponseEntity<List<ProductDomain>> getByCategory(@ApiParam(value = "The id of the products",
            required = true, example = "7") @PathVariable("id") Integer id) {
        return productService.getByCategory(id)
                .map(productDomains -> new ResponseEntity<>(productDomains, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/scarce-by/{quantity}")
    public Optional<List<ProductDomain>> getScarceProducts(@PathVariable("quantity") Integer minStock) {
        return productService.getScarceProducts(minStock);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDomain> getProduct(@PathVariable("id") Integer id) {
        return productService.getProduct(id)
                .map(productDomain -> new ResponseEntity<>(productDomain, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ProductDomain> save(@RequestBody ProductDomain productDomain) {
        return new ResponseEntity<>(productService.save(productDomain), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        if (productService.delete(id)) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }


}
