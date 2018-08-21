package com.mezzofy.MzCouponAPI.data;



import com.google.gson.annotations.Expose;

import java.util.List;

public class CampaignDataModel {
	@Expose
	private CampaignData campaign;
	@Expose
	private List<CampGrpDetailData> groups;

	public CampaignData getCampaign() {
		return campaign;
	}

	public void setCampaign(CampaignData merchant) {
		this.campaign = merchant;
	}

	public List<CampGrpDetailData> getGroups() {
		return groups;
	}

	public void setGroups(List<CampGrpDetailData> groups) {
		this.groups = groups;
	}

	
	
}
