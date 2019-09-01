package com.agriculture.project.model;

import com.agriculture.project.controller.request.RegisterUserRequest;
import com.agriculture.project.model.dto.AuthorityDto;
import com.agriculture.project.model.dto.FarmDto;
import com.agriculture.project.model.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    //I didn't use @Data. Because lombok causes infinite loop for authentication.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(unique = true)
    @NotNull(message = "*Please provide name")
    private String username;

    @Column
    @NotNull
    private String userFirstname;

    @Column
    @NotNull
    private String userLastname;

    @Column
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotNull(message = "*Please provide your password")
    private String userPassword;

    @Column
    @NotNull
    @Temporal(value = TemporalType.DATE)
    private Date userRegistrationDate;

    @Column
    @NotNull
    private String userHomeAddress;

    @Column(name = "email")
    @Email(message = "*Please provide a valid Email")
    @NotNull(message = "*Please provide an email")
    private String userEmail;

    @Column
    @NotNull
    private String userPhone;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Authority> authority = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(
            name = "users_farms",
            joinColumns = {@JoinColumn(name = "userId")},
            inverseJoinColumns = {@JoinColumn(name = "farmId")})
    private List<Farm> farms;

    @ManyToMany(mappedBy = "users")
    private List<Product> products;

    public User(RegisterUserRequest registerUserRequest){
        System.out.println(registerUserRequest.toString());
        this.userRegistrationDate = new Date();
        this.username = registerUserRequest.getUsername();
        this.userFirstname = registerUserRequest.getUserFirstname();
        this.userLastname = registerUserRequest.getUserLastname();
        this.userPassword = registerUserRequest.getUserPassword();
        this.userHomeAddress = registerUserRequest.getUserHomeAddress();
        this.userEmail = registerUserRequest.getUserEmail();
        this.userPhone = registerUserRequest.getUserPhone();
    }

    public Set<FarmDto> getFarmsDto(){
        Set<FarmDto> farmDtos = new HashSet<>();
        for(Farm f : farms) farmDtos.add(new FarmDto(f));
        return farmDtos;
    }

    public Set<ProductDto> getProductsDto(){
        Set<ProductDto> productDtos = new HashSet<>();
        for(Product p : products) productDtos.add(new ProductDto(p));
        return productDtos;
    }

    public Set<AuthorityDto> getAuthorityDto(){
        Set<AuthorityDto> authorityDtos = new HashSet<>();
        for(Authority a : authority) authorityDtos.add(new AuthorityDto(a));
        return authorityDtos;
    }

    public Set<Authority> getAuthority() {
        return authority;
    }

    public void setAuthority(Set<Authority> authority) {
        this.authority = authority;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserFirstname() {
        return userFirstname;
    }

    public void setUserFirstname(String userFirstname) {
        this.userFirstname = userFirstname;
    }

    public String getUserLastname() {
        return userLastname;
    }

    public void setUserLastname(String userLastname) {
        this.userLastname = userLastname;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Date getUserRegistrationDate() {
        return userRegistrationDate;
    }

    public void setUserRegistrationDate(Date userRegistrationDate) {
        this.userRegistrationDate = userRegistrationDate;
    }

    public String getUserHomeAddress() {
        return userHomeAddress;
    }

    public void setUserHomeAddress(String userHomeAddress) {
        this.userHomeAddress = userHomeAddress;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public List<Farm> getFarms() {
        return farms;
    }

    public void setFarms(List<Farm> farms) {
        this.farms = farms;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


}