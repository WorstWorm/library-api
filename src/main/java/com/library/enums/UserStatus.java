package com.library.enums;

public enum UserStatus {
    ACTIVE("active reader"),
    BLOCKED("blocked user"),
    LIBRARIAN("librarian");

    private String status;

    UserStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }




}
