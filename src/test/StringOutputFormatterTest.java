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

import java.util.ArrayList;

import parserComponents.*;

import org.junit.Before;
import org.junit.Test;

public class StringOutputFormatterTest {
  private StringOutputFormatter formatter;

  @Before
  public void setUp() throws Exception {}

  {
    formatter = new StringOutputFormatter();
  }

  @Test
  public void testFormatAuthorName() {
    /*
     * Test to determine if the output string is properly formatted given a
     * String[] with an authorName inside.
     * 
     * Expected output should be a string containing a header notifying the
     * section for the author's name, followed by the authors name itself
     */
    String[] authorName = {"Yasir Haque"};
    formatter.formatAuthor(authorName);
    String expected =
        "---------------------------------------------------------------------"
            + "--\n" + "1. Name of Author:\n" + "\t" + authorName[0] + "\n";
    assertEquals(formatter.getStringForOutput(), expected);
  }

  @Test
  public void testFormatTotalCitationNum() {
    /*
     * Test to determine if the output string is properly formatted given a
     * String[] with the number of total citations inside.
     * 
     * Expected output should be a string containing a header notifying the
     * section for the number of total citations, followed by the number itself
     */
    String[] numCited = {"1846"};
    formatter.formatCitations(numCited);
    String expected =
        "2. Number of All Citations:\n" + "\t" + numCited[0] + "\n";
    assertEquals(formatter.getStringForOutput(), expected);
  }

  @Test
  public void testFormatI10Index() {
    /*
     * Test to determine if the output string is properly formatted given a
     * String[] with the number of i10-indexes after 2009 inside.
     * 
     * Expected output should be a string containing a header notifying the
     * section for the number of i10-indexes, followed by the number itself
     */
    String[] numIndex = {"0"};
    formatter.formatI10Index(numIndex);
    String expected =
        "3. Number of i10-index after 2009:\n" + "\t" + numIndex[0] + "\n";
    assertEquals(formatter.getStringForOutput(), expected);
  }

  @Test
  public void testFormatNumCiteFivePub() {
    /*
     * Test to determine if the output string is properly formatted given a
     * String[] with the number of total citations inside.
     * 
     * Expected output should be a string containing a header notifying the
     * section for the number of total citations, followed by the number itself
     */
    String[] numCited = {"123456789"};
    formatter.formatNumCiteFivePub(numCited);
    String expected = "5. Total paper citation (first 5 papers):\n" + "\t"
        + numCited[0] + "\n";
    assertEquals(formatter.getStringForOutput(), expected);
  }

  @Test
  public void testFormatTitlesNone() {
    /*
     * Test to determine if the output string is properly formatted given a
     * String[] with no titles inside (an empty String[] of size 3).
     * 
     * Expected output should be a string containing a header notifying the
     * section for the number of total citations, followed by newline characters
     * for each missing title.
     */
    String[] titles = new String[3];
    formatter.formatTitles(titles);
    String expected = "4. Title of the first 3 publications:\n\n\n\n";
    assertEquals(formatter.getStringForOutput(), expected);
  }

  @Test
  public void testFormatTwoTitles() {
    /*
     * Test to determine if the output string is properly formatted given a
     * String[] with two titles inside (implying one empty/null element).
     * 
     * Expected output should be a string containing a header notifying the
     * section for the number of total citations, followed by newline characters
     * for each missing title.
     */
    String[] titles = new String[3];
    titles[0] = "title1";
    titles[1] = "title2";
    formatter.formatTitles(titles);
    String expected = "4. Title of the first 3 publications:\n" + "\t" + "1-   "
        + titles[0] + "\n" + "\t" + "2-   " + titles[1] + "\n\n";
    assertEquals(formatter.getStringForOutput(), expected);
  }

  @Test
  public void testFormatNumCoauthors() {
    /*
     * Test to determine if the output string is properly formatted given a
     * String[] with number of coauthors..
     * 
     * Expected output should be a string containing a header notifying the
     * section for the number of coauthors, followed by the number itself.
     */
    String[] numCo = {"22"};
    formatter.formatNumCoauthors(numCo);
    String expected = "6. Total Co-Authors:\n" + "\t" + numCo[0] + "\n";
    assertEquals(formatter.getStringForOutput(), expected);
  }

  @Test
  public void testFormatCoauthorsZero() {
    /*
     * Test to determine if the output string is properly formatted given a
     * String[] with number of coauthors..
     * 
     * Expected output should be a string containing a header notifying the
     * section for coauthors.
     */
    ArrayList<String> coauthors = new ArrayList<String>();
    formatter.formatCoauthors(coauthors);
    String expected =
        "\n------------------------------------------------------------------"
            + "-----\n" + "7. Co-Author list sorted (Total: " + coauthors.size()
            + "):\n";
    assertEquals(formatter.getStringForOutput(), expected);
  }

  @Test
  public void testFormatCoauthorsNumerous() {
    /*
     * Test to determine if the output string is properly formatted given a
     * String[] with number of coauthors..
     * 
     * Expected output should be a string containing a header notifying the
     * section for coauthors, followed by a list of coauthors.
     */
    ArrayList<String> coauthors = new ArrayList<String>();
    coauthors.add("author1");
    coauthors.add("author2");
    coauthors.add("author3");
    coauthors.add("author4");
    coauthors.add("author5");
    formatter.formatCoauthors(coauthors);
    String expected =
        "\n------------------------------------------------------------------"
            + "-----\n" + "7. Co-Author list sorted (Total: " + coauthors.size()
            + "):\n" + "author1\nauthor2\nauthor3\nauthor4\nauthor5\n";
    assertEquals(formatter.getStringForOutput(), expected);
  }
}
