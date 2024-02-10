package com.blog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.Model.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
