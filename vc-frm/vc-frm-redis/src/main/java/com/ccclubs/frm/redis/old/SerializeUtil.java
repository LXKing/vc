package com.ccclubs.frm.redis.old;

import java.io.*;

/**
 * 老系统redis序列化
 *
 * @author jianghaiyang
 * @create 2017-07-18
 **/
public class SerializeUtil {
    public SerializeUtil() {
    }

    public static byte[] serialize(Object object) {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;

        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            byte[] bytes = baos.toByteArray();
            return bytes;
        } catch (Exception var4) {
            var4.printStackTrace();
            return null;
        }
    }

    public static Object unserialize(byte[] bytes) {
        ByteArrayInputStream bais = null;

        try {
            bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais) {
                protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
                    return Class.forName(desc.getName(), true, Thread.currentThread().getContextClassLoader());
                }
            };
            return ois.readObject();
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }
}
