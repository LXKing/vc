package com.ccclubs.phoenix.output;

import com.ccclubs.phoenix.orm.dto.MqttStateDto;
import java.io.Serializable;
import java.util.List;

/**
 * 历史轨迹数据
 *
 * @author jianghaiyang
 * @create 2018-09-26
 **/
public class HistoryTrackOutput implements Serializable {

    String vin;

    List<MqttStateDto> tracks;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public List<MqttStateDto> getTracks() {
        return tracks;
    }

    public void setTracks(List<MqttStateDto> tracks) {
        this.tracks = tracks;
    }
}
