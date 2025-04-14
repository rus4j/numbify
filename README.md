Numbify is a Java object-oriented library for converting numbers into text with extensive customization options. 
There are two ways to use it:
* NumbifyBuilder: Customize the conversion using the provided builder methods.
* Direct Object Composition: Combine the library's objects in any way you need for greater flexibility.

# NumbifyBuilder
The base setup requires a language-specific method with at least a `Currency` parameter.
```java
Numbify en = new NumbifyBuilder()
    .english(Currency.USD)
    .build();
String numberInText = en.toText(25.17); // "twenty-five dollars seventeen cents"
```

### Language features
Some languages have grammatical features that affect how numbers are represented in text.

For example, **Russian** uses **declensions**, so the builder includes an additional method to specify them:
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
For advanced customization, Numbify allows direct object composition following the decorator pattern. 
This approach provides granular control over number formatting by combining specialized components.

Core Concept:
* Modular Design: Each formatting option (language, currency, int/decimal handling) is a separate component
* Decorator Pattern: Components wrap each other to build complex formatting pipelines
* Base Class: All compositions start with the Numbify root class

Minimal example:
```java
Numbify ru = new Numbify(
    new Russian(Currency.NUMBER),
    new IntText(new Text()) // just int text
);
ru.toText(123.12); // сто двадцать три
```
To include currency text in your output, wrap the `IntText` component with `IntCurrencyText`:
```java
Numbify ru = new Numbify(
    new Russian(Currency.NUMBER),
    new IntCurrencyText(new IntText(new Text())) // just int text with currency
);
ru.toText(123.12); // сто двадцать три целых
```
Next, you need decimals also. Same principle as for integers, use `DecimalText`, or `DecimalCurrencyText`
and combine the result with `CombinedText`:
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
Use `IntOriginalText` or `DecimalOriginalText` to maintain original numeric values in specific portions of the output text:
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
 │       │        │        │      │       │          │           │
Byte  Short  Integer  Long  Float  Double  BigInteger  BigDecimal  ...
```

