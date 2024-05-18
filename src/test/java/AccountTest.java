package com.elena;

import static org.junit.Assert.*;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
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
        logTestParameters(name, expected);
        checkAcountTest();
    }

    @Step
    public void checkAcountTest(){
        Account account = new Account(name);
        boolean result = account.checkNameToEmboss();
        assertEquals(expected, account.checkNameToEmboss());
        logTestResult(result);
    }

    @Step("Входные данные: name = {name}, expected = {expected}")
    private void logTestParameters(String name, boolean expected) {
        attachText("Имя", name);
        attachText("Ожидаемый результат", Boolean.toString(expected));
    }

    @Step("Результат теста: result = {result}")
    private void logTestResult(boolean result) {
        attachText("Фактический результат", Boolean.toString(result));
    }

    @Attachment(value = "{name}", type = "text/plain")
    private String attachText(String name, String value) {
        return value;
    }
}
