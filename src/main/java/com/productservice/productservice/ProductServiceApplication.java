package com.productservice.productservice;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import com.productservice.productservice.Repository.CategoryRepository;
import com.productservice.productservice.Repository.OrdersRepository;
import com.productservice.productservice.Repository.ProductRepository;
import com.productservice.productservice.models.Category;
import com.productservice.productservice.models.Orders;
import com.productservice.productservice.models.Price;
import com.productservice.productservice.Repository.PriceRepository;
import com.productservice.productservice.models.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner  {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final PriceRepository priceRepository;
    private final OrdersRepository ordersRepository;

    public ProductServiceApplication(CategoryRepository categoryRepository,
                                     ProductRepository productRepository,
                                     PriceRepository priceRepository,
                                     OrdersRepository ordersRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.priceRepository = priceRepository;
        this.ordersRepository = ordersRepository;
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
//        mentor.setAvgRating(4.7);
//        mentorRepository.save(mentor);
//
//
//        Student student = new Student();
//        student.setEmail("abhishek@scaler.com");
//        student.setName("Abhishek");
//        student.setPsp(90.0);
//        studentRepository.save(student);
//
//        User user = new User();
//        user.setEmail("arshi@gmail.com");
//        user.setName("Arshi");
//        userRepository.save(user);
//
//        //Get all the Users.
//        List<User> users = userRepository.findAll();
//
//        for (User user1 : users) {
//            System.out.println(user1.toString());
//        }


//        User user = new User();
//        user.setName("Arshi");
//        user.setEmail("arshi@gmail.com");
//        userRepository.save(user);
//
//        Mentor mentor = new Mentor();
//        mentor.setName("Deepak");
//        mentor.setEmail("deepak.kasera@scaler.com");
//        mentor.setAvg_rating(4.7);
//        mentorRepository.save(mentor);
//
//        Student student = new Student();
//        student.setName("harsh");
//        student.setEmail("harsh@gmail.com");
//        student.setPsp(99.0);
//        studentRepository.save(student);
//        Category category = new Category();
//        category.setName("iphone");
//       Category savedcategory =  categoryRepository.save(category);

//        Optional<Category> optionalcategory = categoryRepository.findById(UUID.fromString("182d97ae-21ed-4db5-b3ea-b0fe9bb09d5d"));
//
//           if(optionalcategory.isEmpty())
//           {
//               throw new Exception("Category was null");
//           }
//        Category category = optionalcategory.get();

//        Product product = new Product();
//        product.setTitle("iphone15");
//        product.setDescription("Best phone ever");
//        product.setCategory(savedcategory);
//         Product savedproduct =  productRepository.save(product);
        // find all product with in category apple.
//         List<Product> productList = category.getProducts();
//         for(Product product:productList)
//         {
//             System.out.println(product.getTitle());
//         }
//             Price price = new Price();
//             price.setCurrency("INR");
//             price.setValue(10000);
//             Price savedprice = priceRepository.save(price);
//
//             Category category = new Category();
//             category.setName("Apple Products");
//             Category savedcategory = categoryRepository.save(category);
//
//             Product product = new Product();
//             product.setTitle("Iphoe 15pro");
//             product.setDescription("best phone ever");
//             product.setCategory(savedcategory);
//             product.setPrice(savedprice);
//          Product savedproduct  =  productRepository.save(product);
    }
}