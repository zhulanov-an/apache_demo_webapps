package ru.sbtqa;

/**
 * Greeter class.
 */
public class Greeter {

  /**
   * Constructor of Greeter class.
   */
  public Greeter() {

  }


  /**
   * method greet.
   * @param name - value of greetings
   * @return - value "Hello, " + name + "!"
   */
  public final String greet(final String name) {
    return String.format("Hello, %s!", name);
  }
}
