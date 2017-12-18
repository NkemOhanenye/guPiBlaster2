/*
 * Created by IntelliJ IDEA.
 * User: Nkem Ohanenye
 * Date: 11/3/17
 * Time: 5:21 PM
 */
package HelperFunctions;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadAndWrite {

    private String directory;
    private String path ="src/DataOutput/";
    private String words;
    private String fileName;
    private String fileType = ".txt";
    private File file;
    private FileOutputStream fos;
    private Boolean dupe = true;
    private ArrayList<Double> arry;

    public void create(String fileName)
            throws FileNotFoundException, IOException {

        directory = path + "/" + fileName + fileType;
        file = new File(directory);
        this.fileName = fileName;
        fileName = this.fileName;
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public boolean exist(){
        return file.exists();
    }

    public void write(String words) throws FileNotFoundException, IOException{

        fos = new FileOutputStream(file, dupe);
        PrintStream MakeWriter = new PrintStream(fos);
        MakeWriter.println(words);
        this.words = words;
        MakeWriter.close();
        fos.close();

    }

    public ArrayList<Double> read() throws FileNotFoundException{
        arry = new ArrayList<Double>();
        Scanner scnr = new Scanner(new File(directory));
        while(scnr.hasNextLine()){
            String line = scnr.nextLine();
            String[] splitStr = line.split(",");
            for (String num : splitStr) {
                arry.add(Double.parseDouble(num));
            }
        }
        return arry;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public String getDirectory() {
        return directory;
    }

    public String getWords() {
        return words;
    }

    public String getPath() {
        return path;
    }

}



/*
 * Requires the user to throw a FileNotFoundException and IOException
 * within the file using the function.
 */