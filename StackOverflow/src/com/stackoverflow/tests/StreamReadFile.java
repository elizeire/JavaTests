package com.stackoverflow.tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StreamReadFile {

	
	public static void main(String[] args) throws IOException {
		new StreamReadFile().viewLoad();
	}
	
	public String viewLoad() throws IOException {

		String userHome = new File("").getAbsolutePath();
        System.out.println ("reading file from userHome -> " + userHome);

        String content = null;

        try {

        content = 
                new String(Files.readAllBytes
                        (Paths.get(userHome + "/logs/nicinc/nicinc.log")));

        } catch (Exception e) {

            System.out.println ("Exception e -> " + e.getMessage());

        } finally {

            System.out.println ("content -> " + content);

        }

//      System.out.println ("content -> " + content);


        return content;//serverContextPath +  SYSTEM_LOG_VIEW;
}
}
