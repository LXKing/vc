package com.ccclubs.protocol.dto.jt808;

/**
 * Can数据转换成对应的状态数据，目前暂为soc，obdMiles
 * //FIXME：需要依据车型来转换
 *
 * @author qsxiaogang
 */
public class Can2State implements java.io.Serializable {

  private static final long serialVersionUID = 1l;

  int soc;
  int obdMiles;

  public int getSoc() {
    return soc;
  }

  public void setSoc(int soc) {
    this.soc = soc;
  }

  public int getObdMiles() {
    return obdMiles;
  }

  public void setObdMiles(int obdMiles) {
    this.obdMiles = obdMiles;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("{");
    sb.append("\"soc\":")
        .append(soc);
    sb.append(",\"obdMiles\":")
        .append(obdMiles);
    sb.append('}');
    return sb.toString();
  }
}
