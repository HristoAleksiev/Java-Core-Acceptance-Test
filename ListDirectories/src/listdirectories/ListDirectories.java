package listdirectories;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class ListDirectories {

    public static void main(String[] args) throws FileNotFoundException {
        TraverseDirectories directories = new TraverseDirectories();
        List<File> files;
        
        files = directories.listDuplicatingFiles("C:\\Downloads\\TestFolder");
        
        System.out.println("\nThe unique files are:");
        for (File element : files) {
            System.out.println(element.getName());
        }
    }
}
