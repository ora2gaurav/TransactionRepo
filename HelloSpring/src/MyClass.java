import java.nio.file.*;
 import java.io.*;
 import static java.nio.file.FileVisitResult.*;
 import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
 
 public class MyClass {
    public static void main(String[] args) {
       String a = "/Java Code/Temp1/";
       Path path1 = FileSystems.getDefault().getPath(a);
       Visitor vis = new Visitor();

       try {
          Files.walkFileTree(path1, vis);
       } catch (IOException e) {
          System.out.println("error: " + e.toString());
       }
    }
 }
 
 class Visitor extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult postVisitDirectory(Path p, IOException e) throws IOException {
       System.out.println(p);
       return CONTINUE;
    }
    
    
 }