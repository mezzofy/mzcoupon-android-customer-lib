package com.mezzofy.MzCouponAPI.data;

import java.util.List;

/**
 * Created by aruna on 9/20/17.
 */

public class WalletTxnListDataModel {
    private List<WalletTxnDataModel> wallettxns;
    private SizeDataModel size;

    public List<WalletTxnDataModel> getWallettxns() {
        return wallettxns;
    }

    public void setWallettxns(List<WalletTxnDataModel> wallettxns) {
        this.wallettxns = wallettxns;
    }

    public SizeDataModel getSize() {
        return size;
    }

    public void setSize(SizeDataModel size) {
        this.size = size;
    }
}
