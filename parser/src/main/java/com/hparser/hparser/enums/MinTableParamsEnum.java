package com.hparser.hparser.enums;

public enum MinTableParamsEnum {
    INDEX(0),
    STATUS(1),
    ROW(100),
    COLUMN(27);

    private final int param;

    MinTableParamsEnum(int param) {
        this.param = param;
    }

    public int getParam() {
        return param;
    }
}
