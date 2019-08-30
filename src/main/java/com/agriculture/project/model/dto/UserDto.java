package com.agriculture.project.model.dto;

import com.agriculture.project.model.Authority;
import com.agriculture.project.model.Farm;
import com.agriculture.project.model.Product;
import com.agriculture.project.model.User;
import java.util.Date;
import java.util.Set;
import java.util.List;

public class UserDto {

    private Long userId;
    private String username;
    private String userFirstname;
    private String userLastname;
    private Date userRegistrationDate;
    private String userHomeAddress;
    private String userEmail;
    private String userPhone;
    //private Set<Authority> authority;
    //private List<Farm> farms;
    //private List<Product> products;

    public UserDto(User user){
        this.userId = user.getUserId();
        this.username = user.getUsername();
        this.userFirstname = user.getUserFirstname();
        this.userLastname = user.getUserLastname();
        this.userRegistrationDate = user.getUserRegistrationDate();
        this.userHomeAddress = user.getUserHomeAddress();
        this.userEmail = user.getUserEmail();
        this.userPhone = user.getUserPhone();
        //this.authority = user.getAuthority();
        //this.farms = user.getFarms();
        //this.products = user.getProducts();
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

  /*  public Set<Authority> getAuthority() {
        return authority;
    }

    public void setAuthority(Set<Authority> authority) {
        this.authority = authority;
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
    }*/
}
