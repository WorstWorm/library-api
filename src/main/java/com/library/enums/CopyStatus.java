package com.library.enums;

public enum CopyStatus {
    LOST("lost"),
    INSTOCK("in stock"),
    BORROWED("borrowed"),
    ONSITE("available only on site");

    private final String status;

    CopyStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }



}
