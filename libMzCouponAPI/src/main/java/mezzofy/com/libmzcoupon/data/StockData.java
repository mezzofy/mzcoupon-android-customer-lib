package mezzofy.com.libmzcoupon.data;

/**
 * Created by aruna on 9/20/17.
 */

public class StockData {
    private String campaignId;
    private String stockId;
    private int stockqty;

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public int getStockqty() {
        return stockqty;
    }

    public void setStockqty(int stockqty) {
        this.stockqty = stockqty;
    }
}
