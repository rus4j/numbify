# Numbify
![workflow](https://github.com/rus4j/numbify/actions/workflows/gradle.yml/badge.svg)
[![codecov](https://codecov.io/gh/rus4j/numbify/graph/badge.svg?token=L4MHCKGMQQ)](https://codecov.io/gh/rus4j/numbify)
[![Maven Central Version](https://img.shields.io/maven-central/v/org.rus4j/numbify)](https://central.sonatype.com/artifact/org.rus4j/numbify)

Numbify ia s Java library for transforming numbers into text with wide customization options.

## Usage
Add dependency into your project:
```xml
<dependency>
    <groupId>org.rus4j</groupId>
    <artifactId>numbify</artifactId>
    <verion>1.0.0</verion>
</dependency>
```
```groovy
implementation 'org.rus4j:numbify:1.0.0'
```
Use NumbifyBuilder:
```java
Numbify en = new NumbifyBuilder()
    .english(Currency.USD)
    .showIntegerCurrency(true)
    .showDecimalCurrency(true)
    .build();

String numberInText = en.toText(25.17); // "twenty five dollars seventeen cents"
```

## Languages
* 🇬🇧 English
* 🇷🇺 Russian

* others langs TBD

## Language features
Some languages have features the numerals text representations depend on.

For example russian have declensions, so it has additional builder method with declension as parameters.
```java
Numbify ru = new NumbifyBuilder()
    .russian(RuDeclension.GENITIVE, Currency.RUB)
    .showIntegerCurrency(true)
    .showDecimalCurrency(true)
    .build();

String number = ru.toText(123.45); // "ста двадцати трёх рублей сорока пяти копеек"
```
See the list of all supported language methods in javadoc.

## Options
There is also a set of options you can customize:
* `.showIntegerCurrency(true/false)` to show/hide currency for integer part of number
* `.showDecimalCurrency(true/false)` to show/hide currency for decimal part of number
* `.capitalize(boolean)` to capitalize each word (TBD)
* `.showIntOnly(boolean)` to show only integer part of number (TBD)
* `.showDecimalOnly(boolean)` to show only decimal part (TBD)
