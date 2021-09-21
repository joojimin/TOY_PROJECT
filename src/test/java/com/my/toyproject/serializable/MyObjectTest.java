package com.my.toyproject.serializable;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.jupiter.api.Test;

class MyObjectTest {


    @Test
    void serializableTest() throws IOException, ClassNotFoundException {
        // Serializable
        MyObject myObject = new MyObject(1L, "주지민", 30, LocalDateTime.now());

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(myObject);
        byte[] results = baos.toByteArray();

        String encodedBase64 = Base64.encodeBase64String(results);
        System.out.println(encodedBase64);

        // Deserializable
        byte[] bytes = Base64.decodeBase64(encodedBase64);
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Object deserializableObject = ois.readObject();
        MyObject deserializableMyObject = (MyObject) deserializableObject;

        System.out.println(deserializableMyObject);
    }
}
