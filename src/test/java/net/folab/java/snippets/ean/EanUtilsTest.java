package net.folab.java.snippets.ean;

import static net.folab.java.snippets.ean.EanUtils.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EanUtilsTest {

    @Test(expected = IllegalArgumentException.class)
    public void testValidate13_null() throws Exception {
        validate13(null);
    }

    @Test(expected = ParseException.class)
    public void testValidate13_14digits() throws Exception {
        validate13("12345678901234");
    }

    @Test(expected = ParseException.class)
    public void testValidate13_alphabet0() throws Exception {
        validate13("a234567890123");
    }

    @Test(expected = ParseException.class)
    public void testValidate13_alphabet12() throws Exception {
        validate13("123456789012a");
    }

    @Test
    public void testValidate13() throws Exception {
        validate13("1234567890123");
        assertTrue(true);
    }

}
