package eg.edu.alexu.csd.datastructure.hangman.cs60;

import org.junit.Assert;
import org.junit.Test;

import eg.edu.alexu.csd.datastructure.hangman.IHangman;

/**
 * @author Mohamed Mashaal.
 *
 */
public class Tests {

  /**
   * Instace for the tests !!!.
   */
  private Hangman test = new Hangman();

  /**
   * testing the implementation.
   */
  @Test
  public void testRandomWord() {
    final IHangman hangman = test;
    String secret = hangman.selectRandomSecretWord();
    Assert.assertNull("Random word returned", secret);
    final String[] dictionary = new String[] {"XXX", "YYYY" };
    hangman.setDictionary(dictionary);
    secret = hangman.selectRandomSecretWord();
    Assert.assertNotNull("Null random word", secret);
    boolean found = false;
    for (int i = 0; i < dictionary.length; i++) {
      if (dictionary[i].equals(secret)) {
        found = true;
      }
    }
    Assert.assertTrue("Message not found", found);
  }
  /**
   * testing the implementation.
   */
  @Test
  public void testWrongGuess() {
    final IHangman hangman = test;
    final String[] dictionary = new String[] {"EGYPT" };
    hangman.setDictionary(dictionary);
    hangman.selectRandomSecretWord();
    hangman.setMaxWrongGuesses(2);
    Assert.assertEquals("-----", hangman.guess('X'));
  }
  /**
   * testing the implementation.
   */
  @Test
  public void testCorrectGuess() {
    final IHangman hangman = test;
    final String[] dictionary = new String[] {"EGYPT" };
    hangman.setDictionary(dictionary);
    hangman.selectRandomSecretWord();
    hangman.setMaxWrongGuesses(2);
    Assert.assertEquals("--Y--", hangman.guess('Y'));
  }
  /**
   * testing the implementation.
   */
  @Test
  public void testCorrectGuessFirstChar() {
    final IHangman hangman = test;
    final String[] dictionary = new String[] {"EGYPT" };
    hangman.setDictionary(dictionary);
    hangman.selectRandomSecretWord();
    hangman.setMaxWrongGuesses(2);
    Assert.assertEquals("E----", hangman.guess('E'));
  }
  /**
   * testing the implementation.
   */
  @Test
  public void testCorrectGuessLastChar() {
    final IHangman hangman = test;
    final String[] dictionary = new String[] {"EGYPT" };
    hangman.setDictionary(dictionary);
    hangman.selectRandomSecretWord();
    hangman.setMaxWrongGuesses(2);
    Assert.assertEquals("----T", hangman.guess('T'));
  }
  /**
   * testing the implementation.
   */
  @Test
  public void testCaseSensitiveLower() {
    final IHangman hangman = test;
    final String[] dictionary = new String[] {"EGYPT" };
    hangman.setDictionary(dictionary);
    hangman.selectRandomSecretWord();
    hangman.setMaxWrongGuesses(2);
    Assert.assertTrue("E----".equalsIgnoreCase(hangman.guess('e')));
  }
  /**
   * testing the implementation.
   */
  @Test
  public void testCaseSensitiveUpper() {
    final IHangman hangman = test;
    final String[] dictionary = new String[] {"egypt" };
    hangman.setDictionary(dictionary);
    hangman.selectRandomSecretWord();
    hangman.setMaxWrongGuesses(2);
    Assert.assertTrue("E----".equalsIgnoreCase(hangman.guess('E')));
  }
  /**
   * testing the implementation.
   */
  @Test
  public void testFailCount() {
    final IHangman hangman = test;
    final String[] dictionary = new String[] {"EGYPT" };
    hangman.setDictionary(dictionary);
    hangman.selectRandomSecretWord();
    final int max = 5;
    hangman.setMaxWrongGuesses(max);
    for (int i = 0; i < max; i++) {
      final String result = hangman.guess('X');
      if (i < max - 1) {
        Assert.assertEquals("Invalid Showing of Characters",
            "-----",
            result);
      } else {
        Assert.assertNull("Game must end!", result);
      }
    }
  }

}
