public class BraceChecker {

  public boolean isValid(String braces) {
    java.util.Map<Character, Character> matchingBraces = new java.util.HashMap<>() {{
      put(')', '(');
      put(']', '[');
      put('}', '{');
    }};
    java.util.Deque<Character> stack = new java.util.ArrayDeque<>();
    int unclosed = 0;
    for (int i = 0; i < braces.length(); i++) {
      char charGet = braces.charAt(i);
      if (matchingBraces.containsValue(charGet)) {
        stack.addFirst(charGet);
        unclosed++;
        continue;
      }
      if (matchingBraces.containsKey(charGet)) {
        if (stack.pollFirst() != matchingBraces.get(charGet))
          return false;
        unclosed--;
        if (unclosed < 0)
          return false;
      }
    }
    if (unclosed != 0)
      return false;
    return true;
  }

}