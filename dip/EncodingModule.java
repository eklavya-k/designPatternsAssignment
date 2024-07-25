package net.media.training.live.dip;


import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 13, 2011
 * Time: 10:05:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class EncodingModule {
    Encode driver;
    public EncodingModule(){
        driver = new Encode();
    }

    public void readFromFileWriteToFile() throws IOException{
        String inputString = this.driver.fileRead();
        this.driver.fileWrite(inputString);
    }

    public void readFromFileWriteToDatabase() throws IOException{
        String inputString = this.driver.fileRead();
        this.driver.databaseWrite(inputString);
    }

    public void readFromFileWriteToUrl() throws IOException{
        String inputString = this.driver.fileRead();
        this.driver.urlWrite(inputString);
    }

    public void readFromUrlWriteToDatabase() throws IOException{
        String inputString = this.driver.urlRead();
        this.driver.databaseWrite(inputString);
    }

    public void readFromUrlWriteToFile() throws IOException{
        String inputString = this.driver.urlRead();
        this.driver.fileWrite(inputString);;
    }

    public void readFromUrlWriteToUrl() throws IOException{
        String inputString = this.driver.urlRead();
        this.driver.urlWrite(inputString);
    }

    public void readFromDatabaseWriteToDatabase() throws IOException{
        String inputString = this.driver.databaseRead();
        this.driver.databaseWrite(inputString);
    }

    public void readFromDatabaseReadWriteToUrl() throws IOException{
        String inputString = this.driver.databaseRead();
        this.driver.urlWrite(inputString);;
    }

    public void readFromDatabaseWriteToFile() throws IOException{
        String inputString = this.driver.databaseRead();
        this.driver.fileWrite(inputString);
    }
}

