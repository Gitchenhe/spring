package com.example.demo.convert;

/**
 * Created by chenhe on 2018/3/5.
 */
public enum GenderEnum  {
    male("male"),
    female("female");

    private final String value;

    GenderEnum(String v) {
        this.value = v;
    }

    public String toString() {
        return this.value;
    }

    public static GenderEnum get(int v) {
        String str = String.valueOf(v);
        return get(str);
    }

    public static GenderEnum get(String str) {
        for (GenderEnum e : values()) {
            if (e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }
}
