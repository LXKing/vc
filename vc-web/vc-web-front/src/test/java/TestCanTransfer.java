import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ccclubs.protocol.dto.mqtt.can.CanDataTypeI;
import com.ccclubs.protocol.dto.mqtt.can.CanHelperFactory;
import com.ccclubs.protocol.inf.ICanData;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.junit.Test;

/**
 * CAN数据转换
 **/
public class TestCanTransfer {

  @Test
  public void anTransfer() throws Exception, Throwable {
    String jsonString = readToString(
        "E:\\WorkSpace\\JavaSpace\\vc\\vc-web\\vc-web-front\\src\\test\\java\\jsonCan.txt");
    JSONArray array = JSON.parseArray(jsonString);
    for (int i = 0; i < array.size(); i++) {
      JSONObject item = (JSONObject) array.get(i);
      System.out.println(item);

      List<ICanData> list = CanHelperFactory.parseCanData(item.getString("can"));
      for (ICanData iCanData : list) {
        if (iCanData instanceof CanDataTypeI) {
          CanDataTypeI canItem = ((CanDataTypeI) iCanData);

          item.put("map", JSON.toJSONString(canItem.getMap()));

          writeAppendToFile("E:\\var\\logs\\terminalCan.txt",
              JSON.toJSONString(item), "UTF-8");
          writeAppendToFile("E:\\var\\logs\\terminalCan.txt",
              ",", "UTF-8");
        }
      }
    }
  }

  public static void writeAppendToFile(String fileName, String content, String encode) {
    if (encode == null) {
      encode = "UTF-8";
    }

    FileWriter writer = null;

    try {
      fileName = fileName.replaceAll("\\\\", "/");
      fileName = fileName.replaceAll("//", "/");
      String filePath = fileName.substring(0, fileName.lastIndexOf("/"));
      if (!(new File(filePath)).exists()) {
        (new File(filePath)).mkdirs();
      }

      writer = new FileWriter(fileName, true);
      writer.write(content + "\r\n");
    } catch (IOException var13) {
      System.out.println("写文件[" + fileName + "]到[" + fileName + "]时出错:" + var13.getMessage());
      var13.printStackTrace();
    } finally {
      try {
        if (writer != null) {
          writer.close();
        }
      } catch (IOException var12) {
        var12.printStackTrace();
      }

    }

  }

  public String readToString(String fileName) {
    String encoding = "UTF-8";
    File file = new File(fileName);
    Long filelength = file.length();
    byte[] filecontent = new byte[filelength.intValue()];
    try {
      FileInputStream in = new FileInputStream(file);
      in.read(filecontent);
      in.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    try {
      return new String(filecontent, encoding);
    } catch (UnsupportedEncodingException e) {
      System.err.println("The OS does not support " + encoding);
      e.printStackTrace();
      return null;
    }
  }
}
