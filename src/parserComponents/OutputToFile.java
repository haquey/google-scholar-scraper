// **********************************************************
// Assignment3:
// UTORID user_name: haqueya1
//
// Author: Yasir Haque
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// *********************************************************
package parserComponents;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class OutputToFile {
  // Holds name of file to be produced
  private String fileName;

  /**
   * Constructs a OutputToFile object whose primary function is to take a given
   * file name and create/overwrite such a file with specified contents.
   * 
   * @param fileName - String containing the name of the file to be made.
   */
  public OutputToFile(String fileName) {
    // Assign filename
    this.fileName = fileName;
  }

  /**
   * Creates a file using fileName and appends its contents with a specified
   * string. If a file with the denoted fileName already exists, then its
   * contents are overwritten.
   * 
   * @param contents - String to be written into the contents of the file.
   */
  public void writeContents(String contents) {
    PrintWriter writeFile;
    try {
      // Create a PrintWriter instance of filetype 'UTF-8' and specified name
      writeFile = new PrintWriter(fileName, "UTF-8");
      // Append with the specified contents and close
      writeFile.println(contents);
      writeFile.close();
    } catch (FileNotFoundException e) {
      // Produce error message if an unappropriate file path is given.
      System.err.println("Please specify an appropriate relative path.");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

  }
}
