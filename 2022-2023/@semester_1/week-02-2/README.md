# Още типове данни и операции с тях

## $какво разгледахме днес ?
- Мистероизната сила на оператора + при работа със стрингове и числа
- Оператори за сравнение
- Тернарен оператор и избор на множество възможности
- Въвеждане на данни от конзолата

## $задачи за упражнения
- [Работа в час](https://github.com/mihail-petrov/netit-webdev-java/tree/master/2022-2023/%40semester_1/week-02-2/cw)
- [Самостоятелна работа](https://github.com/mihail-petrov/netit-webdev-java/tree/master/2022-2023/%40semester_1/week-02-2/hw)

## $други ресурси
- [сорс код](https://github.com/mihail-petrov/netit-webdev-java/tree/master/2022-2023/%40semester_1/week-02-2/source)
- [видео]()

### Работа с оператора (+)
Математиката ни преследва и в света на програмирането. Оператора за събиране може да се ползва, за събиране на числови стойности. Неговата употреба се случва винаги в дясната част на оператора **за присвояване =**

```java
int playerScoreAmount   = 10;
int questionPointAmount = 5;
playerScoreAmount       = (playerScoreAmount + questionPointAmount) + 5;
```

Когато единият от операндите е текстов низ, оператора **+** рязко променя своята функция. Събирането на низ и произволен друг тип води до слепване на стойностите (**конкатенация**). В примера контакенираме число и текст, за да получим приятел и информативен текст.

```java
int age         = 10;
String message  = "Аз съм на " + age + " години";
System.out.print(message);
```

### Оператори за сравнение
Операторите за сравнение, винаги проверяват отношението между две стойности или променливи. Различаваме 4 оператора (и два комбинирани):
- ==
- >  / >=
- <  / <=
- !=

**Важно** - Операторите за сравнение винаги връщат булева стойност.

оператор за равенство
```java
boolean isMonday  = dayOfTheWeek == "Monday";
```

оператор за неравенство
```java
boolean isAdult   = age >= 18;
boolean isTeen    = age <= 19;
```

оператор за различно от стойност
```java
boolean isSuccessfulStudent = grade != 3;
```

### Тернарен (троен) оператор
Троиния оператор е специална конструкция, която връща стойност в зависимост от оценката на специфичен израз. Оператора оценява, булева стойност или резултат от оператор за сравнение.

```java
boolean isQuestionEasy = questionNumber < 5;
String questionType    = (isQuestionEasy        ) ? "Лесен въпрос"  : "Труден въпрос";
String questionType    = (questionNumber > 5    ) ? "Труден въпрос" : "Лесен въпрос";
String questionType    = (questionNumber >= 5   ) ? "Труден въпрос" : "Лесен въпрос";
String questionType    = (hintCount == 0        ) ? "Труден въпрос" : "Лесен въпрос";
String questionType    = (hintCount != 3        ) ? "Труден въпрос" : "Лесен въпрос";
```

В зависимост от резултата, от булевия израз, може да се изпълни:
- израза след **?** - ако ключовия израз е TRUE.
- израза след **:** - ако ключовия израз е FALSE.

Можем да влагаме, изразите един в друг, като така постигаме по сложна конструкция.

```java
        boolean isMonday    = dayOfTheWeek == "Monday";
        boolean isThuesday  = dayOfTheWeek == "Thuesday";
        boolean isWednesday = dayOfTheWeek == "Wednesday";
        boolean isTursday   = dayOfTheWeek == "Tursday";
        boolean isFriday    = dayOfTheWeek == "Friday";
        String dayOfTheWeekFirstLetter =    isMonday
                                            ? "M"
                                            : isThuesday
                                                ? "Th"
                                                : isWednesday
                                                    ? "W"
                                                    : isTursday
                                                        ? "Tu"
                                                        : isFriday
                                                            ? "F"
                                                            : "X";
```                                                            

### Въвеждане на данни от конзолата

За четене на данни, ползваме потребителския тип **Scanner**

```java
Scanner customScanner = new Scanner(System.in);
```

Новосъздадената променлива, съдържа в себе си множество функции за работа с входни данни:
- можем да четем текст и да го превръщаме в число
- можем да четем дълъг текст

Примерната програма, чете първо и фамилно име на потребител и го извежда на командния ред. 
При стартиране на програмата, се чака за изрично въвеждане на информация и натискане на клавиша **Enter**, за изпращане на въведените данни. 

```java
System.out.println("Моля въведете вашето първо име:");
String playerFirstName = customScanner.nextLine();
System.out.println("Моля въведете вашето фамилно име:");
String playerLastName = customScanner.nextLine();
String fullName = playerFirstName + " " + playerLastName;
System.out.println(fullName);
```