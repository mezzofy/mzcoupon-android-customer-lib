package mezzofy.com.libmzcoupon.data;

import java.util.List;

/**
 * Created by aruna on 6/29/17.
 */

public class PaymentListDataModel {
    private List<PaymentDataModel> payments;
    private List<PaymentDetailDataModel> paymentdetails;
    private SizeDataModel size;

    public List<PaymentDataModel> getPayments() {
        return payments;
    }

    public void setPayments(List<PaymentDataModel> payments) {
        this.payments = payments;
    }

    public List<PaymentDetailDataModel> getPaymentdetails() {
        return paymentdetails;
    }

    public void setPaymentdetails(List<PaymentDetailDataModel> paymentdetails) {
        this.paymentdetails = paymentdetails;
    }

    public SizeDataModel getSize() {
        return size;
    }

    public void setSize(SizeDataModel size) {
        this.size = size;
    }
}
