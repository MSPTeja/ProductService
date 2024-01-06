package com.productservice.productservice.Controller;

import com.productservice.productservice.Exceptions.ProductNotFoundException;
import com.productservice.productservice.thirdPartyClients.FakeStoreClient.FakeStoreClient;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductControllerTest {

  @Inject
    private FakeStoreClient fakeStoreClient;
//    ProductControllerTest(FakeStoreClient fakeStoreClient) {
//        this.fakeStoreClient = fakeStoreClient;
//    }
    @Test
    @DisplayName("Testing 1+1 is 2 or not")
    void testOnePlusOneIsTwoOrNot() {
//        assert (2 == 1+1);
        // checks expected value vs the outpt of the expression. if assert is true test case successed else fail
//        assertEquals(11,1+1,"1+1 is 2 not 11");
//        assertTrue(false);
//        assertTrue(2==2);
//        assertFalse(1==1);
//        assertNull();
    }
        @Test
         void testProductGetByIdNeagativetest() throws ProductNotFoundException
        {
//             productController.getProductById(10000L);
            assertThrows(ProductNotFoundException.class,() -> fakeStoreClient.getProductById(1000L));
              // expectedclass,actual class we get. assertnull(productController.getProductById(1000));
        }
    }


