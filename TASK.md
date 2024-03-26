# Task

This week, we'll continue on Concurrency, especially with the Scheduled Executor this time.

We will create a new app, you don't need to review last CD.

The task:

Step 1: Bootstrap JEE app with JSF (as usual, very quick)

Step 2: Let's do a timer, running every second, which will just increase a number. Display this number. Make a button to start and another to stop the timer.

hint: ManagedScheduledExecutorService is our friend.



Step 3:

Something more cool? Let's make a watchdog -- deploy cluster.jsp to your server. Then create a scheduler to check the availability of the app.

hint: https://www.baeldung.com/java-http-request



Step 4: For regular, less frequent tasks, Scheduler by annotation is simpler. Try to download Chuck Norris joke of the day: https://api.chucknorris.io/jokes/random

hint: https://jakarta.ee/specifications/platform/10/apidocs/jakarta/ejb/schedule
