package com.mezzofy.MzCouponAPI.data;


import java.util.List;

/**
 * Created by aruna on 9/20/17.
 */

public class MassCouponDataModel {
    private MasscouponData masscoupon;
    private List<MassCouponDetailDataModel> masscoupondtls;


    public MasscouponData getMasscoupon() {
        return masscoupon;
    }

    public void setMasscoupon(MasscouponData masscoupon) {
        this.masscoupon = masscoupon;
    }

    public List<MassCouponDetailDataModel> getMasscoupondtls() {
        return masscoupondtls;
    }

    public void setMasscoupondtls(List<MassCouponDetailDataModel> masscoupondtls) {
        this.masscoupondtls = masscoupondtls;
    }
}
