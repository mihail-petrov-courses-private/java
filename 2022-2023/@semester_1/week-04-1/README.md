# Упражнение - оператори / условни конструкции

## $какво разгледахме днес ?
- вложени **if** / **else** конструкции
- **else if** конструкции
- живот / видимост на променлива в рамките на IF конструкция
- работа с **.equals()** при сравнение на низове

## $задачи за упражнения
- [Работа в час](https://github.com/mihail-petrov/netit-webdev-java/tree/master/2022-2023/%40semester_1/week-04-1/cw)

## $други ресурси
- [сорс код](https://github.com/mihail-petrov/netit-webdev-java/tree/master/2022-2023/%40semester_1/week-04-2/source)
- [видео]()

# Комбинирани if / else / else if конструкции

Съществуват три комбинации от условни конструкции:
- самостоятелен **if** изпълнява се само и единствено ако условието е true
- самостоятелен **else** изпълнява се само и единствено, ако условието в горния IF е **false**
- комбиниран **else if** изпълнява се само и единствено ако условието в горния IF е **false** и условието в текущия if е **true**

```java
if(partyId == PARTY_ID_1) {
    System.out.println("Вие си поръчахте да ви управлява " + PARTY_TITLE_1);
}
else if(partyId == PARTY_ID_27) {
    System.out.println("Вие си поръчахте да ви управлява " + PARTY_TITLE_27);
}
else if(partyId == PARTY_ID_666) {
    System.out.println("Вие си поръчахте да ви управлява " + PARTY_TITLE_666);
}
else if(partyId == PARTY_ID_999) {
    System.out.println("Вие си поръчахте да ви управлява " + PARTY_TITLE_999);
}
else {
    System.out.println("Не съществува такава партия, вашия вот е невалиден");
}
```

# Живот / видимост на променливи

Условните конструкции са независими и тоталитарни, всяка една променлива, която е родена и живея в тях не може да напусне очертанията на **отварящата** и **затваряща** скоба на IF-а.

```java
if(isPotentialTaxEvader) {

    System.out.println(TAX_EVADER_MESSAGE);
    String questionAnswer   = inputScanner.next();
    isTaxEvader             = questionAnswer.equals(ANSWER_YES); // външна променлива
    String message          = (isTaxEvader) ? "Браво моето момче" : "Будала";
    System.out.println(message);
}

System.out.print(questionAnswer); // Грешка променливата не е видима извън IF блока
```

 Ако се случи немислимото и се опитаме да достъпим променлива извън границата на IF конструкцията ще получим съобщение, което гласи недефинирана променлива. За сметка на това всяка променлива, която е родена и живее в рамките на **main** метода, може да идва на гости в рамките на произволна IF конструкция - двоен стандарт **:(**

# Сравнение на низове

Текстовите низове, се сравняват с метода 

```java
String answer = "YES";
if(questionAnswer.equals(answer)) {
    System.out.print("Ok")
}
```