import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.nio.charset.Charset;

public class DocxReader extends FileReader {
  private static final int BUFFER_SIZE = 8192;

  public DocxReader(String s) {
    super(s);
  }

  // Opens and reads a docx file, modified version of ReadZip's method
  public String readFile() {
    String docText = "";
    try {
      // A ZipInputStream reads in the docx file, which is secretly a zip file
      ZipInputStream zis = new ZipInputStream(new FileInputStream(getFileName()),
      Charset.forName("UTF-8"));

      // Iterate through the files up the zipped folder to find document.xml
      ZipEntry ze = zis.getNextEntry();

      while (ze != null && !ze.getName().equals("word/document.xml")) {
        ze = zis.getNextEntry();
      }
      System.out.println("Opening document.xml file...");
      docText += readInFileContents(zis);
    } catch (IOException ex) {
      // Just in case there's problems
      ex.printStackTrace();
    }
    return docText;
  }

  // Reads in the file contents
  private String readInFileContents(ZipInputStream zis) throws IOException{
    String document = "";

    // A buffer is an array used to read in or write out data.
    final byte[] buffer = new byte[BUFFER_SIZE];

    int bytesRead = 0;
    /* The while statement says: "read in BUFFER_SIZE amount of bytes
    * of data, store it in `buffer`, and then update `bytesRead`
    * accordingly. Repeat this process until the buffer didn't read
    * anything new, then stop."
    */
    while((bytesRead = zis.read(buffer)) != -1) {
      // Create a string from the data we just read in, append it to `docText`.
      document += new String(buffer, 0, bytesRead);
    }
    return document;
  }

  public static void main(String[] args) {
    DocxReader test = new DocxReader("Testdoc.docx");
    System.out.println(test.readFile());
  }

}
