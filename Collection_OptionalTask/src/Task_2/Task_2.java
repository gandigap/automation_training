package Task_2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Task_2 {
    static ArrayList<File> dir = new ArrayList<File>();

    public static void main(String[] args) {
        File myDir = new File("src/");
        try {
            dir = list(myDir);
        } catch (IOException e) {
        }
        int s = dir.size();

        for (int i = 0; i < dir.size(); i++) {
            System.out.println(dir.get(i).getPath());
        }
    }

    public static ArrayList<File> list(File f) throws IOException {
        File[] currentSeekingFolderContent = f.listFiles();
        for (int i = 0; i < currentSeekingFolderContent.length; i++) {
            if (currentSeekingFolderContent[i].isDirectory()) {
                dir.add(currentSeekingFolderContent[i]);
                list(currentSeekingFolderContent[i]);
            }
        }
        return dir;
    }
}
