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
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLContentParser {
  // Contains HTML source code in a single line String
  private String rawHTMLString;
  // Static ArrayList which contains String names of coauthors
  private static ArrayList<String> coauthorNames;

  /**
   * Constructs a HTMLContentsParser object which initializes a String
   * containing the HTML source code of an HTML web page given its url. Also
   * forms a new instance of an ArrayList to hold coauthor names if it doesn't
   * already exist.
   * 
   * @param urlString - String of the url that points to an html page.
   * @throws Exception - Throws an exception if the given url is not valid.
   */
  public HTMLContentParser(String urlString) throws Exception {
    RawHTMLGetter HTMLGetter = new RawHTMLGetter(urlString);
    // Obtains HTML source code in a single line String
    rawHTMLString = HTMLGetter.getHTML();
    // Creates an instance coauthorNames isn't already pointing to a
    // pre-existing ArrayList
    if (coauthorNames == null) {
      coauthorNames = new ArrayList<String>();
    }
  }

  /**
   * Extracts the author's name from the rawHTMLString. Returns a single element
   * String[] which contains the author's name.
   * 
   * @return authorName - A single element String[] containing the author name.
   */
  public String[] extractAuthorsName() {
    // Call helper with regex that searches for author's name in html code
    String[] authorName = extractHelper("<span id=\"cit-name-display\" "
        + "class=\"cit-in-place-nohover\">(.*?)</span>");
    return authorName;
  }

  /**
   * Extracts the total number of citations from the rawHTMLString. Returns a
   * single element String[] which contains the total number of citations.
   * 
   * @return numCited - A single element String[] containing the total number of
   *         citations.
   */
  public String[] extractTotalNumCitations() {
    // Call helper with regex that searches for num cited in html code
    String[] numCited = extractHelper(
        "Citations</a></td><td class=\"cit-borderleft cit-data\">([0-9]+)"
            + "</td>");
    return numCited;
  }

  /**
   * Extracts the number of i10-index after 2009 from the rawHTMLString. Returns
   * a single element String[] which contains that number.
   * 
   * @return numIndex - A single element String[] containing the number of
   *         i10-index after 2009.
   */
  public String[] extractI10Index() {
    // Call helper with regex that searches for num i10-indexes in html code
    String[] numIndex = extractHelper(
        "<td class=\"cit-borderleft cit-data\">([0-9]+)</td></tr></tbody>"
            + "</table>");
    return numIndex;
  }

  /**
   * Helper function used to find a specific piece of content from the
   * rawHTMLString given an extractionRegex with a group(1) parameter. Returns
   * the result of the search in String[].
   * 
   * @param extractionRegex - Specified String regex used to conduct the search
   * @return contentElement - A single element String[] containing the subject
   *         of the search.
   */
  private String[] extractHelper(String extractionRegex) {
    // Initialize a String[] to hold the found content
    String[] contentElement = new String[1];

    // Create Pattern and Matcher objects
    Pattern patternObject = Pattern.compile(extractionRegex);
    Matcher matcherObject = patternObject.matcher(rawHTMLString);
    // Find the specified content allocate it to the String[]
    while (matcherObject.find()) {
      contentElement[0] = matcherObject.group(1);
    }
    return contentElement;
  }


  /**
   * Extracts the first three publication titles from the rawHTMLString. Returns
   * a three element String[] which contains the author's first three
   * publications.
   * 
   * @return titles - A three element String[] containing the publication names.
   */
  public String[] extractTitles() {
    // Initialize String[] to hold up to three titles
    String[] titles = new String[3];
    // Regex to search for publication titles in the html code
    String extractionRegex =
        "<a href=\"(.*?)\" class=\"cit-dark-large-link\">(.*?)</a><br>";
    Pattern patternObject = Pattern.compile(extractionRegex);
    Matcher matcherObject = patternObject.matcher(rawHTMLString);
    // Only add up to three titles to the String[] and only if a match is found
    int counter = 0;
    while (matcherObject.find() && counter < 3) {
      titles[counter] = matcherObject.group(2);
      counter++;
    }
    return titles;
  }

  /**
   * Extracts the number of citations from the author's first five publications
   * from the rawHTMLString. Returns a single element String[] which contains
   * that number.
   * 
   * @return numCite - A single element String[] containing the number of
   *         citations.
   */
  public String[] extractNumCiteFivePub() {
    // Initialize a String[] to hold num cited
    String[] numCite = new String[1];
    // Regex used to search for num cited in html code
    String extractionRegex =
        "<td id=\"col-citedby\"><a class=\"cit-dark-link\" href=\"(.*?)\">"
            + "([0-9]+)</a></td>";
    Pattern patternObject = Pattern.compile(extractionRegex);
    Matcher matcherObject = patternObject.matcher(rawHTMLString);
    // Only add up the number of citations for the first five publications
    int counter = 0;
    int numOfCites = 0;
    while (matcherObject.find() && counter < 5) {
      counter++;
      numOfCites = numOfCites + Integer.parseInt(matcherObject.group(2));
    }
    // Convert the number of citations into a String to populate the String[]
    numCite[0] = Integer.toString(numOfCites);
    return numCite;
  }

  /**
   * Populates the coauthors' ArrayList with the names of the coauthors. Returns
   * a single element String[] with the number of coauthors added to the
   * ArrayList.
   * 
   * @return numCoauthorsAdded - A single element String[] containing the number
   *         of coauthors added to the ArrayList.
   */
  public String[] populateColAndReturnNumCoauthorsAdded() {
    // Initialize a String[] to hold the num of coauthors added
    String[] numCoauthorsAdded = new String[1];
    int coauthorsAdded = 0;
    // Create a regex, pattern and matcher to search for whether the html code
    // contains no coauthors
    String noCoauthorRegex = "No co-authors</span>";
    Pattern noCoauthorPattern = Pattern.compile(noCoauthorRegex);
    Matcher noCoauthorMatcher = noCoauthorPattern.matcher(rawHTMLString);

    // If there ARE coauthors
    if (!noCoauthorMatcher.find()) {
      // Find the portion of the page where the coauthors begin being listed
      String extractionRegex =
          "Co-authors</div><div style=\"padding:.5em; border:.3em solid "
              + "#9FD9A7\">";
      Pattern patternObject = Pattern.compile(extractionRegex);
      Matcher matcherObject = patternObject.matcher(rawHTMLString);
      matcherObject.find();

      // Find the portion of the page where the coauthors end being listed
      String extractionRegex2 = "<div style=\"margin-top:0.5em\">";
      Pattern patternObject2 = Pattern.compile(extractionRegex2);
      Matcher matcherObject2 = patternObject2.matcher(rawHTMLString);
      matcherObject2.find();

      // Search for coauthor names only within the area of the page or html code
      // where they are listed
      String extractionRegex3 =
          "<a class=\"cit-dark-link\" href=\"(.*?)\" title=\"(.*?)\">(.*?)</a>";
      String newHTMLString =
          rawHTMLString.substring(matcherObject.end(), matcherObject2.start());
      Pattern patternObject3 = Pattern.compile(extractionRegex3);
      Matcher matcherObject3 = patternObject3.matcher(newHTMLString);

      // Add the coauthor names to the the ArrayList and keep track of how many
      // are added
      while (matcherObject3.find()) {
        coauthorsAdded++;
        coauthorNames.add(matcherObject3.group(3));
      }
    }
    // Convert the num of coauthors to a String and add it to the String[]
    numCoauthorsAdded[0] = Integer.toString(coauthorsAdded);
    return numCoauthorsAdded;
  }

  /**
   * Returns a sorted ArrayList containing the names of all the coauthors.
   * 
   * @return coauthorNames - An ArrayList<String> containing the names of all
   *         the coauthors.
   */
  public static ArrayList<String> getAndSortCoauthors() {
    // Sort the ArrayList containging the coauthor names
    Collections.sort(coauthorNames);
    return coauthorNames;
  }

  /**
   * Returns the number of coauthors within the ArrayList which carries the
   * names of all the coauthors.
   * 
   * @return coauthorNames.size() - Number of coauthors within the coauthorNames
   *         static ArrayList<String>
   */
  public static int getNumCoauthors() {
    // Get the size of the array list containing coauthor names
    return coauthorNames.size();
  }
}
