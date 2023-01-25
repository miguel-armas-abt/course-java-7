package title6.multithreading.career.presentation;

import javax.swing.*;
import java.awt.*;

public class SouthPane {

  public static JPanel build(JLabel labelMessage, JButton startButton) {
    JPanel p = new JPanel();
    p.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();

    //Defino label
    gbc.gridx=0;
    gbc.gridy=0;
    gbc.gridwidth=1;
    gbc.gridheight=1;
    gbc.weighty=1.0;

    p.add(labelMessage, gbc);
    gbc.weighty=0.0;

    //Defino botón
    gbc.gridx=0;
    gbc.gridy=1;
    gbc.gridwidth=1;
    gbc.gridheight=1;
    gbc.weighty=1.0;

    p.add(startButton, gbc);
    gbc.weighty=0.0;

    return p;
  }

}
