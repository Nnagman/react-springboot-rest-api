package com.example.gccoffee.repository;

import com.example.gccoffee.model.Category;
import com.example.gccoffee.model.Product;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@ActiveProfiles(value = "test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProductJdbcRepositoryTest {
    @Autowired
    ProductRepository productRepository;

    // TestInstance의 Lifecycle이 기본값(PER_METHOD 일때) static으로 안하면 테스트 할 때 마다 새롭게 생성함. 즉, UUID가 달라짐.
    private final Product newProduct = new Product(
            UUID.randomUUID(),
            "new-product",
            Category.COFFEE_BEAN_PACKAGE,
            1000L);

    @Test
    @Order(1)
    @DisplayName("상품을 추가 할 수 있다.")
    void testInsert() {
        productRepository.insert(newProduct);
        var all = productRepository.findAll();
        assertThat(all.isEmpty(), is(false));
    }

    @Test
    @Order(2)
    @DisplayName("상품을 이롬으로 조회 할 수 있다.")
    void testFindByName() {
        var product = productRepository.findByName(newProduct.getProductName());
        assertThat(product.isEmpty(), is(false));
    }

    @Test
    @Order(3)
    @DisplayName("상품을 아이디로 조회 할 수 있다.")
    void testFindById() {
        var product = productRepository.findById(newProduct.getProductId());
        assertThat(product.isEmpty(), is(false));
    }

    @Test
    @Order(4)
    @DisplayName("상품을 카테고리로 조회 할 수 있다.")
    void testFindByCategory() {
        var product = productRepository.findByCategory(Category.COFFEE_BEAN_PACKAGE);
        assertThat(product.isEmpty(), is(false));
    }

    @Test
    @Order(5)
    @DisplayName("상품을 수정할 수 있다.")
    void testUpdate() {
        newProduct.setProductName("updated-product");
        productRepository.update(newProduct);

        var product = productRepository.findById(newProduct.getProductId());
        assertThat(product.isEmpty(), is(false));
//        assertThat(product.get(), samePropertyValuesAs(newProduct));
    }

    @Test
    @Order(6)
    @DisplayName("상품을 전체 삭제한다.")
    void testDeleteAll() {
        productRepository.deleteAll();
        var all = productRepository.findAll();
        assertThat(all.isEmpty(), is(true));
    }
}