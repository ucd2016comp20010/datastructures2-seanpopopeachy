package project20280.stacksqueues;

import project20280.interfaces.Stack;

class BracketChecker {
    private final String input;

    public BracketChecker(String in) {
        input = in;
    }

    public void check() {
        Stack<Character> stack = new LinkedStack<>();

        for(int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);

            if(current == '(' || current == '[' || current == '{') {
                stack.push(current);
            } else if(current == ')' || current == ']' || current == '}') {
                if(stack.isEmpty()) {
                    System.out.println("not correct; nothing matches final " + current);
                    return;
                }

                char open = stack.pop();

                if((current == ')' && open != '(') ||
                   (current == ']' && open != '[') ||
                   (current == '}' && open != '{')) {
                    System.out.println("not correct; " + current + " doesn't match " + open);
                    return;
                }
            }
        }
        if(!stack.isEmpty()) {
            System.out.println("not correct; nothing matches opening " + stack.top());
            return;
        }
    }

    public static void main(String[] args) {
        String[] inputs = {
                "[]]()()", // not correct
                "c[d]", // correct\n" +
                "a{b[c]d}e", // correct\n" +
                "a{b(c]d}e", // not correct; ] doesn't match (\n" +
                "a[b{c}d]e}", // not correct; nothing matches final }\n" +
                "a{b(c) ", // // not correct; nothing matches opening {
        };

        for (String input : inputs) {
            BracketChecker checker = new BracketChecker(input);
            System.out.println("checking: " + input);
            checker.check();
        }
    }
}