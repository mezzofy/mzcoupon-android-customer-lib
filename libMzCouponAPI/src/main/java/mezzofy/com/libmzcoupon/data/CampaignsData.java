package mezzofy.com.libmzcoupon.data;


import java.util.List;

/**
 * Created by inforios on 31/01/17.
 */

public class CampaignsData {

    private List<CampaignDataModel> campaigns;
    private List<CampGrpData> campaigngroups;
    private Size size;

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public List<CampGrpData> getCampaigngroups() {
        return campaigngroups;
    }

    public void setCampaigngroups(List<CampGrpData> campaigngroups) {
        this.campaigngroups = campaigngroups;
    }

    public List<CampaignDataModel> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<CampaignDataModel> campaigns) {
        this.campaigns = campaigns;
    }
}
