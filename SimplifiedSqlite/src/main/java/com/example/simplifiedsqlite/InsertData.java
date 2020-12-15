package com.example.simplifiedsqlite;

public class InsertData {
    String name,StringValue;
    int IntegerValue;

    public InsertData() {
    }

    public InsertData(String name, String stringValue, int integerValue) {
        this.name = name;
        StringValue = stringValue;
        IntegerValue = integerValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStringValue() {
        return StringValue;
    }

    public void setStringValue(String stringValue) {
        StringValue = stringValue;
    }

    public int getIntegerValue() {
        return IntegerValue;
    }

    public void setIntegerValue(int integerValue) {
        IntegerValue = integerValue;
    }
}
