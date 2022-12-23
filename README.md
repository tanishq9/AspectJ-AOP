*Terminologies*
- Aspect: WHAT code we want to execute when we call a method
- Advice: WHEN aspect has to be executed, before/after/around the method call
- Pointcut: WHICH method inside app the framework needs to intercept and execute the aspect
- Join point: WHICH event triggers execution of aspect, this event is always a method call

*Types of advices*
- Before: Runs before a matched method execution
- AfterReturning: Runs when a matched method execution completes normally
- AfterThrowing: Runs when matched method execution exits by throwing an exception
- After: Runs no matter how a matched method execution exits.
- Around: To get control over before and after method execution and to determine when, how and even if method actually gets to run.

*Configuring Advices*
- We can use the AspectJ pointcut expression to provide details to Spring about what kind of methods it needs to intercept by mentioning details about the modifier, return type, name pattern, package name pattern, params patter, exceptions pattern, etc.
- Below is the format for same:

```
execution(modifiers-pattern? return-type-pattern package-class-name-type-pattern?method-name-pattern(param-pattern) throws-pattern?)

'?' implies not mandatory

Example: execution(* com.example.services.*.*(..))

Any return type, Any package with prefix: com.example.services, having any method with any number of parameters

This is the execution *expression approach* for pointcut expression.
```

- Another approach is to use annotation approach.
  - Create an annotation type.
  - Mention the same annotation on top of method which we want to intercept using AOP.
  - Use the annotation details to configure on top of the aspect method to advice.


*Order of Aspect execution*
- We can mention @Order(int) annotation in Spring AOP or DeclarePrecedence annotation in AspectJ on top of the class having @Aspect annotation.
- The aspect logic would be applied in that order or sequence, in case any exception is thrown from a particular aspect then following aspects won't be applied.

*Weaving (Specific to Spring framework)*
- It is a concept inside AOP in which spring framework controls all the interception of java methods and apply aspect logic with the help of proxy object.
- Steps
  - Add @EnableAspectJAutoProxy in @Configuration class
  - Add @Aspect and @Component in the aspect logic method class

More here
- https://docs.spring.io/spring-framework/docs/2.5.5/reference/aop.html
- https://dev.to/pavankumar1234/aspectj-gradle-retry-java-method-on-exception-6b6
- https://dzone.com/articles/different-types-of-aspectj-weaving

*Note*
- Gradle version 6.7 was incompatible with io.freefair.aspectj.post-compile-weaving plugin, gradle version 7.4+ working alright.