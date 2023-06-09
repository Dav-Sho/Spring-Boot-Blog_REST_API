package com.sho.blog_api.Utils;

import java.util.Date;

public class ErrorDetails {
    private Date datetime;
    private String message;
    private String details;

    public ErrorDetails(Date datetime, String message, String details) {
        this.datetime = datetime;
        this.message = message;
        this.details = details;
    }

    public Date getDatetime() {
        return datetime;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
