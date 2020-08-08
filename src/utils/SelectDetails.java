package utils;

import controller.IMainController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SelectDetails {

    private IMainController controller;

    @FXML
    private Label quantity;

    @FXML
    private Label format;

    @FXML
    private Label paymentDate;

    @FXML
    private Label paymentDate2;

    @FXML
    private Label paymentMode;

    @FXML
    private Label idOrder;

    @FXML
    private Label nbrTS;

    @FXML
    private Label nbrTSReceived;

    @FXML
    private Label totalTS;

    @FXML
    private Label priceTS;

    public SelectDetails(IMainController controller, Label quantity, Label format, Label paymentDate,Label paymentDate2, Label paymentMode, Label idOrder, Label nbrTS,Label nbrTSReceived, Label totalTS, Label priceTS) {
        this.controller = controller;
        this.quantity = quantity;
        this.format = format;
        this.paymentDate = paymentDate;
        this.paymentDate2 = paymentDate2;
        this.paymentMode = paymentMode;
        this.idOrder = idOrder;
        this.nbrTS = nbrTS;
        this.nbrTSReceived = nbrTSReceived;
        this.totalTS = totalTS;
        this.priceTS = priceTS;
    }

    public void setDataDetails(int index) {
        setQuantity(index);
        setFormat(index);
        setIdOrder(index);
        setNbrTS(index);
        setNbrTSReceived(index);
        setPaymentDate(index);
        setPaymentDate2(index);
        setTotalTS(index);
        setPaymentMode(index);
        setPriceTS();
    }

    private void setQuantity(int index) {
        this.quantity.setText(String.valueOf(controller.getListOrder().get(index).getQuantityTS()));
    }

    private void setFormat(int index) {
       this.format.setText(controller.getListOrder().get(index).getFormat());
    }

    private void setPaymentDate(int index) {
        this.paymentDate.setText(controller.getListOrder().get(index).getDatePayment());
    }

    private void setPaymentDate2(int index) {
        this.paymentDate2.setText(controller.getListOrder().get(index).getDatePayment());
    }

    private void setPaymentMode(int index) {
        this.paymentMode.setText(controller.getListOrder().get(index).getPaymentMode());
    }

    private void setIdOrder(int id) {
        this.idOrder.setText(String.valueOf(controller.getListOrder().get(id).getId()));
    }

    private void setNbrTS(int index) {
        this.nbrTS.setText(String.valueOf(controller.getListOrder().get(index).getQuantityTS()));
    }

    private void setNbrTSReceived(int index) {
        this.nbrTSReceived.setText(String.valueOf(controller.getListOrder().get(index).getQuantityTS()));
    }

    private void setTotalTS(int index) {
        this.totalTS.setText(String.valueOf(controller.getListOrder().get(index).getQuantityTS()*9));
    }

    private void setPriceTS() {
        this.priceTS.setText("9.00");
    }
}
