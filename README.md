# Numbify
![workflow](https://github.com/rus4j/numbify/actions/workflows/gradle.yml/badge.svg)
[![codecov](https://codecov.io/gh/rus4j/numbify/graph/badge.svg?token=L4MHCKGMQQ)](https://codecov.io/gh/rus4j/numbify)

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
    .english().build();

String numberInText = en.toText(1234); // "one thousand two hundred thirty four"
```

## Languages
* 🇬🇧 English
* 🇷🇺 Russian

* others langs TBD

## Language features
Some languages have features the numerals text representations depend on.

For example russian have declensions and gender, so it has additional builder method with declension and gender as parameters.
```java
Numbify ru = new NumbifyBuilder()
    .russian(RuDeclension.GENITIVE, Gender.FEMALE)
    .build();

String number = ru.toText(121_041); // "Ста двадцати одной тысячи сорока одной"
```
See the list of all supported language methods in javadoc.

## Options
There is also a set of options you can customize:
* `.currency(String)` to add currency support (TBD)
* `.capitalize(boolean)` to capitalize each word (TBD)
* `.showIntOnly(boolean)` to show only integer part of number (TBD)
* `.showDecimalOnly(boolean)` to show only decimal part (TBD)
