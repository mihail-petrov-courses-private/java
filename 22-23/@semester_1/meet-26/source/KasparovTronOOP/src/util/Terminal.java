package util;

import config.ColorStyleEnum;

public class Terminal {

    private static final String ESC     = "[";
    private static final String RESET   = ESC + "0m";

    public static String red(ColorStyleEnum style) {

        String colorCode = (style == ColorStyleEnum.FOREGROUND) ? "31m" : "41m";
        return ESC + colorCode;
    }

    public static String white(ColorStyleEnum style) {

        String colorCode = (style == ColorStyleEnum.FOREGROUND) ? "37m" : "47m";
        return ESC + colorCode;
    }

    public static String black(ColorStyleEnum style) {

        String colorCode = (style == ColorStyleEnum.FOREGROUND) ? "30m" : "40m";
        return ESC + colorCode;
    }

    public static String yellow(ColorStyleEnum style) {

        String colorCode = (style == ColorStyleEnum.FOREGROUND) ? "33m" : "43m";
        return ESC + colorCode;
    }

    public static String red(ColorStyleEnum style, String value) {
        return red(style) + value + RESET;
    }

    public static String white(ColorStyleEnum style, String value) {
        return white(style) + value + RESET;
    }

    public static String black(ColorStyleEnum style, String value) {
        return black(style) + value + RESET;
    }

    public static String yellow(ColorStyleEnum style, String value) {
        return yellow(style) + value + RESET;
    }

    public static String colorMix(String value, String ...styleCollection) {

        String resultFormat = "";
        for(String styleElement : styleCollection) {
            resultFormat += styleElement + " ";
        }

        return resultFormat + value + RESET;
    }

    public static void println(String line) {
        System.out.println(line);
    }
}
