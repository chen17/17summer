import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/*
The example of summer.cin file is like this:

pns 你
gns 你
gzj 好
gz 好
omf 嗎
tmp 夏
gnn 天
edn 天

It will generate a dict_summer.dat.
*/

public class BuildSummerDictionary {

  public static final HashMap<String, String> table = new HashMap<String, String>();

  public BuildSummerDictionary() {
  }

  public static void main(String[] args) {
    BuildSummerDictionary dictBuilder = new BuildSummerDictionary();

    dictBuilder.readDictionary();
  }

  public void readDictionary() {
    BufferedReader br = null;
    ObjectOutputStream oout = null;

    try {
      FileOutputStream fout = new FileOutputStream("dict_summer.dat");
      oout = new ObjectOutputStream(fout);
      HashMap<String, String> table = new HashMap<String, String>();
      FileReader fr = new FileReader("summer.cin");
      br = new BufferedReader(fr);
 
      String currentLine = null;

      while ((currentLine = br.readLine()) != null) {
        String[] pair = currentLine.split(" ");
        String key = pair[0];
        String word = pair[1];
        table.put(key, table.getOrDefault(key, "") + word);
      }
      oout.writeObject(table);

    } catch (FileNotFoundException ioe) {
      System.out.println("[FileNotFoundException] " + ioe);
    } catch (IOException ioe) {
      System.out.println("[IOException] " + ioe);
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (IOException ioe) {
          System.out.println("[IOException] " + ioe);
        }
      }
    }
  }
}
