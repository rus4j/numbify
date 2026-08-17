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
    <verion>2.4.0</verion>
</dependency>
```
Gradle dependency:
```groovy
implementation 'org.rus4j:numbify:2.4.0'
```
`Numbify` uses the Decorator pattern to compose number-to-text transformations.
This gives you full control over how your numbers are converted 
and allows you to build complex transformations by wrapping simple components.

### Basic Example
```java
Numbify en = new Numbify(
    new English(Currency.USD),
    new CombinedText(
        new IntCurrencyText(new IntText(new Text())),
        new DecimalCurrencyText(new DecimalText(new Text()))
    )
);
String result = en.toText(25.17); // "twenty five dollars seventeen cents"
```

### Customization Example
Add decorators to customize the output:
```java
Numbify en = new Numbify(
    new English(Currency.USD),
    new CapitalizedText(
        new NegativeSignText(
            new CombinedText(
                new IntCurrencyText(new IntText(new Text())),
                new DecimalCurrencyText(new DecimalText(new Text()))
            )
        )
    )
);
String result = en.toText(-123.45); // "Negative one hundred twenty-three dollars forty-five cents"
```

## Core Components

Numbify provides several decorator types that you can compose:

### Text Processing Decorators
- **`CapitalizedText`** - Capitalizes the first letter of the output
- **`NegativeSignText`** - Converts the minus sign to text (e.g., "negative" or "минус")
- **`SurroundedText`** - Surrounds text with specific prefix and suffix (e.g. for brackets)

### Number Part Decorators
- **`IntText`** - Converts the integer part to text
- **`DecimalText`** - Converts the decimal part to text
- **`IntOriginalText`** - Keeps the integer part as digits
- **`DecimalOriginalText`** - Keeps the decimal part as digits

### Currency Decorators
- **`IntCurrencyText`** — Adds currency name to the integer part
- **`DecimalCurrencyText`** — Adds currency name to the decimal part
- **`UsdCodeText`** — Adds currency code "USD" instead of "dollars"
- **`EurCodeText`** — Adds currency code "EUR" instead of "euros"
- **`CustomCurrencyText`** — Interface for implementing custom currency representations

### Combination Decorators
- **`CombinedText`** - Combines integer and decimal parts

### Text Engines
- **`Text`** - Standard text conversion with configurable delimiter
- **`DigitByDigitText`** - Produce each digit separately
- **`SolidText`** - Produces text without spaces (useful for German)

## Supported Languages

* 🇬🇧 **English**
* 🇷🇺 **Russian** — 6 declensions
* 🇩🇪 **German** — backward digit ordering
* ...

## Data types
It supports any java numeric data types that are subclasses of `Number`
```
                               Number
 ┌──────┬───────┬───────┬─────┬──────┬─────────┬──────────┬─────────┐
 │      │       │       │     │      │         │          │
Byte  Short  Integer  Long  Float  Double  BigInteger  BigDecimal  ...
```
## Builder Interface (Alternative)

For those who prefer a fluent API:

```java
Numbify en = new NumbifyBuilder()
    .english(Currency.USD)
    .capitalize()
    .negativeSign()
    .build();
```

**However, we recommend using decorators directly** 
for greater flexibility, better composability, 
and more explicit control.
## Documentation

Visit https://rus4j.org/numbify for complete documentation including:
- Full API reference
- More examples and use cases
- Language-specific features
- Custom implementations

## Contributing

Contributions are welcome!
