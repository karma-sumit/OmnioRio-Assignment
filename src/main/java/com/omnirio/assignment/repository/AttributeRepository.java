package com.omnirio.assignment.repository;

import com.omnirio.assignment.entity.Attribute;
import com.omnirio.assignment.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AttributeRepository extends JpaRepository<Attribute, UUID> {


    List<Attribute> findAllByCategory(Category category);
}
