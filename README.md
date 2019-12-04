# WordScramble
## A word scramble game usable by users of any skill level

###Directory and File Structure
Our project is divided into different packages - the program being located in scramble and test also existing to house unit tests to be implemented down the road. Within scramble, different subpackages exist, including model, view, controller, exception, element, and DAO; all these are prepended by scramble.* Each MVC subpackage holds the appropriate elements for different scenes Startup, Scramble, and Final. Exception would hold any custom exceptions that may be implemented in a future iteration, element holds custom objects like Score and User, and DAO contains access objects for the score and word databases. The program launches from WordScrambleGame.java, which contains the main method. At the same level as this exists Scrambler.java, our custom interface that holds the algorithms to scramble a String and assign a String a point value.

###Running the Program
Upon application startup, the user is prompted to input their initials and select a game difficulty. If the user attempts to advance without properly completing these steps, an error message pops up alerting the user they need to properly complete these fields.
After beginning the game, the user is able to enter a string into a text field. The goal is to match the input to the correct unscrambled version of the scrambled word at the center of the screen. When a user hits enter, the text field text is checked for correctness; a correct answer adds points and iterates the scrambled word. There is a timer that starts upon starting the game, and when it hits zero, the text field no longer accepts a user input. The user can then hit the continue button to finish the game and view the final screen. This action also records the user’s performance into the score database.
The final screen displays information such as the user’s initials, the score they achieved, and the difficulty they selected. They then have the option to quit the program or begin a new game, which then goes back to the startup screen and the whole process begins anew. A new ScrambleModel is created upon a new game startup, ensuring no older data is held onto or is overridden.

###Future Implementations
Some future considerations we would hope to utilize would be to continue keeping the different elements as decoupled as possible. Implementing unit tests on different operations completed would also be beneficial to ensuring the program works with future iterations, as decoupling the different elements could lead to breaks in different functionality between versions. 
Styling of the program was far from our first concern, but continuing to create a distinct visual style would aid in making the program much more visually appealing and add character to the program we put so much work into. More visual elements could include altering the color of the timer as the timer came closer to 0, as well as a leaderboard to display the top 10 or so scores stored in the scores database. 


