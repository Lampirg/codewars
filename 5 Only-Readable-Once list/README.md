# [Only-Readable-Once list](https://www.codewars.com/kata/53f17f5b59c3fcd589000390)

## Description:

Attention Agent.

The White House is currently developing a mobile app that it can use to issue instructions to its undercover agents.

Part of the functionality of this app is to have messages that can be read only once, and are then destroyed.

As our best undercover developer, we need you to implement a SecureList class that will deliver this functionality.

Behaviour different to the traditional list is outlined below:

Accessing an item at any index should delete the item at that index eg:

```java
SecureList secureList = new SecureList(new int[]{1, 2, 3, 4});
System.out.println(secureList.get(1)); // prints 2
System.out.println(secureList);        // prints [1,3,4]
```

Printing the whole list should clear the whole list eg:

```java
SecureList secureList = new SecureList(new int[]{1, 2, 3, 4});
System.out.println(secureList); // prints [1,2,3,4]
System.out.println(secureList); // prints []
```

To complete this kata you need to be able to define a class that implements get(int index), toString(), and possibly size().

Good luck Agent.
