Concurrency

The task: call multiple independent tasks.

Use: ManagedExecutorService
https://jakarta.ee/specifications/concurrency/3.0/jakarta-concurrency-spec-3.0.html#managedexecutorservice
e.g.

	@Resource
	private ManagedExecutorService mes;

As a task, we can calculate factorial (about 100_000!).

Create a JSF page with list of numbers (simple edit is enough, separated by comma like "100000,200000,300000").
From this page, button calls a service, which will calculate histograms of all numbers and displays results.

Step 1: calculate sequentially
Step 2: calculate in parallel, mes.submit(...)
Step 3: configure in Payara AdminUI (modify default ManagedExecutorService setup)
Step 4: define our own ManagedExecutorDefinition

	@ManagedExecutorDefinition(name = "java:app/myMES", maxAsync = 2)

	@Resource(lookup = "java:app/myMES")
	private ManagedExecutorService mes;


Now, let's try another flavour of concurrency -- scheduler.

Step 5: schedule something (ping in log is enough, annotate a Singleton method with Schedule
Step 6: use ManagedScheduledExecutorService to start&stop ticking, method is scheduleAtFixedRate


* OPTIONAL: Try to implement starting the calculation and monitor its progress, manual refresh of a page is enough.



------------8<-------->8-------------