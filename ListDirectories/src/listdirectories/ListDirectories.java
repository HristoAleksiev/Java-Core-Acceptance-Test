package listdirectories;

import java.io.File;

public class ListDirectories {

    public static void main(String[] args) {
        TraverseDirectories directories = new TraverseDirectories();
        
        directories.listDuplicatingFiles("C:\\Users");
        
        System.out.println("");
        
        for (File element : directories.files) {
            System.out.println(element.getName());
        }
    }
}
