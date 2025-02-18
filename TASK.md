# Java 21

## Overall Task -- Play with New Features

Petr shared some voting data:
http://petr.aubrecht.net/work/cd/apportionment-2020-tableA.csv

Source
https://www.census.gov/population/www/socdemo/voting.html

### HttpClient

Download the CSV file from the web. It's tab-delimited.


### Streams

Make a stream of the data.

Hint: consider using record.

Make SOME statistics (max, min, avg, ratios etc.)

Hint: Can we use Collectors.teeing?

### Virtual Threads -- Web

Make a simple web app with REST endpoint, which will wait for a random time (e.g. up to 100 ms). Deploy it to Payara.

Write a simple client, which will call this endpoint -- as many threads as possible. Compare both platform and virtual threads.

### Virtual Threads -- Local Network Scanner

Try to write a version of `aping` -- tool, which scans the local network and tries to ping them (`isAlive`). Generate a report with the results.
