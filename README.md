### velocity-made-easier
simple and functional custom made velocity CLI template tester: uses JVM8 and Maven 3

### SETUP 

Install velocity dependencies.

```
mvn clean install
```

### LAUNCH

From terminal run
```
 mvn exec:java -Dexec.mainClass=com.jlopezmx.app.App
```
Produces
```
[INFO] Scanning for projects...
Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/mojo/exec-maven-plugin/maven-metadata.xml
Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/mojo/exec-maven-plugin/maven-metadata.xml (803 B at 1.0 kB/s)
[INFO] 
[INFO] -------------< com.jlopezmx.app:velocity-template-tester >--------------
[INFO] Building velocity-template-tester 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- exec-maven-plugin:3.1.0:java (default-cli) @ velocity-template-tester ---
[com.jlopezmx.app.App.main()] INFO com.jlopezmx.app.App - configuring engine properties
[com.jlopezmx.app.App.main()] INFO com.jlopezmx.app.App - configuring variables for template
[com.jlopezmx.app.App.main()] INFO com.jlopezmx.app.App - completed: verify your file: page.html
[com.jlopezmx.app.App.main()] INFO com.jlopezmx.app.App - good bye now...
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.325 s
[INFO] Finished at: 2023-06-11T16:37:16-07:00
[INFO] ------------------------------------------------------------------------
╭─ jaziel.lopez [software engineer-jlopez.mx]
```
### VERIFY

You should have a `page.html` parsed right after executing the program. 

### AUTHOR

* [me](https://jlopez.mx)

