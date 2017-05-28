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

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;

public class RawHTMLGetter {
  // Holds a String representation of the url pointing to an html page
  private String urlString;

  /**
   * Constructs a RawHTMLGetter object whose primary function is to obtain the
   * HTML source code of an HTML page given its urlString
   * 
   * @param urlString - String representation of a url pointing to an html page.
   */
  public RawHTMLGetter(String urlString) {
    // Assigns string representation of url pointing to an html page
    this.urlString = urlString;
  }

  /**
   * Obtains the HTML source code of an HTML page using the instanced urlString.
   * 
   * @return a String - Contains all the html source code of the specified page
   *         within a single line.
   */
  public String getHTML() throws Exception {
    // create object to store html source text as it is being collected
    StringBuilder html = new StringBuilder();
    // open connection to given url
    URL url = new File(urlString).toURI().toURL();
    // create BufferedReader to buffer the given url's HTML source
    BufferedReader htmlbr =
        new BufferedReader(new InputStreamReader(url.openStream()));
    String line;
    // read each line of HTML code and store in StringBuilder
    while ((line = htmlbr.readLine()) != null) {
      html.append(line);
    }
    htmlbr.close();
    // convert StringBuilder into a String and return it
    return html.toString();
  }
}

