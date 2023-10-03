Our second coding dojo in broader team.

Preparation
* clone github project with README.md: https://github.com/aubi/coding-dojos
* I will add everybody to the project as collaborator
* everybody clones it, adds his/her name to README.md file, commits including git push!!!
* Have working Payara 6 server as we will deploy the developed application to it. Preferably with your IDE, it's simpler :-)
* Download JDBC driver from https://jdbc.postgresql.org/ and put it to glassfish/domains/domain1/lib

The database is available here (you can try to play with it, please, don't damage it):
url: jdbc:postgresql://home.aubrecht.net:15432/dvdrental
user: payara
password: codingDojoExample

Here are the commands you can use to create the JDBC Resources:

    asadmin create-jdbc-connection-pool --datasourceClassname=org.postgresql.ds.PGSimpleDataSource --resType=javax.sql.DataSource dvdrentalPool

    asadmin set resources.jdbc-connection-pool.dvdrentalPool.property.User=payara resources.jdbc-connection-pool.dvdrentalPool.property.URL=jdbc:postgresql://home.aubrecht.net:15432/dvdrental resources.jdbc-connection-pool.dvdrentalPool.property.Password=codingDojoExample

    asadmin ping-connection-pool dvdrentalPool

    asadmin create-jdbc-resource --enabled=true --poolName=dvdrentalPool --target=domain jdbc/dvdrental

I suggest to have some tool to access the database, e.g. DBeaver, https://dbeaver.io/


The plan is to try load data from database and display it. We will start from zero, so we'll very quickly go through the beginning:
* create, build and deploy Jakarta EE 10 project
  * hint:
    * https://www.mastertheboss.com/java-ee/jakarta-ee/a-maven-starter-for-jakarta-ee-projects/
    * mvn archetype:generate -DarchetypeGroupId=org.eclipse.starter -DarchetypeArtifactId=jakartaee10-minimal -DarchetypeVersion=1.1.0 -DgroupId=com.example -DartifactId=demo -Dprofile=api -Dversion=1.0.0-SNAPSHOT -DinteractiveMode=false
  * JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64/ mvn clean package
* make static page (something we know it works!)

Then we will start with database:
* create datasource in your Payara (everybody in his own Payara) + try ping
* create JPA Entity from table 'actor'
  * if generating, take care about 'film': remove 'specialFeatures' and 'fulltext'
* make EJB to list all actors
* make CDI bean to list all actors
* make JSF page with a table with all actors
* Still time?
  * make JSF page with details
  * make JSF page for edit/add
  * allow delete row
* Still too much time?
  * try primefaces
        <dependency>
            <groupId>org.primefaces</groupId>
            <artifactId>primefaces</artifactId>
            <version>12.0.0</version>
            <classifier>jakarta</classifier>
        </dependency>
        <html xmlns:p="http://primefaces.org/ui">
        https://www.primefaces.org/showcase/getstarted.xhtml
  * Bookmarkable pages

Rules
* one person is developing for 5 minutes, then pushes his/her work to shared repo (specific branch)
* next person pulls and continues for another 5 minutes
* we are all trying to develop the app with all features. As other people will continue, talk while you are coding!
