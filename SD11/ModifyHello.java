import java.io.RandomAccessFile;
import java.io.IOException;

public class ModifyHello
{
    public static void main(String[] args) throws IOException 
    {
        // open an output file using the file name passed
        RandomAccessFile file = new RandomAccessFile(args[0], "rw");
        file.seek(3);
        int a = file.read();
        file.seek(3);
        file.write(a + 1);
        // close files to make sure they get written to the disk
        file.close();
    }
}
