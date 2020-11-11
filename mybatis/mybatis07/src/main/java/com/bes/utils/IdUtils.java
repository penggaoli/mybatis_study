package com.bes.utils;

import lombok.ToString;
import org.junit.Test;

import java.util.UUID;

public class IdUtils {
    public static String getId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    @Test
    public void getIdTest() {
        for (int i = 0; i < 10; i++) {
            System.out.println(IdUtils.getId());
        }
    }
}
