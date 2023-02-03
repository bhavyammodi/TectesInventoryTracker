# Inventory Tracker
A simple Java program to track stock of items.
Sample input:
```java = 
"2022/01/01", "2022/01/03", 5
"2022/01/01", "2022/01/05", 10
"2022/01/03", "2022/01/05", 7
"2022/01/02", "2022/01/04", 6
```

Sample Output:
```java=
From 2022/01/01 to 2022/01/02, Stock = 15, indices = 0 1 
From 2022/01/02 to 2022/01/03, Stock = 21, indices = 0 1 3 
From 2022/01/03 to 2022/01/04, Stock = 23, indices = 1 2 3 
From 2022/01/04 to 2022/01/05, Stock = 17, indices = 1 2 
```
(Here -1 signifies that the stock is there for infinite time)
