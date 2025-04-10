Numbify ia s Java object oriented library for transforming numbers into text with wide customization options.
There are 2 ways of using it.
* First one is NumbifyBuilder. You can customize it using existing builder methods.
* Second one is using objects itself and combine them in any way you want.

# NumbifyBuilder
Base (minimal) setup must have language specific method with at least currency as a mandatory parameter.
```java
Numbify en = new NumbifyBuilder()
    .english(Currency.USD)
    .build();
String numberInText = en.toText(25.17); // "twenty-five dollars seventeen cents"
```

### Language features
Some languages have features the numerals text representations depend on.

For example Russian have declensions, so it has additional builder method with declension as parameters.
```java
Numbify ru = new NumbifyBuilder()
    .russian(RuDeclension.GENITIVE, Currency.RUB)
    .build();

String number = ru.toText(123.45); // "ста двадцати трёх рублей сорока пяти копеек"
```

English has option to customize separator between integer and decimal parts of the number:
```java
Numbify en = new NumbifyBuilder()
    .english(Currency.USD, "and") // "and" as decimal separator
    .build();
String numberInText = en.toText(25.17); // "twenty-five dollars and seventeen cents"
```

### Options
There is also a set of options you can customize:
```java
Numbify en = new NumbifyBuilder()
    .english(Currency.USD)
    .hideIntCurrency()     // hide currency text for integer part of the number
    .hideDecimalCurrency() // hide currency text for decimal part
    .originalInt()         // do not convert integer part, leave it as number
    .originalDecimal()     // do not convert decimal part
    .capitalize()          // print text with capital letter
    .build();
```
Example:
```java
Numbify en = new NumbifyBuilder()
    .english(Currency.USD)
    .originalDecimal()
    .capitalize()
    .build();

String numberInText = en.toText(25.17); // "Twenty-five dollars 17 cents"
```

# Objects
This way of using Numbify implies that you will combine your own setup from existing objects.
That gives you much more possibilities to customize your result. Combining of objects based on decorator pattern.
Base class the user interact with is `Numbify`. And you put all options you need inside it as bricks in lego.
A minimum constuction will look like:
```java
Numbify ru = new Numbify(
    new Russian(Currency.NUMBER),
    new IntText(new Text()) // just int text
);
ru.toText(123.12); // сто двадцать три
```
If you need currency text, just wrap `IntText` like this:

```java
Numbify ru = new Numbify(
    new Russian(Currency.NUMBER),
    new IntCurrencyText(new IntText(new Text())) // just int text with currency
);
ru.toText(123.12); // сто двадцать три целых
```
Next, you need decimals also. Same principle as for integers, use `DecimalText`, or `DecimalCurrencyText`
and combine the result with `CombinedText`
```java
Numbify ru = new Numbify(
    new Russian(Currency.NUMBER),
    new CombinedText(
        new IntCurrencyText(new IntText(new Text())),
        new DecimalCurrencyText(new DecimalText(new Text()))
    )
);
ru.toText(123.12); // сто двадцать три целых двенадцать сотых
```
Use `IntOriginalText` or `DecimalOriginalText` to leave any parts as numbers
```java
Numbify ru = new Numbify(
    new Russian(Currency.NUMBER),
    new CombinedText(
        new IntCurrencyText(new IntText(new Text())),
        new DecimalCurrencyText(new DecimalOriginalText()) // use original decimal
    )
);
ru.toText(123.12); // сто двадцать три целых 12 сотых
```
Finally, wrap combined text with `CapitalizedText`:
```java
Numbify ru = new Numbify(
    new Russian(Currency.NUMBER),
    new CapitalizedText(     // make the first letter capital
        new CombinedText(
            new IntCurrencyText(new IntText(new Text())),
            new DecimalCurrencyText(new DecimalOriginalText())
        )
    )
);
ru.toText(123.12); // Сто двадцать три целых 12 сотых
```

## Data types
It supports any java numeric data types that are subclasses of `Number`
```
                               Number
 ┌──────┬───────┬───────┬─────┬──────┬─────────┬──────────┬─────────┐
 │      │       │       │     │      │         │          │
Byte  Short  Integer  Long  Float  Double  BigInteger  BigDecimal  ...
```

