package com.productservice.productservice.Controller;

import com.productservice.productservice.Dtos.GenericProductDto;
import com.productservice.productservice.Exceptions.ProductNotFoundException;
import com.productservice.productservice.Services.ProductService;
import com.productservice.productservice.thirdPartyClients.FakeStoreClient.FakeStoreClient;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductControllerTest {

  @Inject
    private FakeStoreClient fakeStoreClient;

  @Inject
  private ProductController productController;

  @MockBean // if autowired it will intialise actual object.
  private ProductService productService;

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
        @Test
        void testProductByIdMocking() throws ProductNotFoundException
        {
            GenericProductDto genericProductDto =new GenericProductDto();
           when(productService.getProductById(1000L)).thenReturn(genericProductDto);

//           assertNull(productController.getProductById(100L));
//            assertEquals(genericProductDto,productController.getProductById(1000L));
            assertThrows(ProductNotFoundException.class,() ->productController.getProductById(1L));
        }
    }


