package com.ccclubs.command.remote;

import com.ccclubs.mongo.orm.model.remote.CsRemote;
import com.ccclubs.mongo.service.impl.CsRemoteService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.*;

/**
 * 同步、异步保存指令记录
 *
 * @author jianghaiyang
 * @create 2018-01-25
 **/
@Component
public class CsRemoteManager {

    @Resource
    CsRemoteService remoteService;

    @Resource(name = "vcThreadPool")
    ExecutorService executorService;

    public void syncSave(CsRemote csRemote) {
        remoteService.save(csRemote);
    }

    public void asyncSave(CsRemote csRemote) {
        executorService.execute(new RemoteSaveTask(csRemote));
    }

    class RemoteSaveTask implements Runnable {
        private CsRemote csRemote;

        public RemoteSaveTask(CsRemote csRemote) {
            this.csRemote = csRemote;
        }

        @Override
        public void run() {
            remoteService.save(csRemote);
        }
    }


}
