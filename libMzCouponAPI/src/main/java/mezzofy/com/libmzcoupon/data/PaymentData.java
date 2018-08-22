package mezzofy.com.libmzcoupon.data;


import java.util.List;

/**
 * Created by aruna on 6/29/17.
 */

public class PaymentData {
    private String paymentId;
    private String paymentType;
    private String paymentEnviornment;
    private String paymentStatus;

    List<PaymentDetailDataModel> paymentdetails;


    public List<PaymentDetailDataModel> getPaymentdetails() {
        return paymentdetails;
    }

    public void setPaymentdetails(List<PaymentDetailDataModel> paymentdetails) {
        this.paymentdetails = paymentdetails;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentEnviornment() {
        return paymentEnviornment;
    }

    public void setPaymentEnviornment(String paymentEnviornment) {
        this.paymentEnviornment = paymentEnviornment;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
