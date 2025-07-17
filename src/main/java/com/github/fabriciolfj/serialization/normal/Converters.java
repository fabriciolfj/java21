package com.github.fabriciolfj.serialization.normal;

import java.io.*;

public final class Converters {

    private Converters() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static byte[] objectToBytes(Serializable obj) throws IOException {       
        
        try ( ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream ois = new ObjectOutputStream(baos)) {
            ois.writeObject(obj);
            
            return baos.toByteArray();
        }                
    }

    public static Object bytesToObject(byte[] bytes)
            throws IOException, ClassNotFoundException {
                
        try ( InputStream is = new ByteArrayInputStream(bytes);
                ObjectInputStream ois = new ObjectInputStream(is)) {
            return ois.readObject();
        }
    }
}
