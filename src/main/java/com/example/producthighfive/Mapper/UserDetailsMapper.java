package com.example.producthighfive.Mapper;


import com.example.producthighfive.DTO.UserDetailsDTO;
import com.example.producthighfive.Model.UserDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel ="spring")

public interface UserDetailsMapper {
        UserDetails DTOtoModel(UserDetailsDTO userDetailsDTO);
}
