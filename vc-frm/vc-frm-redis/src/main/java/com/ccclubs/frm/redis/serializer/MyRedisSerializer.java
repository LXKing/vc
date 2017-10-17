package com.ccclubs.frm.redis.serializer;

import com.ccclubs.frm.redis.old.SerializeUtil;
import java.nio.charset.Charset;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.util.Assert;

/**
 * 老系统redis序列化
 *
 * @author jianghaiyang
 * @create 2017-07-18
 **/
public class MyRedisSerializer<T> implements RedisSerializer<T> {

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

  public T deserialize(byte[] bytes) {
    return bytes == null ? null : (T) SerializeUtil.unserialize(bytes);//todo
  }

  public byte[] serialize(T string) {
    return string == null ? null : SerializeUtil.serialize(string);
  }
}
