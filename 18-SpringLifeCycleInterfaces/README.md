# Spring Interfaces Life Cycle

Another use of bean life cycles, using inferfaces.

We implement the interface __InitializingBean__ and __DisposableBean__.

```java
public class Person implements InitializingBean, DisposableBean {

  private int id;
  private String name;
  private String surname;
  private Country country;

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return this.surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }


  public Country getCountry() {
    return this.country;
  }

  public void setCountry(Country country) {
    this.country = country;
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    System.out.println("Before the initialization of bean Person");
  }

  @Override
  public void destroy() throws Exception {
    System.out.println("After of the destructino of bean Person");
  }
}
```