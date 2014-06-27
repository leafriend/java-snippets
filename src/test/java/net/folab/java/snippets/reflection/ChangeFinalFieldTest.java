package net.folab.java.snippets.reflection;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ChangeFinalFieldTest {

    private static final int INIT_VALUE = 13;

    private static final int NEW_VALUE = 42;

    private ChangeFinalField object;

    private Class<ChangeFinalField> type;

    @Before
    public void setUp() throws Exception {
        object = new ChangeFinalField(INIT_VALUE);
        type = ChangeFinalField.class;
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testChangeFinalField() throws SecurityException,
            NoSuchFieldException, IllegalArgumentException,
            IllegalAccessException {

        assertThat("Before setting, it should be default value: 3",
                object.getFinalField(), is(INIT_VALUE));

        Field finalField = type.getDeclaredField("finalField");

        finalField.setAccessible(true);
        finalField.set(object, NEW_VALUE);

        assertThat("Before setting, it should be default value: 3",
                object.getFinalField(), is(NEW_VALUE));

    }

}
