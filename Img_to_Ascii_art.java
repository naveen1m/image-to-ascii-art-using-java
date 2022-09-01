package com.codex.fxproject;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Img_to_Ascii_art {
    public static String ascii(double pix){
        String str = " ";
        if (pix >= 240) {
            str = " ";
        } else if (pix >= 210) {
            str = ".";
        } else if (pix >= 190) {
            str = "*";
        } else if (pix >= 170) {
            str = "+";
        } else if (pix >= 120) {
            str = "^";
        } else if (pix >= 110) {
            str = "&";
        } else if (pix >= 80) {
            str = "8";
        } else if (pix >= 60) {
            str = "#";
        } else {
            str = "@";
        }
        return str;
    }
    public static void main(String[] args) throws IOException {
        //inserting image file
        int width = 40;
        int height = 60;
        BufferedImage image =null;
        try {
            File fin = new File("D:/IO/penguin1.png");
          image = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
            image = ImageIO.read(fin);
            System.out.println("Reading complete");
        }catch(IOException e){
            System.out.println("Error : " + e);
        }

        //file creating to store ascii art
        PrintWriter printWriter = new PrintWriter("D:/IO/ascii_art_penguin1.txt");

        double pixval = 0;
        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                Color pixcol = new Color(image.getRGB(j, i));
                pixval = (((pixcol.getRed()) + (pixcol.getBlue()) + (pixcol
                        .getGreen()))/3.0);
                printWriter.print(ascii(pixval));
            }

        }
    }
}
