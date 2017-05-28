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

import java.util.ArrayList;

public class StringOutputFormatter {
  // Initialize a string builder instance to concatenate with contents
  StringBuilder formattedContents;

  /**
   * Constructs a StringOutputFormatter object which initializes a String
   * Builder instance to populate and appropriately format with raw content
   * information/values.
   */
  public StringOutputFormatter() {
    // Initialize a string builder instance
    formattedContents = new StringBuilder();
  }

  /**
   * Takes in a single element String array and formats the formattedContents
   * such that it appropriately contains the author name portion of the output.
   * 
   * @param authorName - String[] that contains the author's name as an element.
   */
  public void formatAuthor(String[] authorName) {
    // Appropriately format the name of author portion of the contents
    formattedContents.append(
        "---------------------------------------------------------------------"
            + "--\n");
    // Use helper function to manipulate formattedContents
    formatHelper(authorName, "1. Name of Author:");
  }

  /**
   * Takes in a single element String array and formats the formattedContents
   * such that it appropriately contains the specified portion of the output.
   * 
   * @param authorName - String[] that contains the author's name as an element.
   * @param header - String header information preceding actual contents.
   */
  private void formatHelper(String[] content, String header) {
    // First append the header info preceding the actual contents
    formattedContents.append(header + "\n");
    // Only append the content information if it is a String array of one
    // element that actually contains a string
    if (content[0] != null) {
      formattedContents.append("\t" + content[0]);
    }
    // add a newline character
    formattedContents.append("\n");
  }

  /**
   * Takes in a single element String array and formats the formattedContents
   * such that it appropriately contains the number of total citations portion
   * of the output.
   * 
   * @param numCited - String[] that contains the number of total citations as
   *        an element.
   */
  public void formatCitations(String[] numCited) {
    // Use helper function to manipulate formattedContents
    formatHelper(numCited, "2. Number of All Citations:");
  }

  /**
   * Takes in a single element String array and formats the formattedContents
   * such that it appropriately contains the number i10-index after 2009 portion
   * of the output.
   * 
   * @param numIndex - String[] that contains the number of i10-index as an
   *        element.
   */
  public void formatI10Index(String[] numIndex) {
    // Use helper function to manipulate formattedContents
    formatHelper(numIndex, "3. Number of i10-index after 2009:");
  }

  /**
   * Takes in a multiple element String array and formats the formattedContents
   * such that it appropriately contains the publication titles portion of the
   * output.
   * 
   * @param titles - String[] that contains the titles of at most the first
   *        three publications as elements.
   */
  public void formatTitles(String[] titles) {
    // Appropriately format the header for publication titles
    formattedContents.append("4. Title of the first 3 publications:\n");
    // Use a counter to help number the titles dynamically as they are appended
    int titleNum = 0;
    for (String title : titles) {
      if (title != null) {
        titleNum++;
        formattedContents.append("\t" + titleNum + "-   " + title);
      }
      formattedContents.append("\n");
    }
  }

  /**
   * Takes in a single element String array and formats the formattedContents
   * such that it appropriately contains the number of citations from the first
   * five publications portion of the output.
   * 
   * @param numCited - String[] that contains the total number citations from
   *        the author's first five publications as an element.
   */
  public void formatNumCiteFivePub(String[] numCited) {
    // Use helper function to manipulate formattedContents
    formatHelper(numCited, "5. Total paper citation (first 5 papers):");
  }

  /**
   * Takes in a single element String array and formats the formattedContents
   * such that it appropriately contains the number of coauthors portion of the
   * output.
   * 
   * @param numCoauthors - String[] that contains the total number citations
   *        from the author's first five publications as an element.
   */
  public void formatNumCoauthors(String[] numCoauthors) {
    // Use helper function to manipulate formattedContents
    formatHelper(numCoauthors, "6. Total Co-Authors:");
  }


  /**
   * Takes in an ArrayList containing the names of numerous coauthors and
   * formats the formattedContents such that it appropriately displays the names
   * of all the coauthors when output.
   * 
   * @param coauthors - ArrayList<String> that contains the names of all the
   *        coauthors.
   */
  public void formatCoauthors(ArrayList<String> coauthors) {
    // Append dotted line for seperating the coauthors portion of the output
    formattedContents.append(
        "\n------------------------------------------------------------------"
            + "-----\n");
    // Append the header preceding the coauthor names
    formattedContents.append(
        "7. Co-Author list sorted (Total: " + coauthors.size() + "):\n");
    // If the ArrayList<String> containing coauthor names is not empty, append
    // the information
    if (!coauthors.isEmpty()) {
      for (String coauthor : coauthors) {
        formattedContents.append(coauthor + "\n");
      }
    }
  }

  /**
   * Takes the String Builder instance of formattedContents and returns it as a
   * string to be potentially sent to an appropriate output destination.
   * 
   * @return formattedContents - String representation of the formatted contents
   */
  public String getStringForOutput() {
    // Convert String Builder to String
    return formattedContents.toString();
  }
}
