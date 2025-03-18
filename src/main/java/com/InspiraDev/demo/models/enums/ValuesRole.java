package com.InspiraDev.demo.models.enums;



public enum ValuesRole {

    ADMIN(1L),
    BASIC(2L);

    private Long value;

    ValuesRole(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}
