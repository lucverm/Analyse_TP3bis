package utils;

import controller.IMainController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SelectService {

    private IMainController controller;

    @FXML
    private Label dateService;

    @FXML
    private Label nameProvider;

    @FXML
    private Label activityService;

    @FXML
    private Label durationService;

    @FXML
    private Label nameCompany;

    @FXML
    private Label status;

    public SelectService(IMainController controller, Label dateService, Label nameProvider,Label nameCompany, Label activityService, Label durationService, Label status) {
        this.controller = controller;
        this.dateService = dateService;
        this.nameProvider = nameProvider;
        this.activityService = activityService;
        this.durationService = durationService;
        this.nameCompany = nameCompany;
        this.status =status;
    }

    public void setLabelServiceCurrent(int index){
        setActivityService(index);
        setDateService(index);
        setDurationService(index);
        setNameProvider(index);
        setNameCompany(index);
        setStatus(index);
    }

    private void setDateService(int index){
        this.dateService.setText(controller.getListService().get(index).getDate());
    }

    private void setNameProvider(int index){
        this.nameProvider.setText(controller.getListService().get(index).getNameProvider());
    }

    private void setActivityService(int index){
        this.activityService.setText(controller.getListService().get(index).getActivity());
    }

    private void setDurationService(int index){
        this.durationService.setText(controller.getListService().get(index).getDuration()+ "h00");
    }

    private void setNameCompany(int index){
        this.nameCompany.setText(controller.getListService().get(index).getNameCompany());
    }

    private void setStatus(int index){
        if(controller.getListService().get(index).getStatus().equals(controller.getListService().get(index).getDuration() + " titres prélevés")){
            this.status.setText("Confirmé !");
        }else{
            this.status.setText(controller.getListService().get(index).getStatus()+ " !");
        }
    }
}
