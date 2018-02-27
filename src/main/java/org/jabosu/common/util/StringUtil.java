package org.jabosu.common.util;

import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import java.util.Arrays;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

public class StringUtil {

    public static boolean isEmpty(String str) {
        if (str == null || str.trim().length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static String wrap(String str, int length) {
        if (str == null) {
            return "";
        }
        
        return str.substring(0, Math.min(str.length(), length));
    }

    public static String getSingleValue(String[] values) {
        if (values == null || values.length == 0) {
            return "";
        } else {
            return values[0];
        }
    }

    public static String getNonNull(String value) {
        if(value == null)
            return "";
        else
            return value;
    }

    public static boolean isEmpty(String[] values) {

        if (values == null || values.length == 0) {
            return true;
        } else if (values.length == 1) {
            if (isEmpty(values[0])) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean isEmpty(List<String> values) {

        if (values == null || values.size() == 0) {
            return true;
        } else if (values.size() == 1) {
            if (isEmpty(values.get(0))) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static String toJsonArray(String[] values) {
        if (isEmpty(values)) {
            return "[]";
        } else {
//               ArrayNode arrNode = JsonNodeFactory.instance.arrayNode();
            StringBuilder buf = new StringBuilder();

            buf.append("[");
            for (int i = 0; i < values.length; i++) {
//                   arrNode.add(value);
                buf.append("'");
                buf.append(values[i]);
                buf.append("'");

                if (i != values.length - 1) {
                    buf.append(",");
                }
            }
            buf.append("]");

            return buf.toString();
//               return arrNode.toString();

        }
    }

    public static String toJsonArray(List<String> values) {
        if (values == null || values.size() == 0) {
            return "[]";
        } else {
//               ArrayNode arrNode = JsonNodeFactory.instance.arrayNode();
            StringBuilder buf = new StringBuilder();

            buf.append("[");
            for (int i = 0; i < values.size(); i++) {
//                   arrNode.add(value);
                buf.append("'");
                buf.append(values.get(i));
                buf.append("'");

                if (i != values.size() - 1) {
                    buf.append(",");
                }
            }
            buf.append("]");

            return buf.toString();
//               return arrNode.toString();

        }
    }

    public static boolean contains(String[] arr, String val) {
        if (arr == null || val == null) {
            return false;
        }

        for (String st : arr) {
            if (val.equals(st)) {
                return true;
            }
        }

        return false;
    }

    public static String join(String[] values) {
        Joiner joiner = Joiner.on(", ").skipNulls();
        String value = joiner.join(values);
        
        if(value.startsWith(",")) {
            value = value.replaceFirst(",", "");
        }
        
        return value;
    }
    
    public static String join(List<String> values) {
        Joiner joiner = Joiner.on(", ").skipNulls();
        String value = joiner.join(values);
        
        if(value.startsWith(",")) {
            value = value.replaceFirst(",", "");
        }
        
        return value;
    }

    public static String[] removeNull(String[] input) {
        
        Iterable<String> st = Iterables.filter(Arrays.asList(input), new Predicate<String>() {
            @Override
            public boolean apply(String arg0) {
                if (arg0 == null || arg0.length() == 0) //avoid null strings 
                {
                    return false;
                } else
                    return true; // else true
            }
        });
        
        return Iterables.toArray(st, String.class);
    }
    
    public static String[] cleanHtml(String[] input) {
        if(input == null)
            return new String[0];
        
        input = removeNull(input);
        if(input == null)
            return new String[0];
        
        for(int i=0; i<input.length; i++) {
            input[i] = Jsoup.clean(input[i], Whitelist.basic());
        }
        
        return input;
    }
    
    public static String[] cleanWysiwygHtml(String[] input) {
        if(input == null)
            return new String[0];
        
        input = removeNull(input);
        if(input == null)
            return new String[0];
        
        for(int i=0; i<input.length; i++) {
            input[i] = Jsoup.clean(input[i], Whitelist.relaxed().addAttributes("span", "style"));
        }
        
        return input;
    }

    public static String cleanWysiwygHtml(String input) {
        if(input == null)
            return "";

        return Jsoup.clean(input, Whitelist.relaxed().addAttributes("span", "style"));
    }

    public static String cleanHtmlAsSimpleText(String input) {
        if(input == null)
            return "";

        return Jsoup.clean(input, Whitelist.simpleText());
    }
    
    public static String formatUrl(String url) {
        if(url == null || url.length() == 0) return "";
        
        if(!url.startsWith("http")) {
            url = "http://" + url;
        }
        
        return url;
    }

    public static String wrapStringWithQuoteIfNeeded(String value) {
        if(value == null)
            return null;
        
        if(value.contains(" ")) {
            return "\"" + value + "\"";
        }
        else
            return value;
    }

}
