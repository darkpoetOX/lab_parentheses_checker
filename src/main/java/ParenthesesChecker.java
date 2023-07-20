import java.util.ArrayDeque;
import java.util.Deque;

public class ParenthesesChecker {

    public boolean checkParentheses(String testString) {
        Deque<Character> stack = new ArrayDeque<>(); //apparently, after googling, this is the syntax for creating a stack object.

        for (char character : testString.toCharArray()) { //since String contents cannot be changed, the String input has to be disassembled i.e. put in an array so that the individual characters can be parsed and so input.toCharArray() is called in the for statement.
            if (isOpeningBracket(character)) {
                stack.push(character); //only open brackets are pushed into stack, the close brackets are used to check for correspondence to open brackets when popped from the stack.
            } else if (isClosingBracket(character)) {
                if (stack.isEmpty() || !areMatchingBrackets(stack.pop(), character)) {
                    return false;
                }
            }
        }
        if(stack.isEmpty()){ //either means nothing was added to the stack or that all characters in testString were parsed through and successfully found all open and their corresponding closed brackets.
            return true;
        }
        return false;
    }

    //Since we're only allowed to call one method in the test file, we can just link the main method(checkParentheses) to other helper methods defined below.

    private boolean isOpeningBracket(char character) {
        if(character == '('){
            return true;
        }
        return false;
    }

    private boolean isClosingBracket(char character) {
        if(character == ')'){
            return true;
        }
        return false;
    }

    private boolean areMatchingBrackets(char open, char close) {
        if((open == '(' && close == ')')){
            return true;
        }
        return false;
    }
}



