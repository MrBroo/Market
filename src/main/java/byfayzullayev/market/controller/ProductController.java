package byfayzullayev.market.controller;
import byfayzullayev.market.entity.Product;
import byfayzullayev.market.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {


    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //CREATE
    @PostMapping("/addproduct")
    public String addmarket(@RequestBody Product product) {
        Product addproduct = new Product();
        Product byName = productRepository.findByName(product.getName());
        if (byName != null) {
            return "Bu product allaqachon mavjud";
        }
        addproduct.setName(product.getName());
        productRepository.save(addproduct);
        return "Product qo`shildi";
    }

    //READ
    @GetMapping("/productlist")
    public List<Product> getProductList() {
        List<Product> products = productRepository.findAll();
        return products;

    }

    @PutMapping("/edit/{id}")
    public String editProduct(@PathVariable Integer id, @RequestBody Product product) {
        Optional<Product> byId = productRepository.findById(id);
        if (byId.isPresent()) {
            Product editProduct = byId.get();
            Product byName = productRepository.findByName(product.getName());

            if (byName != null) {
                return "Bu product nomi mavjud";
            }
            editProduct.setName(product.getName());
            productRepository.save(editProduct);
            return "saqlandi";
        }
        return "Qayta urunib ko`ring";
    }

    //DELETE
    @DeleteMapping("/delete")
    public String deleteProduct(@PathVariable Integer id) {
        Optional<Product> byId = productRepository.findById(id);
        if (byId.isPresent()) {
            productRepository.deleteById(id);
            return "O`chirildi";
        }
        return "Qaytadan uruning";
    }

}


