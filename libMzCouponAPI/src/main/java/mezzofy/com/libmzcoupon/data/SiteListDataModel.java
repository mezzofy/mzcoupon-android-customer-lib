package mezzofy.com.libmzcoupon.data;


import java.util.List;

public class SiteListDataModel {
	private List<SiteDataModel> sites;
	
	private SizeDataModel size;

	public List<SiteDataModel> getSites() {
		return sites;
	}

	public void setSites(List<SiteDataModel> sites) {
		this.sites = sites;
	}

	public SizeDataModel getSize() {
		return size;
	}

	public void setSize(SizeDataModel size) {
		this.size = size;
	}
}