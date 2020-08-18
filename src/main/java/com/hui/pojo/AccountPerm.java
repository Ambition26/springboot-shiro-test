package com.hui.pojo;

import java.io.Serializable;

public class AccountPerm implements Serializable {

    private Integer id;
    private Integer accountId;
    private String accountPrem;

    @Override
    public String toString() {
        return "AccountPerm{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", accountPrem='" + accountPrem + '\'' +
                '}';
    }

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

    public String getAccountPrem() {
        return accountPrem;
    }

    public void setAccountPrem(String accountPrem) {
        this.accountPrem = accountPrem;
    }
}
