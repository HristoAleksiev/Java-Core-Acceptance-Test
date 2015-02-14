package listdirectories;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TraverseDirectories {
    public List<File> files = new ArrayList<>();
    public File root;
    public FileInputStream fileInput;
    
    public String fileContentOne = "";
    public String fileContentTwo = "";
    public StringBuilder builder = new StringBuilder();
    
    public void listDuplicatingFiles(String dir){  
        root = new File(dir);
        
        if (root.isDirectory()) {
            AddFiles(root, root.listFiles());
        }
    }
    
    public boolean compareFiles(File file, File fileTwo){
        try{
            
            byte[] bytes = new byte[1000];
            byte[] bytesTwo = new byte[1000];
            
            int read = 0;
            int total = 0;
            
            fileInput = new FileInputStream(file);

            while((read = fileInput.read(bytes)) != -1){
                
                for (byte element : bytes) {
                    builder.append(element);
                }
                total += read;
            }
            fileContentOne = builder.toString();
            
            // fileInput.close();
            // System.out.println(fileContentOne);
            // System.out.println("Read " + total + " bytes!");
        
            builder = new StringBuilder();
            bytes = new byte[1000];
            read = 0;
            total = 0;
            fileInput = new FileInputStream(fileTwo);
            
            while((read = fileInput.read(bytes)) != -1){
                
                for (byte element : bytes) {
                    builder.append(element);
                }
                total += read;
            }
            
            fileContentTwo = builder.toString();
            
            builder = new StringBuilder();
            
            fileInput.close();
            //System.out.println("Read " + total + " bytes!");
            
            //System.out.println(fileContentOne.equals(fileContentTwo));
            
            //System.out.println(fileContentOne);
            //System.out.println(fileContentTwo);
        }
        catch(FileNotFoundException nf){
            System.out.println("The file was not found: " + file);
        }
        catch(IOException io){
            System.out.println("File could not be read: " + file);
        }
        
        return fileContentOne.equals(fileContentTwo);
    }
    
    /*
    public void readFile(File file){
        try{
            
            byte[] bytes = new byte[1000];

            fileInput = new FileInputStream(file);

        }
        catch(FileNotFoundException nf){
            System.out.println("The file was not found" + file);
        }
        catch(IOException io){
            System.out.println("File could not be read" + file);
        }
        
    }
    */
    
    public boolean isUnique(File file){
        for (int j = 0; j < files.size(); j++) {
            if (compareFiles(file, files.get(j)) == true) {
               //readFile(root);
                return false;
            }
        }
        return true;
    }
    
    public void AddFiles(File parent, File[] parentFiles){
        for (int i = 0; i < parentFiles.length; i++) {
            
            System.out.println(parentFiles[i]);
            
            //  checks if the file is unique
            
            
            //  If the file is unique it's added to the collection
            
            
            //  If the file is directory - traverse its files
            if (parentFiles[i].isDirectory()) {
                AddFiles(new File(parentFiles[i].getPath()),
                        parentFiles[i].listFiles());
            }
            else{
                if (isUnique(parentFiles[i])) {
                    files.add(parentFiles[i]);
                }
            }
        }
    }
}
