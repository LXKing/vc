package com.ccclubs.admin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ccclubs.admin.model.EvAlarmRecord;
import com.ccclubs.admin.model.ReportParam;
import com.ccclubs.admin.query.EvAlarmRecordQuery;
import com.ccclubs.admin.task.threads.ReportThread;
import com.ccclubs.admin.util.EvManageContext;
import com.ccclubs.admin.vo.TableResult;
import com.ccclubs.admin.vo.VoResult;
import com.ccclubs.frm.spring.entity.ApiMessage;
import com.ccclubs.mongo.orm.model.history.CsVehicleExp;
import com.ccclubs.mongo.orm.query.CsVehicleExpQuery;
import com.github.pagehelper.PageInfo;
import okhttp3.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * GB报警数据
 *
 * @author jianghaiyang
 * @create 2018-04-08
 **/
@RestController
@RequestMapping("electricity/alarm")
public class GbAlarmController {

    private static final OkHttpClient.Builder builder = new OkHttpClient().newBuilder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS);

    public static final OkHttpClient client = builder.build();

    /**
     * 获取分页列表数据
     *
     * @param query
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public TableResult<EvAlarmRecord> list(EvAlarmRecordQuery query, @RequestParam(defaultValue = "0") Integer page,
                                           @RequestParam(defaultValue = "10") Integer rows) throws IOException {
        JSONObject jsonObject = (JSONObject) JSON.toJSON(query);
        Set<Map.Entry<String, Object>> entrySet = jsonObject.entrySet();
        Map<String, Object> input = new HashMap<>();
        for (Map.Entry<String, Object> entry : entrySet) {
            input.put(entry.getKey(), entry.getValue());
        }
        input.put("pageNum", page.toString());
        input.put("pageSize", rows.toString());
        String json = JSON.toJSONString(input);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request request = new Request.Builder()
                .url("http://127.0.0.1:8090/ev/getAlarmRecordPage")
                .header("appId", "1000002")
                .header("sign", HmacUtils.hmacSha1Hex("appkey", DigestUtils.md5Hex(json)))
                .post(body)
                .build();

        Response response = client.newCall(request).execute();
        ApiMessage<PageInfo<EvAlarmRecord>> result = JSON.parseObject(response.body().string(), new TypeReference<ApiMessage<PageInfo<EvAlarmRecord>>>() {
        });
        TableResult<EvAlarmRecord> r = new TableResult<>(result.getData());
        return r;
    }

    @Autowired
    ReportThread reportThread;

    /**
     * 根据文本检索车辆历史状态信息并导出。
     */
    @RequestMapping(value = "report", method = RequestMethod.POST)
    public VoResult<String> getReport(@org.springframework.web.bind.annotation.RequestBody ReportParam<EvAlarmRecordQuery> reportParam) throws IOException {
        JSONObject jsonObject = (JSONObject) JSON.toJSON(reportParam.getQuery());
        Set<Map.Entry<String, Object>> entrySet = jsonObject.entrySet();
        Map<String, Object> input = new HashMap<>();
        for (Map.Entry<String, Object> entry : entrySet) {
            input.put(entry.getKey(), entry.getValue());
        }
        String json = JSON.toJSONString(input);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request request = new Request.Builder()
                .url("http://127.0.0.1:8090/ev/getAllAlarmRecord")
                .header("appId", "1000002")
                .header("sign", HmacUtils.hmacSha1Hex("appkey", DigestUtils.md5Hex(json)))
                .post(body)
                .build();

        Response response = client.newCall(request).execute();
        ApiMessage<List<EvAlarmRecord>> result = JSON.parseObject(response.body().string(), new TypeReference<ApiMessage<List<EvAlarmRecord>>>() {
        });
        String uuid = UUID.randomUUID().toString();
        reportThread.setBaseName("Vehicle_Alarm");
        reportThread.setList(result.getData());
        reportThread.setUserUuid(uuid);
        reportThread.setReportParam(reportParam);
        EvManageContext.getThreadPool().execute(reportThread);

        VoResult<String> r = new VoResult<>();
        r.setSuccess(true).setMessage("导出任务已经开始执行，请稍候。");
        r.setValue(uuid);
        return r;
    }
}
