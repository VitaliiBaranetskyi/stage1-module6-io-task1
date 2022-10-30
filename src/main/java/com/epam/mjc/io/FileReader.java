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
        try (java.io.FileReader reader = new java.io.FileReader(file)) {
            while (reader.ready()) {
                char symbol = (char) reader.read();
                //if(symbol != '\r' && symbol != '\n' && symbol != ' ' && symbol != ':')
                result.append(symbol);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] split = result.toString().split("[ :\\n\\r]");
        Profile profile = new Profile();
        profile.setName(split[2]);
        try {
            profile.setAge(Integer.parseInt(split[6]));
        } catch (NumberFormatException numberFormatException) {
            profile.setAge(0);
        }
        profile.setEmail(split[10]);
        profile.setPhone(Long.parseLong(split[14]));
        return profile;
    }

    public static void main(String[] args) {
        FileReader reader = new FileReader();
        System.out.println(reader.getDataFromFile(new File("D:/MJCschool/stage1-module6-io-task1/src/main/resources/Profile.txt")));
    }
}
