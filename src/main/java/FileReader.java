import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import javax.swing.*;
import java.io.*;
import java.util.Map;

public class FileReader {

    private static final Logger logger = LoggerFactory.getLogger(FileReader.class);

    public static void main(String[] parArgs) throws IOException {
        logger.trace("Process");

        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Open file");
        if (ret == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fileopen.getSelectedFile();
                FileInputStream fileInputStream = new FileInputStream(file);

                {
                    Yaml yamlread = new Yaml();
                    Map<String, Object> data = yamlread.load(fileInputStream);
                    if (data == null) {
                        JOptionPane.showMessageDialog(null, "Empty file selected");
                        logger.error("empty file");
                    } else {
                        for (Map.Entry<String, Object> s : data.entrySet()) {
                            System.out.println(s);
                        }
                        logger.trace("its working");
                    }
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            logger.trace("Exit");
        }
    }
}

