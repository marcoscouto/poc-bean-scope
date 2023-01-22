package com.marcoscouto.prototype;

public class ThreadLocalHolder {

    private static final ThreadLocal<PrototypeData> data = new ThreadLocal<>();

    public static PrototypeData getPrototypeData() {
        if (data.get() == null) data.set(new PrototypeData());
        return data.get();
    }

}
