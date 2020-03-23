import java.io.PrintStream;
import java.io.IOException;

public class HelloFile
{
    public static void main(String[] args) throws IOException 
    {
        // open an output file using the file name passed
        PrintStream outputFile = new PrintStream(args[0]);
        outputFile.println("Hello File!");
        // close files to make sure they get written to the disk
        outputFile.close();
    }
}
