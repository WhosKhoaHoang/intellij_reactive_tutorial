package com.example.stockui;

import com.example.stockui.ChartApplication.StageReadyEvent;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;


@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent> {

  @Value("classpath:/chart.fxml")
  private Resource chartResource;
  private String applicationTitle;
  private ApplicationContext applicationContext;


  public StageInitializer(@Value("${spring.application.ui.title}") String applicationTitle,
      ApplicationContext applicationContext) {
    this.applicationTitle = applicationTitle;
    this.applicationContext = applicationContext;
  }


  @Override
  public void onApplicationEvent(StageReadyEvent event) {
    try {
      FXMLLoader fxmlloader = new FXMLLoader(chartResource.getURL());
      fxmlloader.setControllerFactory(aClass -> applicationContext.getBean(aClass));
      Parent parent = fxmlloader.load();

      Stage stage = event.getStage();
      stage.setScene(new Scene(parent, 800, 600));
      stage.setTitle(applicationTitle);
      stage.show();
    } catch (IOException e) {
      // Throwing an exception like this is not a useful way
      // of dealing with exceptions in production code! This
      // was done for simplicity.
      throw new RuntimeException();
    }
  }
}
