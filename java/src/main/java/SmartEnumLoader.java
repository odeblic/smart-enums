import java.io.*;
import java.nio.charset.Charset;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum SmartEnumLoader {
    ZERO(0, "Zero"),
    ONE(1, "One"),
    TWO(2, "Two"),
    THREE(3, "Three"),
    FOUR(4, "Four"),
    FIVE(5, "Five"),
    UNKNOWN(-1, "Unknown");

    private final int code;
    private final String name;
    //private static final Map<String, SmartEnum> aliasesX = new HashMap<String, SmartEnum>() {"", "", ""};


    public static Map<String, SmartEnumLoader> loadFile() throws Exception {
        Map<String, SmartEnumLoader> _aliases = new HashMap<String, SmartEnumLoader>();
        String fileName = "I:\\smart-enums\\src\\main\\resources\\enum.txt";
        BufferedReader buffer;
        String line;

        InputStream inputStream = new FileInputStream(fileName);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
        buffer = new BufferedReader(inputStreamReader);

        Pattern patternLine = Pattern.compile("[ \t]*([0-9]+)[ \t]*:[ \t]*(\"[^\"]*\")[ \t]*(.*)");
        Pattern patternAliases = Pattern.compile(",[ \t]*(\"[^\"]*\")[ \t]*");

        while ((line = buffer.readLine()) != null) {
            Matcher matcher = patternLine.matcher(line);

            if (matcher.find()) {
                System.out.println("--------------------------------");

                int code = Integer.parseInt(matcher.group(1));
                String name = matcher.group(2);
                String aliases = matcher.group(3);

                System.out.println("code: " + code);
                System.out.println("name: " + name);

                SmartEnumLoader e = fromCode(code);
                if (e != UNKNOWN) {
                    _aliases.put(name, e);
                }

                matcher = patternAliases.matcher(aliases);

                while (matcher.find()) {
                    String alias = matcher.group(1);
                    System.out.println("alias: " + alias);
                    _aliases.put(alias, e);
                }

            } else {
                System.out.println("NO MATCH");
            }
        }

        return _aliases;
    }


    private static final Map<String, SmartEnumLoader> aliases;

    static {
        Map<String, SmartEnumLoader> _aliases = new HashMap<String, SmartEnumLoader>();
        String fileName = "I:\\smart-enums\\src\\main\\resources\\enum.txt";
        InputStream inputStream;
        InputStreamReader inputStreamReader;
        BufferedReader buffer = null;
        String line;


        try {
            inputStream = new FileInputStream(fileName);
            inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            buffer = new BufferedReader(inputStreamReader);
        } catch (FileNotFoundException e) {
            System.exit(1);
        }


        Pattern patternLine = Pattern.compile("[ \t]*([0-9]+)[ \t]*:[ \t]*(\"[^\"]*\")[ \t]*(.*)");
        Pattern patternAliases = Pattern.compile(",[ \t]*(\"[^\"]*\")[ \t]*");

        try {
            while ((line = buffer.readLine()) != null) {
                Matcher matcher = patternLine.matcher(line);

                if (matcher.find()) {
                    System.out.println("--------------------------------");

                    int code = Integer.parseInt(matcher.group(1));
                    String name = matcher.group(2);
                    String aliases = matcher.group(3);

                    System.out.println("code: " + code);
                    System.out.println("name: " + name);

                    SmartEnumLoader e = fromCode(code);
                    if (e != UNKNOWN) {
                        _aliases.put(name, e);
                    }

                    matcher = patternAliases.matcher(aliases);

                    while (matcher.find()) {
                        String alias = matcher.group(1);
                        System.out.println("alias: " + alias);
                        _aliases.put(alias, e);
                    }

                } else {
                    System.out.println("NO MATCH");
                }
            }
        } catch (IOException e) {
            _aliases = null;
        }

        if (_aliases != null) {
            aliases = Collections.unmodifiableMap(_aliases);
        } else {
            aliases = null;
        }
    }

    private SmartEnumLoader(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static SmartEnumLoader fromCode(int code) {
        for (SmartEnumLoader e : values()) {
            if (e.getCode() == code) {
                return e;
            }
        }
        return UNKNOWN;
    }

    public static SmartEnumLoader fromName(String name) {
        SmartEnumLoader e = aliases.get(name);
        if (e == null) {
            e = UNKNOWN;
        }
        return e;
        /*
        for (SmartEnum e : values()) {
            if (e.getName().equals(name)) {
                return e;
            }
        }
        return UNKNOWN;
        */
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
