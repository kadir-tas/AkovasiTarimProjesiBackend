package com.agriculture.project.model;


import com.agriculture.project.model.dto.ModuleValueDto;
import com.agriculture.project.model.dto.ProductDto;
import com.agriculture.project.model.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

    @Id
    private long productId;

    @NotNull
    private String productName;


    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(
            name = "users_products",
            joinColumns = {@JoinColumn(name = "productId")},
            inverseJoinColumns = {@JoinColumn(name = "userId")})
    private Set<User> users = new HashSet<>();

    public Set<UserDto> getUsersDto(){
        Set<UserDto> userDtos = new HashSet<>();
        for(User u : users){
            userDtos.add(new UserDto(u));
        }
        return userDtos;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(
            name = "modules_products",
            joinColumns = {@JoinColumn(name = "productId")},
            inverseJoinColumns = {@JoinColumn(name = "moduleId")})
    @JsonIgnore
    private Set<Module> modules = new HashSet<>();

}
