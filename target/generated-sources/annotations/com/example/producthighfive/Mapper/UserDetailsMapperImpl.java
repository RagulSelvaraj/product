package com.example.producthighfive.Mapper;

import com.example.producthighfive.DTO.UserDetailsDTO;
import com.example.producthighfive.Model.UserDetails;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-03T16:19:46+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.16 (Amazon.com Inc.)"
)
@Component
public class UserDetailsMapperImpl implements UserDetailsMapper {

    @Override
    public UserDetails DTOtoModel(UserDetailsDTO userDetailsDTO) {
        if ( userDetailsDTO == null ) {
            return null;
        }

        UserDetails userDetails = new UserDetails();

        userDetails.setId( userDetailsDTO.getId() );
        userDetails.setName( userDetailsDTO.getName() );
        userDetails.setDescription( userDetailsDTO.getDescription() );
        userDetails.setRating( userDetailsDTO.getRating() );
        userDetails.setPrice( userDetailsDTO.getPrice() );

        return userDetails;
    }
}
