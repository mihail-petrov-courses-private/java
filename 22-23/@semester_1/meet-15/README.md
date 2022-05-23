## $какво разгледахме днес ?
- упражнение
- клас конструктор
- работа с geter и setter

## $задачи за упражнения
- [Работа в час](https://github.com/mihail-petrov/netit-webdev-java/tree/master/22-23/%40semester_1/week-08-2/cw)
- [Домашна работа](https://github.com/mihail-petrov/netit-webdev-java/tree/master/22-23/%40semester_1/week-08-2/hw)

## $други ресурси
- [видео](https://drive.google.com/file/d/16hz5g9OFPbqnjUMLGR2zGda1EEgcRi6B/view?usp=sharing)
- [сорс код](https://github.com/mihail-petrov/netit-webdev-java/tree/master/22-23/%40semester_1/week-08-2/source)

## Работа с geter и setter

Коментирахме че правилния подход за предпазване на нашите данни е свързан с използване на модификатора за видимост **private**, пред възможно най-много полета в класа. Това логично повдига въпроса, как можем да ползваме същите полета, при положение че те ефективно са напълно заключени и недостъпни. 

Тайната е да ползваме така наречените getters и setters. Въпреки специалните им имена, те не са нищо специално. Просто методи, които ползваме за работа с полета. Заслужили са своята слава, поради факта че са част от всеки клас и спазват еднотипна конвенция:

Целта на setter методите е да присвояват специфична стойност на private поле

```java

public class Product {

    private String productName;

    public void setProductName(String inputName) {
        productName = inputName;
    }
}
```

Целта на getter методите е да връщат private полета, на заинтересовани конструкции

```java

public class Product {

    private String productName;

    public String getProductName() {
        return productName;
    }
}
```



## Клас конструктор

Исползването на setter - методи, задължително има пожелателен характер. Няма как да гарантираме конструирането на правилен обект, без да тропнем с крак и да задължим програмиста да спазва правилата. За щастие добрата баба Java ни дава механизъм за справяне с този проблем, наречен клас конструктор:
- това е специален метод, носещ името на класа в който се намира
- конструктора е задължително с модификатор **public**
- конструктора няма специално дефиниран връщан тип

```java

public class Product {

    public Product() {

    }
}
```

Конструктора се извиква автоматично в момента в който създадем променлива от същия потребителски дефиниран тип 

```java
Product buyProduct = new Product();
```

Рестриктивния елемент, се изразява във възможността да подадем аргументи, които задължително трябва да удовлетворим при инициализиране на променливата.

```java

public class Product {

    private String name;

    public Product(int productName) {
        name = productName;
    }
}
```

Ако стойността не се подаде, резултата ще е катастрофална синтактична грешка

```java
Product buyProduct = new Product("Sample Product");
```