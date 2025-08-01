package com.github.fabriciolfj.java131;

import java.io.*;
import java.util.Base64;

public class Melon implements Serializable {

    private final String type;
    private final float weight;

    public Melon(final String type, final float weight) {
        this.type = type;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public float getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Melon{" +
                "type='" + type + '\'' +
                ", weight=" + weight +
                '}';
    }

    public static byte[] objectToBytes(Serializable obj) throws IOException {
        try(ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream ois = new ObjectOutputStream(baos)) {

            ois.writeObject(obj);
            return baos.toByteArray();
        }
    }

    public static Object bytesToObject(byte[] bytes) throws IOException, ClassNotFoundException {
        try(InputStream is = new ByteArrayInputStream(bytes); ObjectInputStream ois = new ObjectInputStream(is)) {
            return ois.readObject();
        }
    }

    public static String objectToString(Serializable obj) throws IOException {
        try(ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream ois = new ObjectOutputStream(baos)) {
            ois.writeObject(obj);

            return Base64.getEncoder().encodeToString(baos.toByteArray());
        }
    }

    public static Object stringToObject(String obj) throws IOException, ClassNotFoundException {
        byte[] data = Base64.getDecoder().decode(obj);
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
            return ois.readObject();
        }
    }
}
