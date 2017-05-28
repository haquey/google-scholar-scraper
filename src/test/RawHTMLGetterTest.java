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

import org.junit.Test;

import parserComponents.*;

public class RawHTMLGetterTest {
  private RawHTMLGetter getter;

  @Test
  public void testGetHTMLBlankPage() {
    /*
     * Test to determine if the HTMLGetter can obtain the raw html code of a
     * blank html page.
     * 
     * Expected output should be a short string of html code, mostly consisting
     * of basic tags.
     */
    getter = new RawHTMLGetter("testHTMLGetterBlank.html");
    String htmlString =
        "<HTML><HEAD><TITLE>THIS IS A TEST</TITLE></HEAD></BODY></HTML>";
    try {
      assertEquals(getter.getHTML(), htmlString);
    } catch (Exception e) {
      assertTrue(false);
    }
  }

  @Test
  /*
   * Test to determine if the HTMLGetter can obtain the raw html code of a small
   * html page.
   * 
   * Expected output should be a short string of html code, consisting of some
   * body paragraph text and of basic tags.
   */
  public void testGetHTMLShortPage() {
    getter = new RawHTMLGetter("testHTMLGetter1.html");
    String htmlString =
        "<HTML><HEAD><TITLE>Your Title Here</TITLE></HEAD><BODY BGCOLOR=\"FFF"
            + "FFF\"><CENTER><IMG SRC=\"clouds.jpg\" ALIGN=\"BOTTOM\">"
            + " </CENTER><HR><a href=\"http://somegreatsite.com\">Link Name"
            + "</a>is a link to another nifty site<H1>This is a Header</H1>"
            + "<H2>This is a Medium Header</H2>Send me mail at <a href=\"mai"
            + "lto:support@yourcompany.com\">support@yourcompany.com</a>.<P> "
            + "This is a new paragraph!<P> <B>This is a new paragraph!</B><BR>"
            + " <B><I>This is a new sentence without a paragraph break, in bold"
            + " italics.</I></B><HR></BODY></HTML>";
    try {
      assertEquals(getter.getHTML(), htmlString);
    } catch (Exception e) {
      assertTrue(false);
    }
  }

  @Test
  public void testGetHTMLLongerPage() {
    /*
     * Test to determine if the HTMLGetter can obtain the raw html code of a
     * larger html page.
     * 
     * Expected output should be a long string of html code, consisting of more
     * body paragraph text and of basic tags.
     */
    getter = new RawHTMLGetter("testHTMLGetter2.html");
    String htmlString =
        "<HTML><HEAD><TITLE>Your Title Here</TITLE></HEAD><BODY BGCOLOR=\"FFFF"
            + "FF\"><CENTER><IMG SRC=\"clouds.jpg\" ALIGN=\"BOTTOM\"> "
            + "</CENTER><HR><a href=\"http://somegreatsite.com\">Link Name</a>"
            + "is a link to another nifty site<H1>This is a Header</H1><H2>"
            + "This is a Medium Header</H2>Send me mail at <a href=\"mailto:"
            + "support@yourcompany.com\">support@yourcompany.com</a>.<P> This "
            + "is a new paragraph!<P> <B>This is me typing even more words "
            + "into the body to see if the HTMLGetter still apporpriately "
            + "manages to get all of the HTML source code.</B><P> this<P> is"
            + "<P> a<P> TEST!!<P> z<P> z<P> z<P> z<P> zzzzzzzzzzz<P> zzzzzzzz"
            + "zzzzzzzzzzzzzzzzzzz<P> zzzzzzzzzzzzzzz<P> zzzzzzzz<BR> <B><I>"
            + "This is a new sentence without a paragraph break, in bold "
            + "italics.</I></B><HR></BODY></HTML>";
    try {
      assertEquals(getter.getHTML(), htmlString);
    } catch (Exception e) {
      assertTrue(false);
    }
  }

  @Test
  public void testGetHTMLOnNonExistentFile() {
    /*
     * Test to determine if the HTMLGetter appropriately behaves when trying to
     * get the raw HTML code of a file that doesn't exist.
     * 
     * Expected result should be the raising of an exception that is to be
     * caught and evaluated.
     */
    getter = new RawHTMLGetter("this_isnt_a_file_in_the_repo.html");
    try {
      getter.getHTML();
    } catch (Exception e) {
      assertTrue(true);
    }
  }
}
