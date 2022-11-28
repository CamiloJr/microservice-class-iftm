package com.iftm.service.Services;

import org.springframework.stereotype.Service;

@Service
public class Utils {

    public String toUpperCase(String string) {
        return string.toUpperCase();
    }

    public String reverseString(String string) {
        StringBuilder stringBuildervarible = new StringBuilder();
        stringBuildervarible.append(string);
        stringBuildervarible.reverse();
        return stringBuildervarible.toString();
    }
}
