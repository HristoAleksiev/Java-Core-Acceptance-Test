package listdirectories;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TraverseDirectories {
    private final List<File> uniqueFiles = new ArrayList<>();
    private File root;
    
    public List listDuplicatingFiles(String dir){
        root = new File(dir);
        
        if (root.isDirectory()) {
            addFiles(root, root.listFiles());
        }
        
        return uniqueFiles;
    }
    
    private void addFiles(File parent, File[] parentFiles){
        for (File parentFile : parentFiles) {
            if (parentFile.isDirectory()) {
                addFiles(new File(parentFile.getPath()), parentFile.listFiles());
            } else {
                if (isFileContentUnique(parentFile)) {
                    uniqueFiles.add(parentFile);
                }
            }
        }
    }
    
    private String readFile(File file){
        FileInputStream fileInput;
        StringBuilder builder = new StringBuilder();
        byte[] buffer = new byte[1000];
        
        try{
            fileInput = new FileInputStream(file);
            int read = 0;
            
            while((read = fileInput.read(buffer)) != -1){
                builder.append(read);
            }
            fileInput.close();
        }
        catch(FileNotFoundException nf){
            System.out.println("The file was not found: " + file);
        }
        catch(IOException io){
            System.out.println("File could not be read: " + file);
        }
        
        return builder.toString();
    }
    
    private boolean compareFiles(File file, File fileTwo){
        
        // Thought it was better to see what is happening when the 
        //  program is running
        System.out.println("Comparing: \n \"" + file.getName() + 
                "\" and \"" + fileTwo.getName() + "\"");
        
        return (readFile(file).compareTo(readFile(fileTwo)) == 0);
    }
    
    private boolean isFileContentUnique(File file){
        for (File uniqueFile : uniqueFiles) {
            if (compareFiles(file, uniqueFile)) {
                return false;
            }
        }
        return true;
    }
}