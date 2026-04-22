package onlyajar.log.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

final public class FileOutWriter implements AutoCloseable {
    private FileWriter writer;
    public FileOutWriter(File outFile){
        try {
            writer = new FileWriter(outFile, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void write(String data){
        try {
            writer.write(data);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeln(String data){
        try {
            writer.write(data+ System.lineSeparator());
            writer.flush();
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        writer.close();
    }
}
