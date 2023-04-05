package com.example.producthighfive.Repository;


import com.example.producthighfive.Model.UserDetails;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<UserDetails, Long> {

}
