1.This is a rudimentary Android application that uses the Plivo API in order to place a call from a predetermined number to the phone number specified by the user.

2.Once the call is received, the reponse "Welcome to the jungle!" is played.

3.As soon as the response is received, the call is then forwarded to Mr.Sandeep at Plivo (predetermined).

4.The native Android app was built in Android Studio and utilizes Gradle Build. The newly released Plivo Android SDK was not used as per the instructions.

5.The UI consists of a simple Number Input and a Button. The recepient phone number is expected as input. On tapping the Call button, the call is placed to the recepient.

6.The first version of the app was built to make REST API calls to the necessary Plivo API i.e Outbound Call API using simple HttpUrlConnection method of Java. The query was in the form of a URL containing parameters in a key-value pair format.

7.Later, I came across the Java Helper Library of Plivo and found it to be much better, safer and robust than making a raw REST API call from the native Android app. Therefore, the Java Helper Library was included in the project and was used to place calls by invoking the necessary functions of the RestAPI class.

8.The XML response that the Plivo API expected was a simple static XML file that hosted on localhost with ngrok tunneling for external access.
