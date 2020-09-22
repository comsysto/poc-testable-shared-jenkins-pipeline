# poc-testable-shared-jenkins-pipeline

A Proof of Concept on how to write a testable [Shared Jenkins Pipeline](https://jenkins.io/doc/book/pipeline/shared-libraries/).
You will need [Groovy installed](http://groovy-lang.org/install.html) on your workstation.

&nbsp;

### Use Shared Library Pricing in your Jenkinsfile

You can load and use the library in any job like so:

```
def comsystoPipeline = library('comsysto').com.comsysto.pipeline.Pipeline.new()

def someApi = comsystoPipeline.getSomeApi(this)

someApi.doStuff()
```

### Unit Tests of Shared Pipeline Code

```
groovy -cp src/ src/com/comsysto/pipeline/test/GitHelperTest.groovy
```


&nbsp;

### Configured as Global Pipeline Library in Jenkins

We configured the library globally so that it is automatically available in every job.

![](./doc/configured-as-global-library.png)


&nbsp;

### License

[MIT](./LICENSE)
