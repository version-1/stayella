package group1.stayella.Model.CSV;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
  private String path;

  public Main(String path) {
    this.path = path;
  }

  public List<HashMap<String, String>> load() throws IOException {

    BufferedReader buffReader = null;
    List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

    FileInputStream fileInput = new FileInputStream(this.path);
    InputStreamReader inputStream = new InputStreamReader(fileInput);
    buffReader = new BufferedReader(inputStream);

    String rowData = buffReader.readLine();
    String[] header = rowData.split(",");

    rowData = buffReader.readLine();
    while (rowData != null) {
      String[] cols = rowData.split(",");
      HashMap<String, String> record = new HashMap<String, String>();
      for (int i = 0; i < cols.length; i++) {
        record.put(header[i], cols[i]);
      }
      list.add(record);
    }

    buffReader.close();
    return list;
  }

}