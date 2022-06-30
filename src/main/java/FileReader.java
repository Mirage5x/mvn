import org.yaml.snakeyaml.Yaml;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

public class FileReader {
    public static void main(String[] parArgs)
    {
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Open file");
        if (ret == JFileChooser.APPROVE_OPTION)
        {
            try
            {
                File file = fileopen.getSelectedFile();
                FileInputStream fileInputStream = new FileInputStream(file);

                {
                    Yaml yamlread = new Yaml();
                    Map<String, Object> data = yamlread.load(fileInputStream);
                    if (data == null)
                    {
                        JOptionPane.showMessageDialog(null, "Empty file selected");
                    }
                    else
                    {
                        for (Map.Entry<String, Object> s: data.entrySet())
                        {
                            System.out.println(data);
                        }
                    }
                }



            }
            catch (FileNotFoundException e)
            {
                throw new RuntimeException(e);
            }
        }


    }
}
