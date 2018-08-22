package mezzofy.com.libmzcoupon.data;






import java.util.List;

public class CampaignGroupDataModel {
	private CampGrpData campaigngroup;
	private List<CampaignGroupDtlDataModel>  campGrpDetails;
	
	public CampGrpData getCampaigngroup() {
		return campaigngroup;
	}

	public void setCampaigngroup(CampGrpData campaigngroup) {
		this.campaigngroup = campaigngroup;
	}

	public List<CampaignGroupDtlDataModel> getCampGrpDetails() {
		return campGrpDetails;
	}

	public void setCampGrpDetails(List<CampaignGroupDtlDataModel> campGrpDetails) {
		this.campGrpDetails = campGrpDetails;
	}

}