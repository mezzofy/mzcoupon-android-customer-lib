package mezzofy.com.libmzcoupon.data;

import java.util.List;

public class CampaignGroupListDataModel {
	private List<CampaignGroupDataModel> campaigngroups;
	private SiteDataModel size;

	public List<CampaignGroupDataModel> getCampaigngroups() {
		return campaigngroups;
	}
	public void setCampaigngroups(List<CampaignGroupDataModel> campaigngroups) {
		this.campaigngroups = campaigngroups;
	}


	public SiteDataModel getSize() {
		return size;
	}

	public void setSize(SiteDataModel size) {
		this.size = size;
	}
}