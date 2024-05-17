import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Helpers {

    public static String tail(File file, int lines) {
        java.io.RandomAccessFile fileHandler = null;
        try {
            fileHandler =
                    new java.io.RandomAccessFile( file, "r" );
            long fileLength = fileHandler.length() - 1;
            StringBuilder sb = new StringBuilder();
            int line = 0;

            for(long filePointer = fileLength; filePointer != -1; filePointer--){
                fileHandler.seek( filePointer );
                int readByte = fileHandler.readByte();

                if( readByte == 0xA ) {
                    if (filePointer < fileLength) {
                        line = line + 1;
                    }
                } else if( readByte == 0xD ) {
                    if (filePointer < fileLength-1) {
                        line = line + 1;
                    }
                }
                if (line >= lines) {
                    break;
                }
                sb.append( ( char ) readByte );
            }

            String lastLine = sb.reverse().toString();
            return lastLine;
        } catch( java.io.FileNotFoundException e ) {
            e.printStackTrace();
            return null;
        } catch( java.io.IOException e ) {
            e.printStackTrace();
            return null;
        }
        finally {
            if (fileHandler != null )
                try {
                    fileHandler.close();
                } catch (IOException e) {
                }
        }
    }

    public static void log(String filename, String str) {
        String path = "logs/" + filename;

        try {
            FileWriter fileWriter = new FileWriter(path,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(str);
            bufferedWriter.newLine();
            bufferedWriter.close(); // Always remember to close the writer

        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }

}
