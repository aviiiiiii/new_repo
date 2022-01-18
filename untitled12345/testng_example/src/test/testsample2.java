package test;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;

public class testsample2 {
    @Test
    public void class1(){
        System.out.println("class1");
    }

    @Test
    public void class2() throws IOException {
        System.out.println("class2");
        Properties prop=new Properties();
        FileInputStream fis=new FileInputStream("I:\\IntelliJ Projects\\untitled12345\\testng_example\\test.properties");
        prop.load(fis);
        String browser=prop.getProperty("browser");
        prop.setProperty("browser","Firefox");
        FileOutputStream fos=new FileOutputStream("I:\\IntelliJ Projects\\untitled12345\\testng_example\\test.properties");
        prop.store(fos,null);
    }

    @Test
    public void test12(){
        UUID randomUUID = UUID.randomUUID();
        String rand=randomUUID.toString().replaceAll("-", "").substring(0,8);
        System.out.println(rand);
    }

    @Test
    public void test13(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date()); // Use today date
        c.add(Calendar.DATE, 50); // Adding 14 days which is two weeks from the current date
        String output = sdf.format(c.getTime());
        System.out.println(output);
    }

    @Test
    public void test14(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date()); // Use today date
        c.add(Calendar.DATE, 50); // Adding 14 days which is two weeks from the current date
        String output = sdf.format(c.getTime());
        System.out.println(output);
    }
}
