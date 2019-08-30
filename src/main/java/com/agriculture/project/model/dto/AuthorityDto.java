package com.agriculture.project.model.dto;

import com.agriculture.project.model.Authority;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class AuthorityDto {
    private Long userId;
    private String authority;

    public AuthorityDto(Authority authority){
        this.userId = authority.getUser().getUserId();
        this.authority = authority.getAuthority();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
