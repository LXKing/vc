import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

/**
 * GPS数据反向地理编码
 **/
public class TestGpsLocation {

  private String Url = "http://restapi.amap.com/v3/geocode/regeo?key=5be19569db0ef4581842854b91cffbf7&location=";

  @Test
  public void vehicleRegister() throws Exception, Throwable {
    String jsonString = readToString(
        "E:\\WorkSpace\\JavaSpace\\vc\\vc-web\\vc-web-front\\src\\test\\java\\json.txt");
    JSONArray array = JSON.parseArray(jsonString);

    for (int i = 0; i < array.size(); i++) {
      JSONObject item = (JSONObject) array.get(i);
      System.out.println(item);

      if (item.get("lat") != "0" && item.get("long") != "0") {

        double[] gpsArray = GPSUtils.gps84_To_Gcj02(Double.parseDouble(item.get("lat").toString()),
            Double.parseDouble(item.get("long").toString()));
        String uri = Url + gpsArray[1] + "," + gpsArray[0];
        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet(
            uri);//114.55.109.165:7001
        CloseableHttpResponse response = httpclient.execute(httpGet);

        try {
          System.out.println(response.getStatusLine());
          int statusCode = response.getStatusLine().getStatusCode();
          if (statusCode == 200) {
            HttpEntity entity = response.getEntity();

            String s2 = IOUtils.toString(entity.getContent(), "UTF-8");

            JSONObject gpsJson = JSONObject.parseObject(s2);
            JSONObject gpsJsonRegeocode = JSONObject
                .parseObject(gpsJson.get("regeocode").toString());
            JSONObject addressComponent = JSONObject
                .parseObject(gpsJsonRegeocode.get("addressComponent").toString());

            item.put("formatted_address", gpsJsonRegeocode.get("formatted_address"));
            item.put("country", addressComponent.get("country"));
            item.put("province", addressComponent.get("province"));
            item.put("city", addressComponent.get("city"));
            writeAppendToFile(
                "E:\\var\\logs\\terminal.txt",
                JSON.toJSONString(item), "UTF-8");
            writeAppendToFile(
                "E:\\var\\logs\\terminal.txt",
                ",", "UTF-8");
            EntityUtils.consume(entity);
          }

        } finally {
          response.close();
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
