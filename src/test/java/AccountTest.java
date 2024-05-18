package com.elena;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import io.qameta.allure.Description;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class AccountTest {
    private String name;
    private boolean expected;

    public AccountTest(String name, boolean expected){
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Алиса Селезнева", true},
                {"Алиса", false},
                {"Alisa Selesneva", true}
        });
    }

    @Test
    @Description("Проверка метода Account с разными входными данными")
    public void AccountTest(){
        Account account = new Account(name);
        assertEquals(expected, account.checkNameToEmboss());
    }
}
