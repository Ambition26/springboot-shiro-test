package com.hui.pojo;

import java.io.Serializable;

public class Role implements Serializable {

    private Integer id;
    private Integer accountId;
    private String roleType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", roleType='" + roleType + '\'' +
                '}';
    }
}
