package com.ccclubs.frm.redis.serializer;

import com.ccclubs.frm.redis.old.SerializeUtil;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.util.Assert;

import java.nio.charset.Charset;

/**
 * 老系统redis序列化
 *
 * @author jianghaiyang
 * @create 2017-07-18
 **/
public class MyRedisSerializer implements RedisSerializer<String> {
    private final Charset charset;

    public MyRedisSerializer() {
        this(Charset.forName("UTF8"));
    }

    public MyRedisSerializer(Charset charset) {
        Assert.notNull(charset, "Charset must not be null!");
        this.charset = charset;
    }

//    @Override
//    public byte[] serialize(Object o) throws SerializationException {
//        return new byte[0];
//    }

    public String deserialize(byte[] bytes) {
        return bytes== null ? null : SerializeUtil.unserialize(bytes).toString();//todo
    }

    public byte[] serialize(String string) {
        return string == null ? null : SerializeUtil.serialize(string);
    }
}
