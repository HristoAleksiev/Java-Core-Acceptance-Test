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
    
    public List<File> listDuplicatingFiles(String dir) throws FileNotFoundException{
        root = new File(dir);
        
        if (root.exists()) {
            addFiles(root.listFiles());
        }
        else{
            throw new FileNotFoundException("The directory was not found!");
        }
        
        return uniqueFiles;
    }
    
    private void addFiles(File[] children){
        for (File child : children) {
            if (child.isDirectory()) {
                addFiles(child.listFiles());
            } else {
                if (isFileContentUnique(child)) {
                    uniqueFiles.add(child);
                }
            }
        }
    }
    
    private boolean isFileContentUnique(File file){
        for (File uniqueFile : uniqueFiles) {
            if (compareFiles(file, uniqueFile)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean compareFiles(File file, File fileTwo){
        
        // Thought it was better to see what is happening when the 
        //  program is running
        System.out.println("Comparing: \n \"" + file.getName() + 
                "\" and \"" + fileTwo.getName() + "\"");
        
        return (readFile(file).compareTo(readFile(fileTwo)) == 0);
    }
    
    private String readFile(File file){
        FileInputStream fileInput;
        StringBuilder builder = new StringBuilder();
        byte[] buffer = new byte[1000];
        
        try{
            fileInput = new FileInputStream(file);
            int read;
            
            while((read = fileInput.read(buffer)) != -1){
                builder.append(read);
            }
            fileInput.close();
        }
        catch(FileNotFoundException notFound){
            System.out.println("The file was not found: " + file);
        }
        catch(IOException IO){
            System.out.println("File could not be read: " + file);
        }
        
        return builder.toString();
    }
}