import java.io.*;
/**
 * Created by rore256 on 7/27/2017.
 * sample line from dataset:
 * 34207|000af5371560|koobee|720*1280*2.0|koobee M2
 * total 4 datafiles 000000_0,000001_0,000002_0,000003_0
 */
public class parser {
    public static void main(String args[]) {
        int i =0;
        try {
            while (i < 4) {
                File file = new File("C:/Users/thatq/IdeaProjects/falcoparse/data/00000" + i + "_0.txt");
                FileInputStream stream = null;
                stream = new FileInputStream(file);
                DataInputStream in = new DataInputStream(stream);
                BufferedReader br = new BufferedReader(new InputStreamReader(in));

                String strLine;
                while ((strLine = br.readLine()) != null) {
                    System.out.println(strLine);
                }
                in.close();
                i++;
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}