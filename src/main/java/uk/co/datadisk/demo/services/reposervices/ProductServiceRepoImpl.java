package uk.co.datadisk.demo.services.reposervices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import uk.co.datadisk.demo.domain.Product;
import uk.co.datadisk.demo.repositories.ProductRepository;
import uk.co.datadisk.demo.services.ProductService;

import java.util.ArrayList;
import java.util.List;

@Service
@Profile({"springdatajpa", "jpadao"})
public class ProductServiceRepoImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<?> listAll() {
        System.out.println("Using new JPA Repo - listAll");
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add); //fun with Java 8
        return products;
    }

    @Override
    public Product getById(Integer id) {
        return productRepository.findOne(id);
    }

    @Override
    public Product saveOrUpdate(Product domainObject) {
        return productRepository.save(domainObject);
    }

    @Override
    public void delete(Integer id) {
        productRepository.delete(id);
    }

}
