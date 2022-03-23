package Util;
import java.io.*;

public class Reader {

    static final int USER_NAME = 0;
    static final int USER_GEN = 1;
    static final int USER_AGE = 2;
    static final int USER_WEIGHT = 3;
    static final int USER_HEIGHT = 4;

    public static String[] reader(File userInfo) throws FileNotFoundException {

        FileReader file_reader = new FileReader(userInfo);
        BufferedReader b_reader = new BufferedReader(file_reader);











        return null;
    }



}
