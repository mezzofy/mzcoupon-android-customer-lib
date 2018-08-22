package mezzofy.com.libmzcoupon.data;



import java.util.List;


public class PomData {
    private PoData po;
    private List<PoDetailDataModel> podetails;

    public PoData getPo() {
        return po;
    }

    public void setPo(PoData po) {
        this.po = po;
    }

    public List<PoDetailDataModel> getPodetails() {
        return podetails;
    }

    public void setPodetails(List<PoDetailDataModel> podetails) {
        this.podetails = podetails;
    }
}
