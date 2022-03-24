/**
 * A fitness tracking program that allows the user to input their information and get back various results form that
 * *Members:
 * Fabiha Fairuzz Subha (UCID: 30148674)
 * Amasil Rahim Zihad (UCID: 30164830)
 * * Date: 1 March 2022
 * * Demo 2 Tutorial 05
 */
package Util;

import Main.User;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    public static void writer(String[] out_info, File fileOutput) throws IOException{

        if(fileOutput.exists() && fileOutput.canWrite()){
            try{
                FileWriter f_writer = new FileWriter(fileOutput);
                BufferedWriter b_writer = new BufferedWriter(f_writer);

                for (int i = 0; i < out_info.length; i++){
                    b_writer.write(i + "\n");
                }
                b_writer.flush();
            } catch (IOException e) {
                System.err.println("Cannot access the file to write it!");
            }
        } else {
            System.err.println("Cannot access the file to write it!");
            System.exit(1);
        }
    }
}
