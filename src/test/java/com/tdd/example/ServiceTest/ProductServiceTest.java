package com.tdd.example.ServiceTest;

import com.tdd.example.product.ProductEntity;
import com.tdd.example.product.ProductRepository;
import com.tdd.example.product.ProductService;
import com.tdd.example.product.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.swing.text.html.Option;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProductServiceTest {

    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private ProductService underTest;

    @Test
    @DisplayName("ProductService Test  Create Product successful")
    void createProductsSuccessful(){
        // Given
        ProductEntity mockProductEntity = new ProductEntity("1","new product",100.3,1);
        doReturn(mockProductEntity).when(productRepository).save(mockProductEntity);
        //when
        ProductEntity returnedProduct = underTest.createProduct(mockProductEntity);
        //then
        Assertions.assertNotNull(returnedProduct, "The saved product should not be null");
        Assertions.assertEquals("new product", returnedProduct.getName());
        Assertions.assertEquals(100.3,mockProductEntity.getPrice());
    }

    @Test
    @DisplayName(("ProductService Test Delete Product successful"))
    void deleteProductSuccessful(){
        //Given
        ProductEntity mockProductEntity = new ProductEntity("1","new product",100.3,1);
        doReturn(Optional.of(mockProductEntity)).when(productRepository).findById("1");
        //when
       boolean deleted =  underTest.deleteProduct("1");
        //then
        Assertions.assertFalse(deleted ,"Product was found");

    }

    @Test
    @DisplayName("ProductService Test Find ById successful")
    void findProductById(){
        //Given
         ProductEntity mockProductEntity = new ProductEntity("1","new product",100.3,1);
         doReturn(Optional.of(mockProductEntity)).when(productRepository).findById("1");
        //when
        Optional<ProductEntity> returnedProduct = underTest.findByID("1");
        //then
        Assertions.assertTrue(returnedProduct.isPresent(),"Product was not found");
    }

    @Test
    @DisplayName("ProductService Test Find All successful")
    void findAll(){
        //Given
        ProductEntity product1 = new ProductEntity("1","product 1",100.0,1);
        ProductEntity product2 = new ProductEntity("2","product 2",190.0,1);
        doReturn(Arrays.asList(product1,product2)).when(productRepository).findAll();
        //when
        List<ProductEntity> list = underTest.findAll();
        //then
        Assertions.assertEquals(2,list.size(),"find all should return two products");
    }

    @Test
    @DisplayName("ProductService Test update products successful")
    void updateProduct(){
        //Given
        ProductEntity oldProduct =  new ProductEntity("1","product 1",100.0,1);
        ProductEntity newProduct = new ProductEntity("1","product 1",90.0,2);
        //When
        boolean result = underTest.updateProduct(newProduct);
        //Then
        Assertions.assertTrue(result,"Product was not updated");
        Assertions.assertNotEquals(oldProduct,newProduct);
    }


}
