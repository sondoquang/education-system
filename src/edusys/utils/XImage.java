
package EduSys.UTILS;

import java.awt.Image;
import java.io.File;
import java.nio.file.Path;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

public class XImage {
    public static Image getAppIcon(){
        URL url = XImage.class.getResource("/EduSys/Icon/logo-small.png");
        return new ImageIcon(url).getImage();
    }
    
    public static ImageIcon read(String fileName){
        File Path = new File("src\\edusys\\Images",fileName);
        return new ImageIcon(Path.getAbsolutePath());
    }
    
    public static void save(File src){
        File dst = new File("src\\edusys\\Images",src.getName());
        if(!dst.getParentFile().exists()){
            dst.getParentFile().mkdir();
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from, to,StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public static ImageIcon getResized(ImageIcon img, int WIDTH, int HEIGHT){
        Image resize = img.getImage().getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH);
        return new ImageIcon(resize);
    }
    
    public static String getPath(String fileName){
        File Path = new File("src/resources",fileName);
        return Path.getAbsolutePath();
    }
}
