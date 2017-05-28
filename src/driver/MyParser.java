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
package driver;

import parserComponents.*;

public class MyParser {

  /**
   * Calls on a helper method to take the specified html files and parses
   * through their html code to extract key contents and print them to the
   * console or write them to a file. An optional outfile parameter is given to
   * potentially redirect the output to a file.
   * 
   * @param args - A String[] containing the names of two html files/urls that
   *        are to be parsed for information. An optional outfile parameter is
   *        given to redirect the output to a specified file.
   */
  public static void main(String[] args) {
    ParseSourceCode(args);
  }


  /**
   * Takes the specified html files and parses through their html code to
   * extract key contents and print them to the console or write them to a file.
   * An optional outfile parameter is given to potentially redirect the output
   * to a file.
   * 
   * @param args - A String[] containing the names of two html files/urls that
   *        are to be parsed for information. An optional outfile parameter is
   *        given to redirect the output to a specified file.
   */
  private static void ParseSourceCode(String[] args) {

    try {
      // Split up the file names or urls into a String[]
      String inputFiles[] = args[0].split(",");
      // Initialize a StringOutputFormatter instance to take in the raw data
      StringOutputFormatter formatContents = new StringOutputFormatter();
      for (String inputFile : inputFiles) {
        HTMLContentParser parser = new HTMLContentParser(inputFile);
        // Parse the raw HTML code for author info and format it
        formatContents.formatAuthor((parser.extractAuthorsName()));
        // Parse the raw HTML code for total num citation info and format it
        formatContents.formatCitations((parser.extractTotalNumCitations()));
        // Parse the raw HTML code for i10-index info and format it
        formatContents.formatI10Index((parser.extractI10Index()));
        // Parse the raw HTML code for publication title info and format it
        formatContents.formatTitles(parser.extractTitles());
        // Parse the raw HTML code for num of citations from the first five
        // publications and format it
        formatContents.formatNumCiteFivePub((parser.extractNumCiteFivePub()));
        // Parse the raw HTML code for number of coauthors and format it
        formatContents
            .formatNumCoauthors(parser.populateColAndReturnNumCoauthorsAdded());
      }
      // Get the ArrayList of coauthor names from the parser and format it
      formatContents.formatCoauthors(HTMLContentParser.getAndSortCoauthors());

      // Redirect the formatted output to a file if the optional outfile
      // parameter exists
      if (args.length > 1) {
        OutputToFile writeFile = new OutputToFile(args[1]);
        writeFile.writeContents(formatContents.getStringForOutput());
        // Print the formatted output to the console if the optional parameter
        // doesn't exist
      } else {
        OutputToConsole writeConsole =
            new OutputToConsole(formatContents.getStringForOutput());
        writeConsole.printContentsToConsole();
      }

      // Print an error on the console if an invalid filename or url was given
    } catch (Exception e) {
      System.err
          .println("Malformed URL or cannot open connection to given URL.");
    }

  }
}
