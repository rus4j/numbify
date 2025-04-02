# Numbify
[![EO](https://www.elegantobjects.org/badge.svg)](https://www.elegantobjects.org/)

![workflow](https://github.com/rus4j/numbify/actions/workflows/gradle.yml/badge.svg)
[![codecov](https://codecov.io/gh/rus4j/numbify/graph/badge.svg?token=L4MHCKGMQQ)](https://codecov.io/gh/rus4j/numbify)
[![Maven Central Version](https://img.shields.io/maven-central/v/org.rus4j/numbify)](https://central.sonatype.com/artifact/org.rus4j/numbify)
![LOC](https://raw.githubusercontent.com/rus4j/numbify/gh-pages/loc-badge.svg)
[![Hits-of-Code](https://hitsofcode.com/github/rus4j/numbify?branch=master&label=Hits-of-Code)](https://hitsofcode.com/github/rus4j/numbify/view?branch=master&label=Hits-of-Code)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/5683645ec8914bba99fbb16142656118)](https://app.codacy.com/gh/rus4j/numbify?utm_source=github.com&utm_medium=referral&utm_content=rus4j/numbify&utm_campaign=Badge_Grade)


Numbify ia s Java library for transforming numbers into text with wide customization options.

Inspired by [Ant1mas/number-to-words-ru](https://github.com/Ant1mas/number-to-words-ru)

## Usage
Add dependency into your project:
```xml
<dependency>
    <groupId>org.rus4j</groupId>
    <artifactId>numbify</artifactId>
    <verion>2.0.0</verion>
</dependency>
```
```groovy
implementation 'org.rus4j:numbify:2.0.0'
```
Each language has dedicated method with at least currency as a mandatory paramemeter.
The simplest example:
```java
Numbify en = new NumbifyBuilder()
    .english(Currency.USD)
    .build();
String numberInText = en.toText(25.17); // "twenty five dollars seventeen cents"


Numbify ru = new NumbifyBuilder()
    .russian(Currency.NUMBER) // no specific currency
    .build();
String numberInText = en.toText(25.17); // "двадцать пять целых семнадцать сотых"
```

## Languages
* 🇬🇧 English
* 🇷🇺 Russian
* more TBD

## Language features
Some languages have features the numerals text representations depend on.

For example russian have declensions, so it has additional builder method with declension as parameters.
```java
Numbify ru = new NumbifyBuilder()
    .russian(RuDeclension.GENITIVE, Currency.RUB)
    .build();

String number = ru.toText(123.45); // "ста двадцати трёх рублей сорока пяти копеек"
```

## Data types
It supports any java numeric data types that are subclasses of `Number`
```
                               Number
 ┌──────┬───────┬───────┬─────┬──────┬─────────┬──────────┬─────────┐
 │      │       │       │     │      │         │          │
Byte  Short  Integer  Long  Float  Double  BigInteger  BigDecimal  ...
```

## Options
There is also a set of options you can customize:
### Hide integer currency
Hide currency for interger part of number
```java
Numbify en = new NumbifyBuilder()
    .english(Currency.USD)
    .hideIntCurrency()
    .build();

String numberInText = en.toText(25.17); // "twenty five seventeen cents"
```
### Hide decimal currency
Hide currency for decimal part of number
```java
Numbify en = new NumbifyBuilder()
    .english(Currency.USD)
    .hideDecimalCurrency()
    .build();

String numberInText = en.toText(25.17); // "twenty five dollars seventeen"
```

* `.capitalize(boolean)` to capitalize each word (TBD)
* `.showIntOnly(boolean)` to show only integer part of number (TBD)
* `.showDecimalOnly(boolean)` to show only decimal part (TBD)
