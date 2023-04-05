package com.example.producthighfive.Model;


import lombok.*;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "Name")
    String name;
    @Column(name = "Description")
    String description;

    @Column(name = "Rating")
    String rating;
    @Column(name = "Price")
    String price;


}
