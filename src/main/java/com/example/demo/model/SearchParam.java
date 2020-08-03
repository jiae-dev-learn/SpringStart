package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchParam {
    private String account;
    private String email;
    private int page;

    // { "account" : "", "email" : "", "page" : 0 }
//
//    public SearchParam(String account, String email, int page){
//        this.account = account;
//        this.email = email;
//        this.page = page;
//    }
//    public void setAccount(String account) {
//        this.account = account;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public void setPage(int page) {
//        this.page = page;
//    }
//
//    public String getAccount() {
//        return account;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public int getPage() {
//        return page;
//    }
}
