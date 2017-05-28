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

public class OutputToConsole {
  // String holding the formatted information to be printed to the console
  private String stringToConsole;

  /**
   * Constructs an OutputToConsole object whose primary function is to take a
   * appropriately formatted string and display it on the console.
   * 
   * @param stringToConsole - String containing the information to be printed on
   *        the console.
   */
  public OutputToConsole(String stringToConsole) {
    this.stringToConsole = stringToConsole;
  }

  /**
   * Takes the appropriately formatted information from stringToConsole and
   * prints it to the console.
   */
  public void printContentsToConsole() {
    System.out.println(stringToConsole);
  }

}
