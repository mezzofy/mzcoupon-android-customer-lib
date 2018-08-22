package mezzofy.com.libmzcoupon.data;


/**
 * Created by Aruna on 28/03/17.
 */

public class PoDetailData {
    private String podtlId;
    private String productId;
    private String campaignId;
    private String poId;
    private String campaignName;
    private String campaignPrice;
    private String campaignQty;
    private String campaignTotal;
    private String status;
    private String updatedOn;

    public String getCampaignPrice() {
        return campaignPrice;
    }

    public void setCampaignPrice(String campaignPrice) {
        this.campaignPrice = campaignPrice;
    }

    public String getCampaignQty() {
        return campaignQty;
    }

    public void setCampaignQty(String campaignQty) {
        this.campaignQty = campaignQty;
    }

    public String getCampaignTotal() {
        return campaignTotal;
    }

    public void setCampaignTotal(String campaignTotal) {
        this.campaignTotal = campaignTotal;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }
    public String getPodtlId() {
        return podtlId;
    }

    public void setPodtlId(String podtlId) {
        this.podtlId = podtlId;
    }

    public String getPoId() {
        return poId;
    }

    public void setPoId(String poId) {
        this.poId = poId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
