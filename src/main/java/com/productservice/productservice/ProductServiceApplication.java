package com.productservice.productservice;
import com.productservice.productservice.models.Category;
import com.productservice.productservice.models.Orders;
import com.productservice.productservice.models.Price;
import com.productservice.productservice.models.Product;
import com.productservice.productservice.Repository.OrdersRepository;
import com.productservice.productservice.Repository.PriceRepository;
import com.productservice.productservice.Repository.CategoryRepository;
import com.productservice.productservice.Repository.ProductRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.objenesis.SpringObjenesis;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.stream.events.ProcessingInstruction;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner  {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final PriceRepository priceRepository;
    public ProductServiceApplication(CategoryRepository categoryRepository,
                                     ProductRepository productRepository,
                                     PriceRepository priceRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.priceRepository = priceRepository;
    }
    //    private MentorRepository mentorRepository;
//    private UserRepository userRepository;
//    private StudentRepository studentRepository;
//
//    ProductServiceApplication(@Qualifier("st_mentorrepo") MentorRepository mentorRepository,
//                              @Qualifier("st_userrepo") UserRepository userRepository,
//                              @Qualifier("st_studentrepo") StudentRepository studentRepository) {
//        this.mentorRepository = mentorRepository;
//        this.userRepository = userRepository;
//        this.studentRepository = studentRepository;
//    }
//    private final MentorRepository mentorRepository;
//    private final StudentRepository studentRepository;
//
//    private final UserRepository userRepository;
//
//    ProductServiceApplication(@Qualifier("tpc_mentorrepository") MentorRepository mentorRepository,
//                              StudentRepository studentRepository,
//                              UserRepository userRepository) {
//        this.mentorRepository = mentorRepository;
//        this.studentRepository = studentRepository;
//        this.userRepository = userRepository;
//    }
    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }
    @Override
    //@Transactional
    public void run(String... args) throws Exception {
//        Mentor mentor = new Mentor();
//        mentor.setName("Deepak");
//        mentor.setEmail("deepak.kasera@scaler.com");
//        mentor.setAvgRating(4.8);
//
//        mentorRepository.save(mentor);
        //tpc_mentor
//        Mentor mentor = new Mentor();
//        mentor.setName("Deepak");
//        mentor.setEmail("deepak.kasera@scaler.com");

//
//
//        Product product2 = new Product();
//        product2.setPrice(price1);
//        product2.setTitle("iPhone 15 pro max");
//        product2.setDescription("Best iPhone ever.");
//        product2.setImage("IMG");
//        product2.setCategory(category);
//        Product savedProduct1 = productRepository.save(product2);
//
//        Price price2 = new Price();
//        price2.setValue(100000);
//        price2.setCurrency("INR");
//
//
//        Product product3 = new Product();
//        product3.setPrice(price2);
//        product3.setTitle("iPhone 15 pro max");
//        product3.setDescription("Best iPhone ever.");
//        product3.setImage("IMG");
//        product3.setCategory(category);
//        Product savedProduct2 = productRepository.save(product3);

//        Optional<Category> optionalCategory = categoryRepository.findById(UUID.fromString("be0bd1ad-abe4-477e-a66e-faff0f2fa03f"));
//
//        Category category = optionalCategory.get();

//        List<Product> products = category.getProducts();
//
//        for (Product product : products) {
//            System.out.println(product.getTitle());
//        }

                //select * from products
                //List<Product> products = productRepository.findAllByTitleAndDescription("iPhone 15 pro max", "Best iPhone ever.");

                //List<Product> products = productRepository.findAllByPrice_ValueLessThan(50000);

//        Category category = new Category();
//        category.setName("Samsung");
//        Category category1 = categoryRepository.save(category);
//
//        Price price = new Price();
//        price.setValue(49000);
//        price.setCurrency("INR");
//
//        Product product = new Product("Samsung Fold 5", "Samsung's Foldable phone", "XYZ",
//                category1, price);
//
//        productRepository.save(product);

                List<Product> products1 = productRepository.findAllByPrice_ValueBetween(29000, 50000);
    }
}