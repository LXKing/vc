package com.ccclubs.frm.redis.serializer;

import com.caucho.hessian.io.AbstractHessianInput;
import com.caucho.hessian.io.AbstractHessianOutput;
import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * @author qsxiaogang
 * @create 2017-10-14
 **/
public class HessianSerializer implements RedisSerializer<Object> {

  @Override
  public byte[] serialize(final Object obj) throws SerializationException {
    if (obj == null) {
      return null;
    }

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    AbstractHessianOutput output = new Hessian2Output(outputStream);
    // 将对象写到流里
    try {
      output.writeObject(obj);

      output.flush();
      byte[] val = outputStream.toByteArray();
      output.close();
      return val;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public Object deserialize(final byte[] bytes) throws SerializationException {
    if (null == bytes || bytes.length == 0) {
      return null;
    }
    ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
    AbstractHessianInput input = new Hessian2Input(inputStream);
    Object obj = null;
    try {
      obj = input.readObject();

      input.close();
      return obj;
    } catch (IOException e) {
      e.printStackTrace();
      return obj;
    }
  }
}
