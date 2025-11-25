Text blocks

switch
*  "->", no break
* switch as a value
* instanceof where, case null
* enum branches (verifies completeness)
records
* as DTO
* equals
* toString
* hashValue
* add methods, constructors
sealed classes (non-sealed)
patter matching
instanceof
switch
Set.of duplicates

Garbage collector changes
https://docs.oracle.com/en/java/javase/25/gctuning/available-collectors.html
$ java -XX:+UseZGC
# Use Generational ZGC 
$ java -XX:+UseZGC -XX:+ZGenerational
