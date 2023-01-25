package title6.multithreading.career.presentation;

import javax.swing.*;
import java.awt.*;

public class NorthPane {

  public static JPanel build(JProgressBar progressBarOne,
                             JProgressBar progressBarTwo,
                             JProgressBar progressBarThree,
                             JProgressBar progressBarFour) {
    JPanel p = new JPanel();
    p.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();

    //Defino barra de progreso 1
    progressBarOne.setValue(0);
    progressBarOne.setStringPainted(true);

    gbc.gridx=0;
    gbc.gridy=0;
    gbc.gridwidth=1;
    gbc.gridheight=1;
    gbc.weighty=1.0;
    gbc.weightx=1.0;
    gbc.fill=GridBagConstraints.HORIZONTAL;

    p.add(progressBarOne, gbc);
    gbc.weighty=0.0;
    gbc.weightx=0.0;

    //Defino barra de progreso 2
    progressBarTwo.setValue(0);
    progressBarTwo.setStringPainted(true);
    gbc.gridx=0;
    gbc.gridy=1;
    gbc.gridwidth=1;
    gbc.gridheight=1;
    gbc.weighty=1.0;
    gbc.fill=GridBagConstraints.HORIZONTAL;

    p.add(progressBarTwo, gbc);
    gbc.weighty=0.0;

    //Defino barra de progreso 3
    progressBarThree.setValue(0);
    progressBarThree.setStringPainted(true);
    gbc.gridx=0;
    gbc.gridy=2;
    gbc.gridwidth=1;
    gbc.gridheight=1;
    gbc.weighty=1.0;
    gbc.fill=GridBagConstraints.HORIZONTAL;

    p.add(progressBarThree, gbc);
    gbc.weighty=0.0;

    //Defino barra de progreso 4
    progressBarFour.setValue(0);
    progressBarFour.setStringPainted(true);
    gbc.gridx=0;
    gbc.gridy=3;
    gbc.gridwidth=1;
    gbc.gridheight=1;
    gbc.weighty=1.0;
    gbc.fill=GridBagConstraints.HORIZONTAL;

    p.add(progressBarFour, gbc);
    gbc.weighty=0.0;

    return p;
  }
}
