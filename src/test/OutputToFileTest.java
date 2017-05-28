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
package test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import parserComponents.*;

public class OutputToFileTest {
  private OutputToFile outfile;

  @Test
  public void testFileCreationForOutputToFile() {
    /*
     * Test to determine if a file is being appropriately created when the
     * OutputToFile class is given a valid filename and specified contents to
     * write into the file.
     * 
     * Expected result is the creation of a file with the specified contents.
     */
    outfile = new OutputToFile("outfile.txt");
    outfile.writeContents("The file was made! TEST PASSED!");
    File checkFile = new File("outfile.txt");
    assertTrue(checkFile.exists());
    if (checkFile.exists()) {
      checkFile.delete();
    }
  }

  @Test
  /*
   * Test to determine if OutputToFile behaves appropriately when it is given a
   * filepath that does not exist.
   * 
   * Expected result is that it does not created the specified file and raises
   * and exception.
   */
  public void testInvalidPathNoFileCreationForOutputToFile() {
    outfile = new OutputToFile("not_an_existing_dir/outfile.txt");
    outfile.writeContents("Please specify an appropriate relative path.");
    File checkFile = new File("not_an_existing_dir/outfile.txt");
    assertFalse(checkFile.exists());
  }

}
