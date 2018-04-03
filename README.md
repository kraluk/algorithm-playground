# algorithm-playground

[![Build Status](https://travis-ci.org/kraluk/algorithm-playground.svg?branch=master)](https://travis-ci.org/kraluk/algorithm-playground) [![codecov](https://codecov.io/gh/kraluk/algorithm-playground/branch/master/graph/badge.svg)](https://codecov.io/gh/kraluk/algorithm-playground) [![Dependency Status](https://www.versioneye.com/user/projects/57f2d4129907da004067f6dd/badge.svg?style=flat-square)](https://www.versioneye.com/user/projects/57f2d4129907da004067f6dd)

My own algorithm's place

#### List of implemented algorithms:

* TODO

#### List of available utils

* `FileGenerator`
* `Integers`
* `Logarithms`
* `Maths`
* `Multiples`

#### FAQ

* During the Gradle build there could be some exceptions be thrown like `Illegal reflective access by org.codehaus.groovy.reflection.CachedClass`. It's related to the [following Groovy bug](https://issues.apache.org/jira/browse/GROOVY-8339), which is directly connected to Java 9+ reflection restrictions. For now, we should live with it.. 