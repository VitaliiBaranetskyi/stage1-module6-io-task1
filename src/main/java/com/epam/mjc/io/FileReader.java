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
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            while (reader.ready()) {
                //char symbol = (char) reader.read();
                //if (symbol == '\r' || symbol == '\n' || symbol == ':')
                //    result.append(",");
                //else if(symbol != ' ')
                result.append(reader.readLine().replaceAll(": ", " ")).append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(result);
        String[] split = result.toString().split(" ");
        Profile profile = new Profile();
        profile.setName(split[1]);
        try {
            profile.setAge(Integer.valueOf(split[3]));
        } catch (NumberFormatException numberFormatException) {
            profile.setAge(0);
        }
        profile.setEmail(split[5]);
        profile.setPhone(Long.parseLong(split[7]));
        return profile;
    }

    public static void main(String[] args) {
        FileReader reader = new FileReader();
        System.out.println(reader.getDataFromFile(new File("D:/MJCschool/stage1-module6-io-task1/src/main/resources/Profile.txt")));
    }
}
