package GUI;

import ServoBlaster.MainServoBlaster;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Hashtable;

public class ServoBlasterSliderGUI extends JFrame {

    protected JSlider servoSlider;

    private JPanel mainPanel;

    private Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();

    protected int minMicroSec = 900;
    protected int maxMicroSec = 2000;

    public ServoBlasterSliderGUI(){
        setTitle("ServoSliderTest");
        setSize(500,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        buildGUI();
        add(mainPanel);
        //pack();
        setVisible(true);

    }
    public void buildGUI(){
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1,1));
        servoSlider = new JSlider(minMicroSec, maxMicroSec);

        labelTable.put(new Integer(900), new JLabel("OFF"));
        labelTable.put(new Integer(1000), new JLabel("1.0"));
        labelTable.put(new Integer(1100), new JLabel("1.1"));
        labelTable.put(new Integer(1200), new JLabel("1.2"));
        labelTable.put(new Integer(1300), new JLabel("1.3"));
        labelTable.put(new Integer(1400), new JLabel("1.4"));
        labelTable.put(new Integer(1500), new JLabel("1.5"));
        labelTable.put(new Integer(1600), new JLabel("1.6"));
        labelTable.put(new Integer(1700), new JLabel("1.7"));
        labelTable.put(new Integer(1800), new JLabel("1.8"));
        labelTable.put(new Integer(1900), new JLabel("1.9"));
        labelTable.put(new Integer(2000), new JLabel("2.0"));

        servoSlider.setOrientation(JSlider.VERTICAL);
        servoSlider.setMajorTickSpacing(100);
        servoSlider.setMinorTickSpacing(50);
        servoSlider.setSnapToTicks(true);
        servoSlider.setValue(minMicroSec);
        servoSlider.setPaintTicks(true);
        servoSlider.setLabelTable(labelTable);
        servoSlider.setPaintLabels(true);

        mainPanel.add(servoSlider);
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        /*ServoBlasterSliderGUI slider = new ServoBlasterSliderGUI();

        MainServoBlaster servoBlaster = new MainServoBlaster();
        servoBlaster.startServoBlaster();

        while (true) {
            servoBlaster.setSliderValue(slider.servoSlider.getValue());
        }*/
        new ServoBlasterSliderGUI();
    }
}