package com.epam.misp.framework.util;

public interface IConstants {

    String notMainPage = "This is not the '%s' of the mail service.";
    String notReceived = "The letter isn't received.";

    static String not(String main_page) {
        return  String.format(notMainPage,main_page);
    }
}