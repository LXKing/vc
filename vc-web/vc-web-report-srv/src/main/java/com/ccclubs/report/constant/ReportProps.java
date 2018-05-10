package com.ccclubs.report.constant;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "report")
public class ReportProps {
    private Map<String, ReportServer> server = new HashMap<>();

    public Map<String, ReportServer> getServer() {
        return server;
    }

    public void setServer(Map<String, ReportServer> server) {
        this.server = server;
    }

    public ReportServer reportServerByType(ReportType type) {
        return server.get(type.msg());
    }

    public InetSocketAddress addrByType(ReportType type) {
        ReportServer rs = this.reportServerByType(type);
        InetSocketAddress isa = null;
        if (null != rs) {
            isa = new InetSocketAddress(rs.getHostname(), rs.getPort());
        }
        return isa;
    }

    public String getUsername(ReportType type) {
        ReportServer rs = this.reportServerByType(type);
        String username = null;
        if (StringUtils.isNotEmpty(rs.getUsername())) {
            username = rs.getUsername();
        }
        return username;
    }
    
    public String getPassword(ReportType type) {
        ReportServer rs = this.reportServerByType(type);
        String password = null;
        if (StringUtils.isNotEmpty(rs.getPassword())) {
            password = rs.getPassword();
        }
        return password;
    }
}
