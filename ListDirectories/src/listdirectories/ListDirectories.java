package listdirectories;

import java.io.File;
import java.util.List;

public class ListDirectories {

    public static void main(String[] args) {
        TraverseDirectories directories = new TraverseDirectories();
        List<File> files;
        
        files = directories.listDuplicatingFiles("C:\\Downloads\\TestFolder");
        
        System.out.println("\nThe unique files are:");
        for (File element : files) {
            System.out.println(element.getName());
        }
    }
}
