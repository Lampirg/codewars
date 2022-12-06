package Main;

import java.util.Arrays;

public class StripComments {

    public static String stripComments(String text, String[] commentSymbols) {
        String[] lines = text.split("\n");
        String finalText = "";
        for (int i = 0; i < lines.length - 1; i++) {
            finalText += stripLine(lines[i], commentSymbols) + "\n";
        }
        finalText += stripLine(lines[lines.length - 1], commentSymbols);
        return finalText;
    }

    private static String stripLine(String line, String[] commentSymbols) {
        String commentRegex = "[";
        for (String commentSybol : commentSymbols)
            commentRegex += commentSybol;
        commentRegex += "]";
        String[] parts = line.split(commentRegex);
        if (parts.length == 0)
            return "";
        line = parts[0];
        while (line.endsWith(" "))
            line = line.substring(0, line.length() - 1);
        return line;
    }

}
