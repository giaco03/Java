package patatina;

import java.io.*;

public class TextFile {
    private char mode; // R = read, W = wri
    private File file;
    private BufferedReader reader;
    private BufferedWriter writer;

    public TextFile (String filename, char mode) throws IOException {
        file = new File(filename);
        if (mode == 'R'){
            this.mode = 'R';
            reader = new BufferedReader(new FileReader(filename));
        }
        else{
            this.mode = 'W';
            writer = new BufferedWriter(new FileWriter(filename));
        }
    }

    public void writeData (String text) throws IOException{
        writer.write(text);
    }

    public String[] readData () throws IOException{
        String tmp = reader.readLine();
        if (tmp == null) return null;
        return tmp.split(";");
    }

    public void closeFile() throws IOException {
        if(this.mode == 'R') reader.close();
        else writer.close();
    }

    /*
    public String read(File file){

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file.getName()));
            String output = reader.readLine();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
     */


}
