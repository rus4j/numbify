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
Add maven dependency into your project:
```xml
<dependency>
    <groupId>org.rus4j</groupId>
    <artifactId>numbify</artifactId>
    <verion>2.2.0</verion>
</dependency>
```
Gradle dependency:
```groovy
implementation 'org.rus4j:numbify:2.1.0'
```
The simplest example in English:
```java
Numbify en = new NumbifyBuilder()
    .english(Currency.USD)
    .build();
String numberInText = en.toText(25.17); // "twenty five dollars seventeen cents"
```

More complex example:
```java
Numbify ru = new NumbifyBuilder()
    .russian(RuDeclension.GENITIVE, Currency.NUMBER) // no specific currency in Genitive
    .originalDecimal()
    .capitalize()
    .build();
String numberInText = en.toText(25.17); // "Двадцати пяти целых 17 сотых"
```

Check full documentation and list of possible options on https://rus4j.org/numbify.

## Languages
* 🇬🇧 English
* 🇷🇺 Russian
* more TBD

## Data types
It supports any java numeric data types that are subclasses of `Number`
```
                               Number
 ┌──────┬───────┬───────┬─────┬──────┬─────────┬──────────┬─────────┐
 │      │       │       │     │      │         │          │
Byte  Short  Integer  Long  Float  Double  BigInteger  BigDecimal  ...
```
