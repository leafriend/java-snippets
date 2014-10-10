package net.folab.java.snippets.ean;

import java.text.ParseException;

public class EanUtils {

    public static void validate13(String ean) throws ParseException {

        if (ean == null) {
            throw new IllegalArgumentException("Argument ean can't be null");
        }

        for (int i = 0 ;i < ean.length(); i++) {
            if (i == 13) {
                throw new ParseException("EAN-13 should be 13 digits", 13);
            }
            char ch = ean.charAt(i);
            if (ch < '0' || ch > '9') {
                throw new ParseException("EAN-13 should be 13 digits", i);
            }
        }

    }

}
