package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            while (reader.ready()) {
                result.append(reader.readLine().replace(": ", " ")).append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] split = result.toString().split(" ");
        Profile profile = new Profile();
        profile.setName(split[1]);
        profile.setAge(Integer.parseInt(split[3]));
        profile.setEmail(split[5]);
        profile.setPhone(Long.parseLong(split[7]));
        return profile;
    }
}
