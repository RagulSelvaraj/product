package com.example.producthighfive.Service;

import com.example.producthighfive.Model.UserDetails;
import com.example.producthighfive.Repository.ProductRepository;
import com.example.producthighfive.Repository.UserDetailsRepository;
import com.example.producthighfive.Specification.UserDetailsSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;
  @Autowired
  EntityManager entityManager;
  @Autowired
  private UserDetailsRepository userDetailsRepository;

  public UserDetails saveproduct(UserDetails userDetails) {
    return productRepository.save(userDetails);

  }
  public List<UserDetails> removeDuplicate() {
    List<UserDetails> uniqueProducts = new ArrayList<>();
    List<String> productNames = new ArrayList<>();

    for (UserDetails product : productRepository.findAll()) {
      if (!productNames.contains(product.getName())) {
        uniqueProducts.add(product);
        productNames.add(product.getName());
      }
    }
    return uniqueProducts;
  }

  public List<UserDetails>fetchProduct(){
    return productRepository.findAll();
  }


  public void deleteProductById(Long id) {
    productRepository.deleteById(id);
  }

  public UserDetails updateById(UserDetails userDetails, Long id) {
    UserDetails User = productRepository.getById(id);
    if (Objects.nonNull(userDetails.getDescription()) && !"".equalsIgnoreCase(userDetails.getDescription())) {
      User.setDescription(userDetails.getDescription());
    }


    if (Objects.nonNull(userDetails.getName()) && !"".equalsIgnoreCase(userDetails.getName())) {
      User.setName(userDetails.getName());
    }

    if (Objects.nonNull(userDetails.getRating()) && !"".equalsIgnoreCase(userDetails.getRating())) {
      User.setRating(userDetails.getRating());
    }
    if (Objects.nonNull(userDetails.getPrice()) && !"".equalsIgnoreCase(userDetails.getPrice())) {
      User.setPrice(userDetails.getPrice());
    }

    return productRepository.save(User);
  }

  public List<UserDetails> sortUserDetailsByField(String field) {
    Sort.Direction direction = Sort.Direction.ASC;
    Sort sort = Sort.by(direction, field);
    List<UserDetails> sortedUserDetails = productRepository.findAll(sort);
    return sortedUserDetails;
  }

  public Page<UserDetails> pagination(int offset) {
    Pageable firstPageWithTwoElements = PageRequest.of(offset, 4);
    Page<UserDetails> allProduct = productRepository.findAll(firstPageWithTwoElements);
    List<UserDetails> products = allProduct.getContent();
    return new PageImpl<>(products, allProduct.getPageable(), allProduct.getTotalElements());
  }

//  public List<UserDetails> specification(String column, String value) {
//
//    Specification<UserDetails> spec = new Specification<UserDetails>() {
//      @Override
//      public Predicate toPredicate(Root<UserDetails> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//        return criteriaBuilder.equal(root.get(column), value);
//      }
//    };
//    return productRepository.findAll(spec);
//
//  }

  public List<UserDetails> getUserDetailsByDetails(String name, String description, String price) {
    Specification<UserDetails> specification = UserDetailsSpecification.findByDetails(name, description, price);
    return userDetailsRepository.findAll(specification);
  }

}
