/*******************************************************************************
 * Copyright (c) 2016 Elder Research, Inc.
 * All rights reserved.
 *******************************************************************************/
package com.datamininglab.commons.lang.utf;

// CHECKSTYLE:OFF
public interface UnicodeCombining {
    /** ̀ */ char COMBINING_GRAVE_ACCENT = '\u0300';
    /** ́ */ char COMBINING_ACUTE_ACCENT = '\u0301';
    /** ̂ */ char COMBINING_CIRCUMFLEX_ACCENT = '\u0302';
    /** ̃ */ char COMBINING_TILDE = '\u0303';
    /** ̄ */ char COMBINING_MACRON = '\u0304';
    /** ̅ */ char COMBINING_OVERLINE = '\u0305';
    /** ̆ */ char COMBINING_BREVE = '\u0306';
    /** ̇ */ char COMBINING_DOT_ABOVE = '\u0307';
    /** ̈ */ char COMBINING_DIAERESIS = '\u0308';
    /** ̉ */ char COMBINING_HOOK_ABOVE = '\u0309';
    /** ̊ */ char COMBINING_RING_ABOVE = '\u030A';
    /** ̋ */ char COMBINING_DOUBLE_ACUTE_ACCENT = '\u030B';
    /** ̌ */ char COMBINING_CARON = '\u030C';
    /** ̍ */ char COMBINING_VERTICAL_LINE_ABOVE = '\u030D';
    /** ̎ */ char COMBINING_DOUBLE_VERTICAL_LINE_ABOVE = '\u030E';
    /** ̏ */ char COMBINING_DOUBLE_GRAVE_ACCENT = '\u030F';
    /** ̐ */ char COMBINING_CANDRABINDU = '\u0310';
    /** ̑ */ char COMBINING_INVERTED_BREVE = '\u0311';
    /** ̒ */ char COMBINING_TURNED_COMMA_ABOVE = '\u0312';
    /** ̓ */ char COMBINING_COMMA_ABOVE = '\u0313';
    /** ̔ */ char COMBINING_REVERSED_COMMA_ABOVE = '\u0314';
    /** ̕ */ char COMBINING_COMMA_ABOVE_RIGHT = '\u0315';
    /** ̖ */ char COMBINING_GRAVE_ACCENT_BELOW = '\u0316';
    /** ̗ */ char COMBINING_ACUTE_ACCENT_BELOW = '\u0317';
    /** ̘ */ char COMBINING_LEFT_TACK_BELOW = '\u0318';
    /** ̙ */ char COMBINING_RIGHT_TACK_BELOW = '\u0319';
    /** ̚ */ char COMBINING_LEFT_ANGLE_ABOVE = '\u031A';
    /** ̛ */ char COMBINING_HORN = '\u031B';
    /** ̜ */ char COMBINING_LEFT_HALF_RING_BELOW = '\u031C';
    /** ̝ */ char COMBINING_UP_TACK_BELOW = '\u031D';
    /** ̞ */ char COMBINING_DOWN_TACK_BELOW = '\u031E';
    /** ̟ */ char COMBINING_PLUS_SIGN_BELOW = '\u031F';
    /** ̠ */ char COMBINING_MINUS_SIGN_BELOW = '\u0320';
    /** ̡ */ char COMBINING_PALATALIZED_HOOK_BELOW = '\u0321';
    /** ̢ */ char COMBINING_RETROFLEX_HOOK_BELOW = '\u0322';
    /** ̣ */ char COMBINING_DOT_BELOW = '\u0323';
    /** ̤ */ char COMBINING_DIAERESIS_BELOW = '\u0324';
    /** ̥ */ char COMBINING_RING_BELOW = '\u0325';
    /** ̦ */ char COMBINING_COMMA_BELOW = '\u0326';
    /** ̧ */ char COMBINING_CEDILLA = '\u0327';
    /** ̨ */ char COMBINING_OGONEK = '\u0328';
    /** ̩ */ char COMBINING_VERTICAL_LINE_BELOW = '\u0329';
    /** ̪ */ char COMBINING_BRIDGE_BELOW = '\u032A';
    /** ̫ */ char COMBINING_INVERTED_DOUBLE_ARCH_BELOW = '\u032B';
    /** ̬ */ char COMBINING_CARON_BELOW = '\u032C';
    /** ̭ */ char COMBINING_CIRCUMFLEX_ACCENT_BELOW = '\u032D';
    /** ̮ */ char COMBINING_BREVE_BELOW = '\u032E';
    /** ̯ */ char COMBINING_INVERTED_BREVE_BELOW = '\u032F';
    /** ̰ */ char COMBINING_TILDE_BELOW = '\u0330';
    /** ̱ */ char COMBINING_MACRON_BELOW = '\u0331';
    /** ̲ */ char COMBINING_LOW_LINE = '\u0332';
    /** ̳ */ char COMBINING_DOUBLE_LOW_LINE = '\u0333';
    /** ̴ */ char COMBINING_TILDE_OVERLAY = '\u0334';
    /** ̵ */ char COMBINING_SHORT_STROKE_OVERLAY = '\u0335';
    /** ̶ */ char COMBINING_LONG_STROKE_OVERLAY = '\u0336';
    /** ̷ */ char COMBINING_SHORT_SOLIDUS_OVERLAY = '\u0337';
    /** ̸ */ char COMBINING_LONG_SOLIDUS_OVERLAY = '\u0338';
    /** ̹ */ char COMBINING_RIGHT_HALF_RING_BELOW = '\u0339';
    /** ̺ */ char COMBINING_INVERTED_BRIDGE_BELOW = '\u033A';
    /** ̻ */ char COMBINING_SQUARE_BELOW = '\u033B';
    /** ̼ */ char COMBINING_SEAGULL_BELOW = '\u033C';
    /** ̽ */ char COMBINING_X_ABOVE = '\u033D';
    /** ̾ */ char COMBINING_VERTICAL_TILDE = '\u033E';
    /** ̿ */ char COMBINING_DOUBLE_OVERLINE = '\u033F';
    /** ̀ */ char COMBINING_GRAVE_TONE_MARK = '\u0340';
    /** ́ */ char COMBINING_ACUTE_TONE_MARK = '\u0341';
    /** ͂ */ char COMBINING_GREEK_PERISPOMENI = '\u0342';
    /** ̓ */ char COMBINING_GREEK_KORONIS = '\u0343';
    /** ̈́ */ char COMBINING_GREEK_DIALYTIKA_TONOS = '\u0344';
    /** ͅ */ char COMBINING_GREEK_YPOGEGRAMMENI = '\u0345';
    /** ͆ */ char COMBINING_BRIDGE_ABOVE = '\u0346';
    /** ͇ */ char COMBINING_EQUALS_SIGN_BELOW = '\u0347';
    /** ͈ */ char COMBINING_DOUBLE_VERTICAL_LINE_BELOW = '\u0348';
    /** ͉ */ char COMBINING_LEFT_ANGLE_BELOW = '\u0349';
    /** ͊ */ char COMBINING_NOT_TILDE_ABOVE = '\u034A';
    /** ͋ */ char COMBINING_HOMOTHETIC_ABOVE = '\u034B';
    /** ͌ */ char COMBINING_ALMOST_EQUAL_TO_ABOVE = '\u034C';
    /** ͍ */ char COMBINING_LEFT_RIGHT_ARROW_BELOW = '\u034D';
    /** ͎ */ char COMBINING_UPWARDS_ARROW_BELOW = '\u034E';
    /** ͏ */ char COMBINING_GRAPHEME_JOINER = '\u034F';
    /** ͐ */ char COMBINING_RIGHT_ARROWHEAD_ABOVE = '\u0350';
    /** ͑ */ char COMBINING_LEFT_HALF_RING_ABOVE = '\u0351';
    /** ͒ */ char COMBINING_FERMATA = '\u0352';
    /** ͓ */ char COMBINING_X_BELOW = '\u0353';
    /** ͔ */ char COMBINING_LEFT_ARROWHEAD_BELOW = '\u0354';
    /** ͕ */ char COMBINING_RIGHT_ARROWHEAD_BELOW = '\u0355';
    /** ͖ */ char COMBINING_RIGHT_ARROWHEAD_AND_UP_ARROWHEAD_BELOW = '\u0356';
    /** ͗ */ char COMBINING_RIGHT_HALF_RING_ABOVE = '\u0357';
    /** ͘ */ char COMBINING_DOT_ABOVE_RIGHT = '\u0358';
    /** ͙ */ char COMBINING_ASTERISK_BELOW = '\u0359';
    /** ͚ */ char COMBINING_DOUBLE_RING_BELOW = '\u035A';
    /** ͛ */ char COMBINING_ZIGZAG_ABOVE = '\u035B';
    /** ͜ */ char COMBINING_DOUBLE_BREVE_BELOW = '\u035C';
    /** ͝ */ char COMBINING_DOUBLE_BREVE = '\u035D';
    /** ͞ */ char COMBINING_DOUBLE_MACRON = '\u035E';
    /** ͟ */ char COMBINING_DOUBLE_MACRON_BELOW = '\u035F';
    /** ͠ */ char COMBINING_DOUBLE_TILDE = '\u0360';
    /** ͡ */ char COMBINING_DOUBLE_INVERTED_BREVE = '\u0361';
    /** ͢ */ char COMBINING_DOUBLE_RIGHTWARDS_ARROW_BELOW = '\u0362';
    /** ͣ */ char COMBINING_LATIN_SMALL_LETTER_A = '\u0363';
    /** ͤ */ char COMBINING_LATIN_SMALL_LETTER_E = '\u0364';
    /** ͥ */ char COMBINING_LATIN_SMALL_LETTER_I = '\u0365';
    /** ͦ */ char COMBINING_LATIN_SMALL_LETTER_O = '\u0366';
    /** ͧ */ char COMBINING_LATIN_SMALL_LETTER_U = '\u0367';
    /** ͨ */ char COMBINING_LATIN_SMALL_LETTER_C = '\u0368';
    /** ͩ */ char COMBINING_LATIN_SMALL_LETTER_D = '\u0369';
    /** ͪ */ char COMBINING_LATIN_SMALL_LETTER_H = '\u036A';
    /** ͫ */ char COMBINING_LATIN_SMALL_LETTER_M = '\u036B';
    /** ͬ */ char COMBINING_LATIN_SMALL_LETTER_R = '\u036C';
    /** ͭ */ char COMBINING_LATIN_SMALL_LETTER_T = '\u036D';
    /** ͮ */ char COMBINING_LATIN_SMALL_LETTER_V = '\u036E';
    /** ͯ */ char COMBINING_LATIN_SMALL_LETTER_X = '\u036F';
    /** ҃ */ char COMBINING_CYRILLIC_TITLO = '\u0483';
    /** ҄ */ char COMBINING_CYRILLIC_PALATALIZATION = '\u0484';
    /** ҅ */ char COMBINING_CYRILLIC_DASIA_PNEUMATA = '\u0485';
    /** ҆ */ char COMBINING_CYRILLIC_PSILI_PNEUMATA = '\u0486';
    /** ҇ */ char COMBINING_CYRILLIC_POKRYTIE = '\u0487';
    /** ҈ */ char COMBINING_CYRILLIC_HUNDRED_THOUSANDS_SIGN = '\u0488';
    /** ҉ */ char COMBINING_CYRILLIC_MILLIONS_SIGN = '\u0489';
    /** ᷀ */ char COMBINING_DOTTED_GRAVE_ACCENT = '\u1DC0';
    /** ᷁ */ char COMBINING_DOTTED_ACUTE_ACCENT = '\u1DC1';
    /** ᷂ */ char COMBINING_SNAKE_BELOW = '\u1DC2';
    /** ᷃ */ char COMBINING_SUSPENSION_MARK = '\u1DC3';
    /** ᷄ */ char COMBINING_MACRON_ACUTE = '\u1DC4';
    /** ᷅ */ char COMBINING_GRAVE_MACRON = '\u1DC5';
    /** ᷆ */ char COMBINING_MACRON_GRAVE = '\u1DC6';
    /** ᷇ */ char COMBINING_ACUTE_MACRON = '\u1DC7';
    /** ᷈ */ char COMBINING_GRAVE_ACUTE_GRAVE = '\u1DC8';
    /** ᷉ */ char COMBINING_ACUTE_GRAVE_ACUTE = '\u1DC9';
    /** ᷊ */ char COMBINING_LATIN_SMALL_LETTER_R_BELOW = '\u1DCA';
    /** ᷋ */ char COMBINING_BREVE_MACRON = '\u1DCB';
    /** ᷌ */ char COMBINING_MACRON_BREVE = '\u1DCC';
    /** ᷍ */ char COMBINING_DOUBLE_CIRCUMFLEX_ABOVE = '\u1DCD';
    /** ᷎ */ char COMBINING_OGONEK_ABOVE = '\u1DCE';
    /** ᷏ */ char COMBINING_ZIGZAG_BELOW = '\u1DCF';
    /** ᷐ */ char COMBINING_IS_BELOW = '\u1DD0';
    /** ᷑ */ char COMBINING_UR_ABOVE = '\u1DD1';
    /** ᷒ */ char COMBINING_US_ABOVE = '\u1DD2';
    /** ᷓ */ char COMBINING_LATIN_SMALL_LETTER_FLATTENED_OPEN_A_ABOVE = '\u1DD3';
    /** ᷔ */ char COMBINING_LATIN_SMALL_LETTER_AE = '\u1DD4';
    /** ᷕ */ char COMBINING_LATIN_SMALL_LETTER_AO = '\u1DD5';
    /** ᷖ */ char COMBINING_LATIN_SMALL_LETTER_AV = '\u1DD6';
    /** ᷗ */ char COMBINING_LATIN_SMALL_LETTER_C_CEDILLA = '\u1DD7';
    /** ᷘ */ char COMBINING_LATIN_SMALL_LETTER_INSULAR_D = '\u1DD8';
    /** ᷙ */ char COMBINING_LATIN_SMALL_LETTER_ETH = '\u1DD9';
    /** ᷚ */ char COMBINING_LATIN_SMALL_LETTER_G = '\u1DDA';
    /** ᷛ */ char COMBINING_LATIN_LETTER_SMALL_CAPITAL_G = '\u1DDB';
    /** ᷜ */ char COMBINING_LATIN_SMALL_LETTER_K = '\u1DDC';
    /** ᷝ */ char COMBINING_LATIN_SMALL_LETTER_L = '\u1DDD';
    /** ᷞ */ char COMBINING_LATIN_LETTER_SMALL_CAPITAL_L = '\u1DDE';
    /** ᷟ */ char COMBINING_LATIN_LETTER_SMALL_CAPITAL_M = '\u1DDF';
    /** ᷠ */ char COMBINING_LATIN_SMALL_LETTER_N = '\u1DE0';
    /** ᷡ */ char COMBINING_LATIN_LETTER_SMALL_CAPITAL_N = '\u1DE1';
    /** ᷢ */ char COMBINING_LATIN_LETTER_SMALL_CAPITAL_R = '\u1DE2';
    /** ᷣ */ char COMBINING_LATIN_SMALL_LETTER_R_ROTUNDA = '\u1DE3';
    /** ᷤ */ char COMBINING_LATIN_SMALL_LETTER_S = '\u1DE4';
    /** ᷥ */ char COMBINING_LATIN_SMALL_LETTER_LONG_S = '\u1DE5';
    /** ᷦ */ char COMBINING_LATIN_SMALL_LETTER_Z = '\u1DE6';
    /** ᷼ */ char COMBINING_DOUBLE_INVERTED_BREVE_BELOW = '\u1DFC';
    /** ᷽ */ char COMBINING_ALMOST_EQUAL_TO_BELOW = '\u1DFD';
    /** ᷾ */ char COMBINING_LEFT_ARROWHEAD_ABOVE = '\u1DFE';
    /** ᷿ */ char COMBINING_RIGHT_ARROWHEAD_AND_DOWN_ARROWHEAD_BELOW = '\u1DFF';
    /** ⃐ */ char COMBINING_LEFT_HARPOON_ABOVE = '\u20D0';
    /** ⃑ */ char COMBINING_RIGHT_HARPOON_ABOVE = '\u20D1';
    /** ⃒ */ char COMBINING_LONG_VERTICAL_LINE_OVERLAY = '\u20D2';
    /** ⃓ */ char COMBINING_SHORT_VERTICAL_LINE_OVERLAY = '\u20D3';
    /** ⃔ */ char COMBINING_ANTICLOCKWISE_ARROW_ABOVE = '\u20D4';
    /** ⃕ */ char COMBINING_CLOCKWISE_ARROW_ABOVE = '\u20D5';
    /** ⃖ */ char COMBINING_LEFT_ARROW_ABOVE = '\u20D6';
    /** ⃗ */ char COMBINING_RIGHT_ARROW_ABOVE = '\u20D7';
    /** ⃘ */ char COMBINING_RING_OVERLAY = '\u20D8';
    /** ⃙ */ char COMBINING_CLOCKWISE_RING_OVERLAY = '\u20D9';
    /** ⃚ */ char COMBINING_ANTICLOCKWISE_RING_OVERLAY = '\u20DA';
    /** ⃛ */ char COMBINING_THREE_DOTS_ABOVE = '\u20DB';
    /** ⃜ */ char COMBINING_FOUR_DOTS_ABOVE = '\u20DC';
    /** ⃝ */ char COMBINING_ENCLOSING_CIRCLE = '\u20DD';
    /** ⃞ */ char COMBINING_ENCLOSING_SQUARE = '\u20DE';
    /** ⃟ */ char COMBINING_ENCLOSING_DIAMOND = '\u20DF';
    /** ⃠ */ char COMBINING_ENCLOSING_CIRCLE_BACKSLASH = '\u20E0';
    /** ⃡ */ char COMBINING_LEFT_RIGHT_ARROW_ABOVE = '\u20E1';
    /** ⃢ */ char COMBINING_ENCLOSING_SCREEN = '\u20E2';
    /** ⃣ */ char COMBINING_ENCLOSING_KEYCAP = '\u20E3';
    /** ⃤ */ char COMBINING_ENCLOSING_UPWARD_POINTING_TRIANGLE = '\u20E4';
    /** ⃥ */ char COMBINING_REVERSE_SOLIDUS_OVERLAY = '\u20E5';
    /** ⃦ */ char COMBINING_DOUBLE_VERTICAL_STROKE_OVERLAY = '\u20E6';
    /** ⃧ */ char COMBINING_ANNUITY_SYMBOL = '\u20E7';
    /** ⃨ */ char COMBINING_TRIPLE_UNDERDOT = '\u20E8';
    /** ⃩ */ char COMBINING_WIDE_BRIDGE_ABOVE = '\u20E9';
    /** ⃪ */ char COMBINING_LEFTWARDS_ARROW_OVERLAY = '\u20EA';
    /** ⃫ */ char COMBINING_LONG_DOUBLE_SOLIDUS_OVERLAY = '\u20EB';
    /** ⃬ */ char COMBINING_RIGHTWARDS_HARPOON_WITH_BARB_DOWNWARDS = '\u20EC';
    /** ⃭ */ char COMBINING_LEFTWARDS_HARPOON_WITH_BARB_DOWNWARDS = '\u20ED';
    /** ⃮ */ char COMBINING_LEFT_ARROW_BELOW = '\u20EE';
    /** ⃯ */ char COMBINING_RIGHT_ARROW_BELOW = '\u20EF';
    /** ⃰ */ char COMBINING_ASTERISK_ABOVE = '\u20F0';
    /** ⷠ */ char COMBINING_CYRILLIC_LETTER_BE = '\u2DE0';
    /** ⷡ */ char COMBINING_CYRILLIC_LETTER_VE = '\u2DE1';
    /** ⷢ */ char COMBINING_CYRILLIC_LETTER_GHE = '\u2DE2';
    /** ⷣ */ char COMBINING_CYRILLIC_LETTER_DE = '\u2DE3';
    /** ⷤ */ char COMBINING_CYRILLIC_LETTER_ZHE = '\u2DE4';
    /** ⷥ */ char COMBINING_CYRILLIC_LETTER_ZE = '\u2DE5';
    /** ⷦ */ char COMBINING_CYRILLIC_LETTER_KA = '\u2DE6';
    /** ⷧ */ char COMBINING_CYRILLIC_LETTER_EL = '\u2DE7';
    /** ⷨ */ char COMBINING_CYRILLIC_LETTER_EM = '\u2DE8';
    /** ⷩ */ char COMBINING_CYRILLIC_LETTER_EN = '\u2DE9';
    /** ⷪ */ char COMBINING_CYRILLIC_LETTER_O = '\u2DEA';
    /** ⷫ */ char COMBINING_CYRILLIC_LETTER_PE = '\u2DEB';
    /** ⷬ */ char COMBINING_CYRILLIC_LETTER_ER = '\u2DEC';
    /** ⷭ */ char COMBINING_CYRILLIC_LETTER_ES = '\u2DED';
    /** ⷮ */ char COMBINING_CYRILLIC_LETTER_TE = '\u2DEE';
    /** ⷯ */ char COMBINING_CYRILLIC_LETTER_HA = '\u2DEF';
    /** ⷰ */ char COMBINING_CYRILLIC_LETTER_TSE = '\u2DF0';
    /** ⷱ */ char COMBINING_CYRILLIC_LETTER_CHE = '\u2DF1';
    /** ⷲ */ char COMBINING_CYRILLIC_LETTER_SHA = '\u2DF2';
    /** ⷳ */ char COMBINING_CYRILLIC_LETTER_SHCHA = '\u2DF3';
    /** ⷴ */ char COMBINING_CYRILLIC_LETTER_FITA = '\u2DF4';
    /** ⷵ */ char COMBINING_CYRILLIC_LETTER_ES_TE = '\u2DF5';
    /** ⷶ */ char COMBINING_CYRILLIC_LETTER_A = '\u2DF6';
    /** ⷷ */ char COMBINING_CYRILLIC_LETTER_IE = '\u2DF7';
    /** ⷸ */ char COMBINING_CYRILLIC_LETTER_DJERV = '\u2DF8';
    /** ⷹ */ char COMBINING_CYRILLIC_LETTER_MONOGRAPH_UK = '\u2DF9';
    /** ⷺ */ char COMBINING_CYRILLIC_LETTER_YAT = '\u2DFA';
    /** ⷻ */ char COMBINING_CYRILLIC_LETTER_YU = '\u2DFB';
    /** ⷼ */ char COMBINING_CYRILLIC_LETTER_IOTIFIED_A = '\u2DFC';
    /** ⷽ */ char COMBINING_CYRILLIC_LETTER_LITTLE_YUS = '\u2DFD';
    /** ⷾ */ char COMBINING_CYRILLIC_LETTER_BIG_YUS = '\u2DFE';
    /** ⷿ */ char COMBINING_CYRILLIC_LETTER_IOTIFIED_BIG_YUS = '\u2DFF';
    /** ゙ */ char COMBINING_KATAKANA_HIRAGANA_VOICED_SOUND_MARK = '\u3099';
    /** ゚ */ char COMBINING_KATAKANA_HIRAGANA_SEMI_VOICED_SOUND_MARK = '\u309A';
    /** ꙯ */ char COMBINING_CYRILLIC_VZMET = '\uA66F';
    /** ꙰ */ char COMBINING_CYRILLIC_TEN_MILLIONS_SIGN = '\uA670';
    /** ꙱ */ char COMBINING_CYRILLIC_HUNDRED_MILLIONS_SIGN = '\uA671';
    /** ꙲ */ char COMBINING_CYRILLIC_THOUSAND_MILLIONS_SIGN = '\uA672';
    /** ꙴ */ char COMBINING_CYRILLIC_LETTER_UKRAINIAN_IE = '\uA674';
    /** ꙵ */ char COMBINING_CYRILLIC_LETTER_I = '\uA675';
    /** ꙶ */ char COMBINING_CYRILLIC_LETTER_YI = '\uA676';
    /** ꙷ */ char COMBINING_CYRILLIC_LETTER_U = '\uA677';
    /** ꙸ */ char COMBINING_CYRILLIC_LETTER_HARD_SIGN = '\uA678';
    /** ꙹ */ char COMBINING_CYRILLIC_LETTER_YERU = '\uA679';
    /** ꙺ */ char COMBINING_CYRILLIC_LETTER_SOFT_SIGN = '\uA67A';
    /** ꙻ */ char COMBINING_CYRILLIC_LETTER_OMEGA = '\uA67B';
    /** ꙼ */ char COMBINING_CYRILLIC_KAVYKA = '\uA67C';
    /** ꙽ */ char COMBINING_CYRILLIC_PAYEROK = '\uA67D';
    /** ꚟ */ char COMBINING_CYRILLIC_LETTER_IOTIFIED_E = '\uA69F';
    /** ꣠ */ char COMBINING_DEVANAGARI_DIGIT_ZERO = '\uA8E0';
    /** ꣡ */ char COMBINING_DEVANAGARI_DIGIT_ONE = '\uA8E1';
    /** ꣢ */ char COMBINING_DEVANAGARI_DIGIT_TWO = '\uA8E2';
    /** ꣣ */ char COMBINING_DEVANAGARI_DIGIT_THREE = '\uA8E3';
    /** ꣤ */ char COMBINING_DEVANAGARI_DIGIT_FOUR = '\uA8E4';
    /** ꣥ */ char COMBINING_DEVANAGARI_DIGIT_FIVE = '\uA8E5';
    /** ꣦ */ char COMBINING_DEVANAGARI_DIGIT_SIX = '\uA8E6';
    /** ꣧ */ char COMBINING_DEVANAGARI_DIGIT_SEVEN = '\uA8E7';
    /** ꣨ */ char COMBINING_DEVANAGARI_DIGIT_EIGHT = '\uA8E8';
    /** ꣩ */ char COMBINING_DEVANAGARI_DIGIT_NINE = '\uA8E9';
    /** ꣪ */ char COMBINING_DEVANAGARI_LETTER_A = '\uA8EA';
    /** ꣫ */ char COMBINING_DEVANAGARI_LETTER_U = '\uA8EB';
    /** ꣬ */ char COMBINING_DEVANAGARI_LETTER_KA = '\uA8EC';
    /** ꣭ */ char COMBINING_DEVANAGARI_LETTER_NA = '\uA8ED';
    /** ꣮ */ char COMBINING_DEVANAGARI_LETTER_PA = '\uA8EE';
    /** ꣯ */ char COMBINING_DEVANAGARI_LETTER_RA = '\uA8EF';
    /** ꣰ */ char COMBINING_DEVANAGARI_LETTER_VI = '\uA8F0';
    /** ꣱ */ char COMBINING_DEVANAGARI_SIGN_AVAGRAHA = '\uA8F1';
    /** ︠ */ char COMBINING_LIGATURE_LEFT_HALF = '\uFE20';
    /** ︡ */ char COMBINING_LIGATURE_RIGHT_HALF = '\uFE21';
    /** ︢ */ char COMBINING_DOUBLE_TILDE_LEFT_HALF = '\uFE22';
    /** ︣ */ char COMBINING_DOUBLE_TILDE_RIGHT_HALF = '\uFE23';
    /** ︤ */ char COMBINING_MACRON_LEFT_HALF = '\uFE24';
    /** ︥ */ char COMBINING_MACRON_RIGHT_HALF = '\uFE25';
    /** ︦ */ char COMBINING_CONJOINING_MACRON = '\uFE26';
}
// CHECKSTYLE:ON