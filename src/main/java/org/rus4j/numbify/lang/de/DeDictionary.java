package org.rus4j.numbify.lang.de;

import org.rus4j.numbify.lang.Gender;

public class DeDictionary {

    final String[] units(Gender gender) {
        return switch (gender) {
            case MALE, NEUTRAL -> maleUnits;
            case FEMALE -> femaleUnits;
        };
    }

    final String[] maleUnits = new String[]{"null", "ein", "zwei", "drei", "vier", "fünf", "sechs", "sieben", "acht", "neun"};
    final String[] femaleUnits = new String[]{"null", "eine", "zwei", "drei", "vier", "fünf", "sechs", "sieben", "acht", "neun"};

    final String[] tenToNineteen = new String[]{"zehn", "elf", "zwölf", "dreizehn", "vierzehn",
            "fünfzehn", "sechzehn", "siebzehn", "achtzehn", "neunzehn"
    };

    final String[] tens = new String[]{"", "", "zwanzig", "dreißig", "vierzig",
            "fünfzig", "sechzig", "siebzig", "achtzig", "neunzig"
    };

    final String[] hundreds = new String[]{"", "einhundert", "zweihundert", "dreihundert", "vierhundert",
            "fünfhundert", "sechshundert", "siebenhundert", "achthundert", "neunhundert"
    };

    final String thousand = "tausend";

    final String[] millions = new String[]{"Million", "Milliarde", "Billion", "Billiarde",
            "Trillion", "Trilliarde", "Quadrillion", "Quadrilliarde", "Quintillion", "Quintilliarde"
    };

    final String[] endings = new String[] {"", "en"};
}
