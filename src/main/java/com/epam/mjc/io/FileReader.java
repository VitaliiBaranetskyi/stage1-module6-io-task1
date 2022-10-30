package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;


public class FileReader {

    public Profile getDataFromFile(File file) {
        StringBuilder result = new StringBuilder();
        try(java.io.FileReader reader = new java.io.FileReader(file)){
            while (reader.ready()){
                char symbol = (char) reader.read();
                //if(symbol != '\r' && symbol != '\n' && symbol != ' ' && symbol != ':')
                    result.append(symbol);
                //System.out.println(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(result);
        //result = new StringBuilder(result.toString().replaceAll("[\r\n:]", ""));
        String[] split = result.toString().split("[ :\\n\\r]");
        System.out.println(Arrays.toString(split));
        return new Profile(split[2], Integer.parseInt(split[6]), split[10], Long.parseLong(split[14]));
    }

    public static void main(String[] args) {
        FileReader reader = new FileReader();
        System.out.println(reader.getDataFromFile(new File("D:/MJCschool/stage1-module6-io-task1/src/main/resources/Profile.txt")));
    }
}
