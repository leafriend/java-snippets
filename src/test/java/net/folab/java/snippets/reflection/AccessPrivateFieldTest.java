package net.folab.java.snippets.reflection;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AccessPrivateFieldTest {

    private AccessPrivateField object;

    private Class<AccessPrivateField> type;

    @Before
    public void setUp() throws Exception {
        object = new AccessPrivateField();
        type = AccessPrivateField.class;
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSettingPrivateField() throws SecurityException,
            NoSuchFieldException, IllegalArgumentException,
            IllegalAccessException {

        assertThat("Before setting, it should be default value: 3",
                object.getPrivateToSet(), is(3));

        Field privateToSet = type.getDeclaredField("privateToSet");

        // Make private field accessible even it's private
        privateToSet.setAccessible(true);

        privateToSet.set(object, 42);

        assertThat("After setting, it should be new value: 42",
                object.getPrivateToSet(), is(42));

    }

    @Test
    public void testGettingPrivateField() throws SecurityException,
            NoSuchFieldException, IllegalArgumentException,
            IllegalAccessException {

        Field privateToGet = type.getDeclaredField("privateToGet");

        // Make private field accessible even it's private
        privateToGet.setAccessible(true);

        assertThat("Before setting, it should be default value: 7",
                (Integer) privateToGet.get(object), is(7));

        // Update field value through setter
        object.setPrivateToGet(42);

        assertThat("After setting, it should be new value: 42",
                (Integer) privateToGet.get(object), is(42));

    }

}
