package com.mezzofy.MzCouponAPI.data;

import java.util.List;

/**
 * Created by Aruna on 28/03/17.
 */

public class PoListDataModel {
    private List<PomData> pos;
    private SiteDataModel size;

    public List<PomData> getPos() {
        return pos;
    }

    public void setPos(List<PomData> pos) {
        this.pos = pos;
    }

    public SiteDataModel getSize() {
        return size;
    }

    public void setSize(SiteDataModel size) {
        this.size = size;
    }
}
