package com.epam.misp.framework.util;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomUtil {

    public static String getMailsTopic() {
        return "Tests Message " + RandomStringUtils.randomAlphanumeric(10);
    }

    public static String getMailsBody() {
        return "Tests Body " + RandomStringUtils.randomAlphanumeric(30);
    }

}
