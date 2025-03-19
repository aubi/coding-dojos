Asynchronous processing
* We will receive REST calls with data (e.g. robot's measures)

Example:
curl -i -X POST -H "Content-Type: application/json"  -d '{"sourceId":719966,"time":81207.87613,"position":56,"temperature":46,"label":7097}' http://localhost:8080/async/api/data/async
http://localhost:8080/async/api/data/exec
http://localhost:8080/async/api/data/asyncConc
http://localhost:8080/async/api/data/jms

Process this data asynchronously
* Use JAX-RS for API
* Use various ways to make it asynchronous:
** ManagedExecutorService: https://jakarta.ee/specifications/platform/10/apidocs/jakarta/enterprise/concurrent/managedexecutorservice
** @Asynchronous: https://jakarta.ee/specifications/platform/10/apidocs/jakarta/enterprise/concurrent/asynchronous
** JMS: https://c2b2.sharepoint.com/:f:/g/Payara/EnjJqM4Hmd9JiMIGE2IbLpwBnvHHldQkkgS3ETyFjtosOg?e=q9qUMZ
** Virtual threads -> next time, Jakarta EE 11

What are the differences?

For bigger tests, I have a testing app, I'll share it during the CD.

Petr
Patrik
Gaurav
Flavio
Luis
Kalin
Andrew
Rhys
Rohan

