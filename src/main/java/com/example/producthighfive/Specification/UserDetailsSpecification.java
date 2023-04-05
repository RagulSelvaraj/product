package com.example.producthighfive.Specification;

import com.example.producthighfive.Model.UserDetails;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class UserDetailsSpecification {
    public static Specification<UserDetails> findByDetails(String name, String description, String price) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (name != null && !name.isBlank()) {
                predicates.add(builder.like(builder.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
            }
            if (description != null && !description.isBlank()) {
                predicates.add(builder.like(builder.lower(root.get("description")), "%" + description.toLowerCase() + "%"));
            }
            if (price != null && !price.isBlank()) {
                predicates.add(builder.equal(root.get("price"), price));
            }
            return builder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}
