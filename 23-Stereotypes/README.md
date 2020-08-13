# Stereotypes

## 1. Component

Mark a class with Compnent annotation, allows us to avoid declaring it in beans.xml

```java
@Component
public class Player {

    private int number;
    private String name;
    @Autowired
    @Qualifier("barcelonaqualifier")
    private ITeam team;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ITeam getTeam() {
        return team;
    }

    public void setTeam(ITeam team) {
        this.team = team;
    }
}
```

And in xml we need to add 

```xml
<context:component-scan base-package="com.samplestereotypes"></context:component-scan>
```

In App.java, we need to change "messi" to "player", because @Componet use the name of the class as identifier.

```java
Player player = (Player) appContext.getBean("player");
```

## 2. Use of identifier

We add a identifier("messi") to @Component and @Value("messi lionel") to name

```java
@Component("messi")
public class Player {

    private int number;
    @Value("messi")
    private String name;
    @Autowired
    // @Qualifier("barcelonaqualifier")
    private ITeam team;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ITeam getTeam() {
        return team;
    }

    public void setTeam(ITeam team) {
        this.team = team;
    }
}

```

In App.java, we can use "messi" as identifier

```java
Player player = (Player) appContext.getBean("messi");
```

## 3. Another annotations

@Controller
@Service
@Repository

These annotations have the same behaviour as Component, but we will use to better naming of our layers in the project.