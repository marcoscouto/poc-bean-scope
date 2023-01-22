package com.marcoscouto.prototype;

import java.util.UUID;

public class PrototypeData {

    private final String reference = UUID.randomUUID().toString();

    public String getReference() {
        return reference;
    }

}
