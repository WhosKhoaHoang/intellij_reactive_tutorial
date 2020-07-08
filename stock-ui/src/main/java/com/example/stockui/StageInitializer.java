package com.example.stockui;

import com.example.stockui.ChartApplication.StageReadyEvent;
import javafx.stage.Stage;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent> {

  @Override
  public void onApplicationEvent(StageReadyEvent event) {
    Stage stage = event.getStage();
  }
}
