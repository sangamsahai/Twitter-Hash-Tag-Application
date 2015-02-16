# Twitter-Hash-Tag-Application
This application gets most recent 100 tweets for any given hash tag


This application accepts a Hash Tag from user as input and prints the most recent 100 tweets with that HashTag.
I have coded this application in Java (Java version "1.7.0_51").
I have used Twitter4J API for this.

Directions to run this application-

1) I have bundled the code along with the Twitter4J API libraries in TwitterHashTagApplication.jar
You can execute this jar from command line.
But make sure that Java is installed properly in the system , in which you are trying to execute this jar file .
The PATH and CLASSPATH environment variables should be set adequately.

The command used to run this jar file is -   java -jar TwitterHashTagApplication.jar

When this jar is executed , the application asks the user to enter the Hash Tag (without the Hash Symbol).
If the Hash Tag entered is valid, this application lists most recent 100 tweets with that Hash Tag.
If a invalid Hash Tag is entered , then the application prints 'The Hash Tag entered is wrong !!' 


2) If in any case , you can not execute this jar from command line , I have also included the Java Source Code for this application(TwitterHashTag.java).
Just add Twitter4J libraries to your application classpath (This libraries also have been included in this folder).
And the run the file   TwitterHashTag.java as a java application.
