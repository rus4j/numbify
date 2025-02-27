# Numbify
![workflow](https://github.com/rus4j/numbify/actions/workflows/gradle.yml/badge.svg)

Numbify ia s Java library for transforming numbers into text with wide customization options.

## Usage:
```java
Numbify en = new NumbifyBuilder()
    .language(new English())
    .declension(EnDeclension.COMMON)
    .build();

String numberInText = en.toText(1234); // "one thousand two hundred thirty four"
```

## Languages
* 🇬🇧 English
* 🇷🇺 Russian
* others langs in progress

## Options
...
