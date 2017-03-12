//package com.odeblic.smart-enums;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum SmartEnum {
    ZERO(0, "Zero"),
    ONE(1, "One"),
    TWO(2, "Two"),
    THREE(3, "Three"),
    FOUR(4, "Four"),
    FIVE(5, "Five"),
    UNKNOWN(-1, "Unknown");

    private final int code;
    private final String name;
    //private static final Map<String, SmartEnum> aliasesX = new HashMap<String, SmartEnum>() {"", "", ""};

    private static final Map<String, SmartEnum> aliases;

    static {
        Map<String, SmartEnum> _aliases = new HashMap<String, SmartEnum>();
        _aliases.put("ZERO", ZERO);
        _aliases.put("Zero", ZERO);
        _aliases.put("zero", ZERO);
        _aliases.put("ONE", ONE);
        _aliases.put("One", ONE);
        _aliases.put("one", ONE);
        _aliases.put("TWO", TWO);
        _aliases.put("Two", TWO);
        _aliases.put("two", TWO);
        _aliases.put("THREE", THREE);
        _aliases.put("Three", THREE);
        _aliases.put("three", THREE);
        _aliases.put("FOUR", FOUR);
        _aliases.put("Four", FOUR);
        _aliases.put("four", FOUR);
        _aliases.put("FIVE", FIVE);
        _aliases.put("Five", FIVE);
        _aliases.put("five", FIVE);
        aliases = Collections.unmodifiableMap(_aliases);
    }

    private SmartEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static SmartEnum fromCode(int code) {
        for (SmartEnum e : values()) {
            if (e.getCode() == code) {
                return e;
            }
        }
        return UNKNOWN;
    }

    public static SmartEnum fromName(String name) {
        SmartEnum e = aliases.get(name);
        if (e == null) {
            e = UNKNOWN;
        }
        return e;
        /*
        for (SmartEnum e : values()) {
            if (e.getName().equals(name)) {
                return e;
            }
        }
        return UNKNOWN;
        */
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
