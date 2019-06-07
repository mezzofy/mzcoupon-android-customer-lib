package mezzofy.com.libmzcoupon.data;

import java.util.List;

public class ChannelLocationDataListModel {

    private List<ChannelLocationDataModel> channellocations;
    private Size size;

    public List<ChannelLocationDataModel> getChannellocations() {
        return channellocations;
    }

    public void setChannellocations(List<ChannelLocationDataModel> channellocations) {
        this.channellocations = channellocations;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
