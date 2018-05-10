package com.ccclubs.report.service.task;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ccclubs.report.netty.client.NettyClient;

//@Component
public class TestTask {
	private Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private NettyClient nc;
	static AtomicInteger count = new AtomicInteger(1);
	// @Scheduled(cron="59 59 23 28-31 * ?")
	//0 0 0 L * ? 
	//@Scheduled(cron = "0 0 0 1 4 ?")//0/5 * * * * ?
	//@Scheduled(cron = "0/5 * * * * ?")//
	public void doSomething() {
		// final Calendar c = Calendar.getInstance();
		// log.debug("企业订单时间：{}", c.getTime());
		log.debug("****************************************");
		// if (c.get(Calendar.DATE) == c.getActualMaximum(Calendar.DATE)) {
		int i = count.getAndIncrement();
		 nc.send("127.0.0.1", 19001, "hi::::" + i);
		// }

	}
}
