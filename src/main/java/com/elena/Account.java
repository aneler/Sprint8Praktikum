package com.elena;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        /*
            Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
            Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
            в строке не меньше 3 и не больше 19 символов,
            в строке есть только один пробел,
            пробел стоит не в начале и не в конце строки.
         */
        int nameLength = this.name.length();
        boolean lengthCondition = nameLength >= 3 && nameLength <= 19;
        boolean spaceCondition = this.name.indexOf(' ') == this.name.lastIndexOf(' ') && this.name.indexOf(' ') != -1;
        boolean spacePositionCondition = !this.name.startsWith(" ") && !this.name.endsWith(" ");
        return lengthCondition && spaceCondition && spacePositionCondition;
    }

}