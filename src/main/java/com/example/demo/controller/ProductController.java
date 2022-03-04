package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public String dashboard(Model model){
        model.addAttribute("products", productService.getAllProduct());
        return "product";
    }

    @GetMapping(path="/cekApiProduct")
    public List<Product> getAllProduct(){
        return  productService.getAllProduct();
    }
    // API : http://localhost:8888/api/v1/cekApiProduct -> method GET

    @GetMapping(path="/cekApiProductDetail")
    public ResponseEntity<Object> getSingleProduct(@RequestParam Long number){
        return  productService.getDetailProduct(number);
    }
    // API : http://localhost:8888/api/v1/cekApiProductDetail?number=1 -> method GET

    @PostMapping(path="/createCekApiProduct")
    public ResponseEntity<Object> createNewProduct(@RequestBody Product product){
        return productService.createNewProduct(product);
    }
    // API : http://localhost:8888/api/v1/createCekApiProduct
    // cek pake postman/lainnya, format json -> method POST
    //    {
    //        "productName": "cek",
    //            "productQty": 1
    //    }

    @PutMapping(path="/updateCekApiProduct")
    public ResponseEntity<Object> updateProduct(@RequestParam Long number,@RequestBody Product product){
        return productService.updateProduct(number, product);
    }
    // API : http://localhost:8888/api/v1/updateCekApiProduct?number=1
    // cek pake postman/lainnya, format json -> method PUT
    //    {
    //        "productName": "cek",
    //        "productQty": 1
    //    }

    @DeleteMapping(path="/deleteCekApiProduct")
    public ResponseEntity<Object> deleteProduct(@RequestParam Long number){
        return  productService.deleteProduct(number);
    }
    // API : http://localhost:8888/api/v1/deleteCekApiProduct?number=1 -> method DELETE
}
