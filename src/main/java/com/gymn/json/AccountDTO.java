package com.gymn.json;

import java.io.Serializable;

/**
 * Created by hfang on 17/2/23.
 */
public class AccountDTO implements Serializable {
    private Integer accountId;
    private Integer source;
    private Integer innerAccountId;
    private String misNo;

    public String getMisNo() {
        return misNo;
    }

    public void setMisNo(String misNo) {
        this.misNo = misNo;
    }

    public AccountDTO(Integer accountId, Integer source) {
        this.accountId = accountId;
        this.source = source;
    }

    public AccountDTO(Integer accountId, Integer source, Integer innerAccountId) {
        this.accountId = accountId;
        this.source = source;
        this.innerAccountId = innerAccountId;
    }

    public AccountDTO(Integer accountId, Integer source, String misNo) {
        this.accountId = accountId;
        this.source = source;
        this.misNo = misNo;
    }

    public AccountDTO() {
    }



    public Integer getInnerAccountId() {
        return innerAccountId;
    }

    public void setInnerAccountId(Integer innerAccountId) {
        this.innerAccountId = innerAccountId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountDTO)) return false;
        AccountDTO account = (AccountDTO) o;
        if (!getAccountId().equals(account.getAccountId()))
            return false;
        return getSource().equals(account.getSource());

    }

    @Override
    public int hashCode() {
        int result = getAccountId().hashCode();
        result = 31 * result + getSource().hashCode();
        return result;
    }
}
