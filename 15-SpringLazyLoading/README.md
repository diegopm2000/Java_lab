# Spring Lazy loading

By default, Spring load all beans in memory.

We can use lazy loading for better resource management. With this loading, they will only be instantiated when necessary, for example in a getBean call