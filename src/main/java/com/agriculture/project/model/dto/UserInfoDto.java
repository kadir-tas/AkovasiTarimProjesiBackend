package com.agriculture.project.model.dto;

import com.agriculture.project.model.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDto implements Serializable {
    private Long userId;
    private String username;
    private String userFirstname;
    private String userLastname;
    private Date userRegistrationDate;
    private String userHomeAddress;
    private String userEmail;
    private String userPhone;
    private Set<AuthorityDto> authority;
    private Set<FarmDto> farms;
    private Set<ProductDto> products;

    public UserInfoDto(User user){
        this.userId = user.getUserId();
        this.username = user.getUsername();
        this.userFirstname = user.getUserFirstname();
        this.userLastname = user.getUserLastname();
        this.userRegistrationDate = user.getUserRegistrationDate();
        this.userHomeAddress = user.getUserHomeAddress();
        this.userEmail = user.getUserEmail();
        this.userPhone = user.getUserPhone();
        this.authority = user.getAuthorityDto();
        this.farms = user.getFarmsDto();
        this.products = user.getProductsDto();
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

    public Set<AuthorityDto> getAuthority() {
        return authority;
    }

    public void setAuthority(Set<AuthorityDto> authority) {
        this.authority = authority;
    }

    public Set<FarmDto> getFarms() {
        return farms;
    }

    public void setFarms(Set<FarmDto> farms) {
        this.farms = farms;
    }

    public Set<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductDto> products) {
        this.products = products;
    }
}
