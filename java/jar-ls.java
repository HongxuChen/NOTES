import java.io.File;
import java.io.FileInputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

public class JarLs {

  private void run(File file){
    if(file.isDirectory()){
      File[] children = file.listFiles();
      for(File child : children){
        run(child);
      }
    } else {
      String name = file.getName();
      if(name.startsWith(".")){
        return;
      }
      if(name.endsWith(".jar") == false){
        return;
      }
      try {
        JarInputStream jin = new JarInputStream(new FileInputStream(file));
        while(true){
          JarEntry entry = jin.getNextJarEntry();
          if(entry == null){
            break;
          }
          String filename = entry.getName();
          System.out.println(file.getAbsolutePath()+": "+filename);
        }
        jin.close();
      } catch(Exception ex){
        ex.printStackTrace();
      }
    } 
  }
  
  public static void main(String[] args) {
    File dir = new File(".");
    if(args.length == 1){
      dir = new File(args[0]);
    }
    JarLs lister = new JarLs();
    lister.run(dir);
  }
}