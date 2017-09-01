package com.ccclubs.command.inf.order;

import com.ccclubs.command.dto.*;

/**
 * 订单相关指令
 *
 * @author jianghaiyang
 * @create 2017-06-30
 **/
public interface OrderCmdInf {
    IssueOrderOutput issueOrderData(IssueOrderInput input);

    IssueAuthOrderOutput issueAuthOrderData(IssueAuthOrderInput input);

    IssueOrderDetailOutput issueOrderDetailData(IssueOrderDetailInput input);

    RenewOrderOutput renewOrder(RenewOrderInput input);

    RenewOrderReplyFOutput renewOrderReplyFailed(RenewOrderReplyFInput input);

    RenewOrderReplySOutput renewOrderReplySuccess(RenewOrderReplySInput input);
}
