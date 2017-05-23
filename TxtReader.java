public class TxtReader extends FileReader {

  public TxtReader(String file) {
    super(file);
  }

  public String readFile(){
    String output = "";
    if(getFileName().contains(".txt")){
      EasyReader reading = new EasyReader(getFileName());
      while(!reading.eof()){
        output+= reading.readLine();
      }
    }
    return output;
  }
}
