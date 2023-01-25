package title6.multithreading.career.presentation;

/**
 * Observador.
 */
import title6.multithreading.career.model.Car;
import title6.multithreading.career.model.SubjectCar;

import java.awt.Container;
    import java.awt.GridBagConstraints;
    import java.awt.GridBagLayout;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.util.Observable;
    import java.util.Observer;
    import javax.swing.JButton;
    import javax.swing.JFrame;
    import javax.swing.JLabel;
    import javax.swing.JPanel;
    import javax.swing.JProgressBar;

public class CareerPresentation extends JFrame implements Observer {

  private JProgressBar progressBarOne, progressBarTwo, progressBarThree, progressBarFour;
  private JLabel labelMessage;
  private JButton startButton;

  private Thread[] carThreads; // objetos observables

  CareerPresentation observer;

  public CareerPresentation(){
    super("Carrera de carros.");
    carThreads = new Thread[4];
    observer = this;

    Container container = getContentPane();
    container.setLayout(new GridBagLayout());
    GridBagConstraints grid = new GridBagConstraints();

    progressBarOne = new JProgressBar(0, 100);
    progressBarTwo =new JProgressBar(0, 100);
    progressBarThree =new JProgressBar(0, 100);
    progressBarFour =new JProgressBar(0, 100);
    JPanel northPane = NorthPane.build(progressBarOne, progressBarTwo, progressBarThree, progressBarFour); // defino panel norte
    grid.gridx = 0;
    grid.gridy = 0;
    grid.gridheight = 1;
    grid.gridwidth = 1;
    grid.weightx = 1.0;
    grid.weighty = 1.0;
    grid.fill = GridBagConstraints.HORIZONTAL;

    container.add(northPane, grid);
    grid.weightx = 0.0;
    grid.weighty = 0.0;

    labelMessage = new JLabel("Caballo ganador...");
    startButton = new JButton("Iniciar");
    JPanel southPane = SouthPane.build(labelMessage, startButton); // defino panel sur
    grid.gridx=0;
    grid.gridy=1;

    container.add(southPane, grid);
    startButton.addActionListener(new ListenButton());

    setSize(300, 300);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  @Override
  public void update(Observable observable, Object arg){

    SubjectCar subjectCar = (SubjectCar) observable;
    int percentage = (int) arg;
    
    switch(subjectCar.getCar().getName()){
      case "1-car":
        progressBarOne.setValue(percentage);
        break;
      case "2-car":
        progressBarTwo.setValue(percentage);
        break;
      case "3-car":
        progressBarThree.setValue(percentage);
        break;
      case "4-car":
        progressBarFour.setValue(percentage);
    }

    if(percentage > 100){
      finishCareer();
      startButton.setEnabled(true);
      labelMessage.setText("Coche ganador: " + subjectCar.getCar().getName());
    }
  }

  public void finishCareer(){
    for(int i = 0; i< carThreads.length; i++)
      carThreads[i].interrupt();
  }

  class ListenButton implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e){

      startButton.setEnabled(false);
      labelMessage.setText("");

      for(int i = 0; i < carThreads.length; i++){
        Car car = new Car((i+1) + "-car", 0);
        SubjectCar subject = new SubjectCar(car);
        subject.addObserver(observer);
        carThreads[i] = new Thread(subject);
        carThreads[i].start();
      }
    }
  }

}