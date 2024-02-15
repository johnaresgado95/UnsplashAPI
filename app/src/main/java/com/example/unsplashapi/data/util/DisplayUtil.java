package com.example.unsplashapi.data.util;

import java.text.DecimalFormat;

public class DisplayUtil {
    public static String FormatThousand(String number) {
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        return formatter.format(number);
    }
}
