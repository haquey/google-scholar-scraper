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
import java.util.Arrays;
import java.util.Collections;

import parserComponents.*;

import org.junit.Before;
import org.junit.Test;

public class HTMLContentParserTest {
  private HTMLContentParser parser;

  @Before
  public void setUp() throws Exception {}

  {
    String inputFile = "sample1.html";
    try {
      parser = new HTMLContentParser(inputFile);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testExtractAuthorName() {
    /*
     * Test to determine if the parser appropriately searches for the author's
     * name in the html code.
     * 
     * Expected output should be a String[] with the author's name.
     */
    String[] authorName = {"Ola Spjuth"};
    assertEquals(Arrays.toString(parser.extractAuthorsName()),
        Arrays.toString(authorName));
  }

  @Test
  public void testTotalNumCitations() {
    /*
     * Test to determine if the parser appropriately searches for the number of
     * total citations in the html code.
     * 
     * Expected output should be a String[] with the number of total citations.
     */
    String[] numCited = {"437"};
    assertEquals(Arrays.toString(parser.extractTotalNumCitations()),
        Arrays.toString(numCited));
  }

  @Test
  public void testExtractI10Index() {
    /*
     * Test to determine if the parser appropriately searches for the number of
     * i10-indexes after 2009 in the raw html string.
     * 
     * Expected output should be a String[] with the number of i10-indexes.
     */
    String[] numIndex = {"12"};
    assertEquals(Arrays.toString(parser.extractI10Index()),
        Arrays.toString(numIndex));
  }

  @Test
  public void testExtractTitles() {
    /*
     * Test to determine if the parser appropriately searches for the author's
     * publication titles in the html code.
     * 
     * Expected output should be a String[] with names from up to 3 of the
     * author's publications.
     */
    String[] titles =
        {"Bioclipse: an open source workbench for chemo-and bioinformatics",
            "The LCB data warehouse",
            "XMPP for cloud computing in bioinformatics supporting "
                + "discovery and invocation of asynchronous web services"};
    System.out.println(Arrays.toString(parser.extractTitles()));
    assertEquals(Arrays.toString(parser.extractTitles()),
        Arrays.toString(titles));
  }

  @Test
  public void testExtractNumCiteFivePub() {
    /*
     * Test to determine if the parser appropriately searches for the number of
     * citations in the author's first five publications and adds them up in the
     * html code.
     * 
     * Expected output should be a String[] with the total number of citations
     * from the author's first five publications.
     */
    String[] numCited = {"239"};
    assertEquals(Arrays.toString(parser.extractNumCiteFivePub()),
        Arrays.toString(numCited));
  }

  @Test
  public void testPopulateColAndReturnNumCoauthorsAdded() {
    /*
     * Test to determine if the parser appropriately counts how many coauthors
     * are listed in the html document.
     * 
     * Expected output should be a String[] with the number of coauthors.
     */
    String[] numAdded = {"15"};
    assertEquals(
        Arrays.toString(parser.populateColAndReturnNumCoauthorsAdded()),
        Arrays.toString(numAdded));
  }

  @Test
  public void testPopulateColAndReturnNumCoauthorsAddedWhenZero() {
    /*
     * Test to determine if the parser appropriately counts how many coauthors
     * are listed in the html document when there are none to be found.
     * 
     * Expected output should be a String[] with the number zero.
     */
    String inputFile = "sample3.html";
    try {
      parser = new HTMLContentParser(inputFile);
    } catch (Exception e) {
      e.printStackTrace();
    }
    String[] numAdded = {"0"};
    assertEquals(
        Arrays.toString(parser.populateColAndReturnNumCoauthorsAdded()),
        Arrays.toString(numAdded));
  }

  @Test
  public void testExtractCoauthors() {
    /*
     * Test to determine if the parser appropriately distinguishes the coauthor
     * names within the raw html.
     * 
     * Expected output should be a String[] with the names of the of coauthors.
     */
    ArrayList<String> cNames = new ArrayList<String>();
    String[] coauthorNames = {"Adam Ameur", "Antony John Williams",
        "Christoph Steinbeck", "Egon Willighagen", "Janna Hastings",
        "Jonathan Alvarsson", "Komorowski Jan", "Nina Jeliazkova",
        "Noel M. O'Boyle", "Rajarshi Guha", "Sam Adams", "Samuel Lampa",
        "Sean Ekins", "Valentin Georgiev", "gilleain torrance"};
    for (String name : coauthorNames) {
      cNames.add(name);
    }
    Collections.sort(cNames);
    System.out.println(
        Arrays.toString(HTMLContentParser.getAndSortCoauthors().toArray()));
    assertEquals(
        Arrays.toString(HTMLContentParser.getAndSortCoauthors().toArray()),
        Arrays.toString(cNames.toArray()));
  }


}
