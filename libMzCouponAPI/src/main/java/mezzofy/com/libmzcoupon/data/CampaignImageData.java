package mezzofy.com.libmzcoupon.data;


import java.io.Serializable;


public class CampaignImageData implements Serializable {

    private String pimageId;
    private String campaignId;
    private String campaignImage;
    private Integer imageSeq;
    private String imageStatus;


    public Integer getImageSeq() {
        return imageSeq;
    }

    public void setImageSeq(Integer imageSeq) {
        this.imageSeq = imageSeq;
    }

    public String getImageStatus() {
        return imageStatus;
    }

    public void setImageStatus(String imageStatus) {
        this.imageStatus = imageStatus;
    }


    public String getPimageId() {
        return pimageId;
    }

    public void setPimageId(String pimageId) {
        this.pimageId = pimageId;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public String getCampaignImage() {
        return campaignImage;
    }

    public void setCampaignImage(String campaignImage) {
        this.campaignImage = campaignImage;
    }

}
