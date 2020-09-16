package io.maya.platzimarket.web.controller;

import io.maya.platzimarket.domain.ProductDomain;
import io.maya.platzimarket.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDomain> getAll() {
        return productService.getAll();
    }

    @GetMapping("/category/{id}")
    public Optional<List<ProductDomain>> getByCategory(@PathVariable("id") Integer id) {
        return productService.getByCategory(id);
    }

    @GetMapping("/scarce-by/{quantity}")
    public Optional<List<ProductDomain>> getScarceProducts(@PathVariable("quantity") Integer minStock) {
        return productService.getScarceProducts(minStock);
    }

    @GetMapping("/{id}")
    public Optional<ProductDomain> getProduct(@PathVariable("id") Integer id) {
        return productService.getProduct(id);
    }

    @PostMapping
    public ProductDomain save(@RequestBody ProductDomain productDomain) {
        return productService.save(productDomain);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Integer id) {
        return productService.delete(id);
    }


}
