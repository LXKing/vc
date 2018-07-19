package com.ccclubs.command.inf.order;

import com.ccclubs.command.dto.*;

/**
 * 订单相关指令
 *
 * @author jianghaiyang
 * @create 2017-06-30
 **/
public interface OrderCmdInf {
    /**
     * 订单数据下发
     * @param input
     * @return
     */
    IssueOrderOutput issueOrderData(IssueOrderInput input);

    /**
     * 下发订单数据--需要授权信息
     * @param input
     * @return
     */
    IssueAuthOrderOutput issueAuthOrderData(IssueAuthOrderInput input);

    /**
     * 订单详情
     * @param input
     * @return
     */
    IssueOrderDetailOutput issueOrderDetailData(IssueOrderDetailInput input);

    /**
     * 订单续订
     * @param input
     * @return
     */
    RenewOrderOutput renewOrder(RenewOrderInput input);

    /**
     * 订单续订失败-应答
     * @param input
     * @return
     */
    RenewOrderReplyFOutput renewOrderReplyFailed(RenewOrderReplyFInput input);

    /**
     * 订单续订成功
     * @param input
     * @return
     */
    RenewOrderReplySOutput renewOrderReplySuccess(RenewOrderReplySInput input);
}
