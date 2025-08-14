package com.paybrook.eventregistration.constant;

public class GlobalConstants {
public static final String API = "/api";

public static Integer getZeroIfNUll(Integer value)
{
    return value != null ? value : Integer.valueOf(0);
}
}
