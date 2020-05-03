JAVA TO  KOTLIN

## DECLARE CLASS

```kotlin
class KClass(parameter: String, 
             private val privateVal: Int, 
             val publicVal: Int, 
             private var privateVar: Int, 
             var publicVar: Int) {
    val selfMember = parameter.toUpperCase()
}
```

```java
final class JClass {
    private final int privateVal;
    public final int publicVal;
    private int privateVar;
    public int publicVar;
    public final String selfMember;

    JClass(String parameter,
           int privateVal,
           int publicVal,
           int privateVar,
           int publicVar) {
        this.selfMember = parameter.toUpperCase();
        this.privateVal = privateVal;
        this.publicVal = publicVal;
        this.privateVar = privateVar;
        this.publicVar = publicVar;
    }
}
```



## DECLARE PROPERTY

