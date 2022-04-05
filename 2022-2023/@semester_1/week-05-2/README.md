## $какво разгледахме днес ?
- функционалност за генериране на случайни числа
- разлика между класа Math и класа Random

## $задачи за упражнения
- [Работа в час](https://github.com/mihail-petrov/netit-webdev-java/tree/master/2022-2023/%40semester_1/week-04-2/cw)
- [Самостоятелна работа](https://github.com/mihail-petrov/netit-webdev-java/tree/master/2022-2023/%40semester_1/week-04-2/hw)

## $други ресурси
- [видео](https://drive.google.com/file/d/1hRzT65_uEH8las9_sa5_21nyp8PHQ8lM/view?usp=sharing)
- [сорс код](https://github.com/mihail-petrov/netit-webdev-java/tree/master/2022-2023/%40semester_1/week-04-2/source)

## функционалност за генериране на случайни числа

Съществуват два начина за генериране на случайни числа, в езика Java.
- с помоща на метода random на класа Math
- с помоща на класа Random

Разликата между двата подхода е във връщания резултат. 
**Math.random()** връща дробно число, в интервала 0 до 1

```java
double randomDoubleResult = Math.random();
```
Класа **Random** предоставя набор от функционалности за връщане на цели и дробни числа
```java
Random randomGenerator = new Random();
randomGenerator.nextInt(10);
```