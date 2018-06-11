package reformat;/*
 *  How to use WEKA API in Java
 *  Copyright (C) 2014
 *  @author Dr Noureddin M. Sadawi (noureddin.sadawi@gmail.com)
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it as you wish ...
 *  I ask you only, as a professional courtesy, to cite my name, web page
 *  and my YouTube Channel!
 *
 */

//import required classes

import java.io.*;

public class ReformatARFF {

    public static void main(String[] args) throws Exception {

        try {

            File file = new File("D:\\gagan.gupta\\IntellijIdeaProjects\\MachineLearningData\\train.arff");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer mainStringBuffer = new StringBuffer();
            String line;

            while ((line = bufferedReader.readLine()) != null) {

                StringBuffer stringBuffer = new StringBuffer();
                String[] splitted = line.split(",");

                    for (String string : splitted) {

                        if (splitted.length > 1) {
                            if (string.contains(" ")) {
                                string = string.replaceAll(" ", ".");
                            }
                        }
                        if (stringBuffer.length() == 0) {
                            stringBuffer.append(string);
                        } else {
                            stringBuffer.append("," + string);
                        }
                    }

                if (splitted.length < 13 && splitted.length > 1){
                    stringBuffer.append("Empty");
                }

               if (stringBuffer.toString().contains("\"\"")){
                   stringBuffer = new StringBuffer(stringBuffer.toString().replaceAll("\"\"", ""));
               }

                mainStringBuffer.append(stringBuffer);
                mainStringBuffer.append("\n");
            }

            fileReader.close();

            PrintWriter writer = new PrintWriter("D:\\gagan.gupta\\IntellijIdeaProjects\\MachineLearningData\\trainNew.arff", "UTF-8");
            writer.println(mainStringBuffer.toString());
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
