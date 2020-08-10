package com.example.demo.repository;


import com.example.demo.DemoApplicationTests;
import com.example.demo.model.entity.Category;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class CategoryRepositoryTest extends DemoApplicationTests {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void create(){
        String type = "COMPUTER";
        String title = "컴퓨터";
//        LocalDateTime createdAt = LocalDateTime.now();
//        String createdBy = "AdminServer";

        Category category = new Category();
        category.setTitle(title);
        category.setType(type);
//        category.setCreatedAt(createdAt);
//        category.setCreatedBy(createdBy);

        Category newCategory = categoryRepository.save(category);
        Assert.assertNotNull(newCategory);
        Assert.assertEquals(newCategory.getType(), type);
        Assert.assertEquals(newCategory.getTitle(), title);
    }

    @Test
    public void read(){
//        Optional<Category> optionalCategory = categoryRepository.findById(1L);

        String type = "COMPUTER";
        // select * from category where type = 'COMPUTER'
        Optional<Category> optionalCategory = categoryRepository.findByType(type);

        optionalCategory.ifPresent(c -> {
            Assert.assertEquals(c.getType(), type);
            System.out.println(c.getId());
            System.out.println(c.getTitle());
            System.out.println(c.getType());
        });
    }
}
