/*
 * Created by IntelliJ IDEA.
 * User: Nkem Ohanenye
 * Date: 11/10/17
 * Time: 5:06 PM
 */
package HelperFunctions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExistChecker {

    // The ReadAndWrite Functions
    private ReadAndWrite writer = new ReadAndWrite();
    private String fileName = writer.getFileName();
    private String write = writer.getWords();
    private String directory = writer.getDirectory();
    private String path = writer.getPath();

    //The File used
    private File file;

    //The buttons in the JOptionPane
    private JButton oW = new JButton("Overwrite");
    private JButton aO = new JButton("Add On");
    private JButton c = new JButton("Cancel");

    //The Dialog used to have the ability to close the pane rather than exiting the program
    private JDialog fileFoundDialog;

    public void writeGui(String fileName) throws FileNotFoundException, IOException{

        //Method Settings
        this.fileName = fileName;
        writer.create(fileName);
        directory = path + "/" + fileName + ".txt";
        file = new File(directory);

        //Frame Settings
        JFrame fileFoundFrame = new JFrame();
        fileFoundDialog = new JDialog(fileFoundFrame, "Confirm Overwrite of: " + fileName, true);

        //Main Button Settings
        oW.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    file.delete();
                } catch (Exception e) {

                }
                fileFoundDialog.dispose();
            }
        });
        aO.addActionListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                fileFoundDialog.dispose();

            }
        });
        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        //If A File Exists Settings
        if(writer.exist()){

            Object[] buttons = new Object[]{oW, aO, c};
            JOptionPane pane = new JOptionPane(
                    "The file already exists.",
                    JOptionPane.WARNING_MESSAGE,
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    null,
                    buttons,
                    buttons[0]);

            fileFoundDialog.getContentPane().add(pane);     //Allows the pane to be edited by the Dialog
            fileFoundDialog.setSize(405,120);
            fileFoundDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            fileFoundDialog.addWindowListener(new WindowAdapter() {     //Clicking x stops program
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
            fileFoundDialog.setLocationRelativeTo(fileFoundFrame);      //keeps frame in the middle of the screen
            fileFoundDialog.setVisible(true);

        }else{
            fileFoundDialog.dispose();
        }
    }

    /*
     * Does not have catcher yet to automatically detect if file is there
     * Works but will run even if the file is there
     * Removed rename function to get the file over with due to complications
     */

}