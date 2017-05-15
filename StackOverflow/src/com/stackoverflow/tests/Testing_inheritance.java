package com.stackoverflow.tests;

import java.io.*;

public class Testing_inheritance extends Phone
{
    public static void main (String args[])throws IOException
    {   
    	Phone xy=new Phone();
        int y= xy.getx();
        y+=10;
        System.out.println("The value of x is " +y);
    }
}

