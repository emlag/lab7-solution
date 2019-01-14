//import com.sun.javaws.exceptions.InvalidArgumentException;
//import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.NoSuchElementException;

public class RecursionPractice {


    /**
     *  TODO 1: Write a recursive method that prints numbers 1...n in descending order.
     *  Assume n is always an integer >= 1.
     *  Expected: descending(5) should print 5...4...3...2...1...
     */

    public void descending(int n)
    {
        if (n < 1) return;

        System.out.print(n + "...");
        descending(n - 1);
    }

    /**
     *  TODO 2: Write a recursive method that returns n factorial
     *  Expected: fact(5) returns 120
     *  Expected: fact(3) returns 6
     *  Expected: facts(6) returns 720
     */

    public int fact(int n)
    {
        if (n < 1) throw new NoSuchElementException();
        if (n == 1) return 1;

        return n * fact(n - 1);
    }

    /**
     *  TODO 3: Write a recursive method that returns the exponentiation of x^m.
     *  Expected: exp(5, 5) returns 3125
     */

    public int exp(int x, int m)
    {
        if (m < 0) throw new NoSuchElementException();
        if (m == 0) return  1;
        if (m == 1) return x;

        return x * exp(x, m -1);

    }

    /**
     *  TODO 4: Recursive method to search for an int element in an int array.
     *  Expected: search(new int[]{5,4,3}, 3, 6) returns false
     *  Expected: search(new int[]{8,9,10,1}, 4, 8) returns true
     */

    public boolean search(int[] elements, int size, int elt)
    {
        if (size < 1) return false;

        return (elements[size-1] == elt) || search(elements, size -1, elt);
    }

    /**
     *  TODO 5: Recursive method that returns the sum of a all ints in a list.
     *  Expected: sum(new int[]{10,20,30}, 0) returns 60
     *  If list is empty, return 0 or NoSuchElementException.
     */

    public int sum(int[] elements, int i)
    {
        if (i >= elements.length) return 0;

        return elements[i] + sum(elements,i + 1);
    }

    /**
     * TODO 6: Recursive method that finds the greatest int element in an int list.
     * If list is empty return NoSuchElementException
     */

    public int greatest(int[] elements, int i)
    {
        if (elements.length == 0) throw new NoSuchElementException();

        if (i >= elements.length) return Integer.MIN_VALUE;

        return Integer.max(elements[i], greatest(elements, i + 1));
    }

    /**
     *  TODO 7: Recursive method find whether a String is a palindrome or not.
     *  isPalindrome("madam")→  true
     *  isPalindrome("racecar")→  true
     *  isPalindrome("step  on  no  pets")→  true
     *  isPalindrome("Java")→  false
     *  isPalindrome("byebye")→  false
     *  HINT: Remember that String is a char array.
     */
    public boolean isPalindrome(String word)
    {
        if (word.length() > 1) return (word.charAt(0) == word.charAt(word.length() - 1)) &&
                isPalindrome(word.substring(1, word.length() - 1));
        return true;
    }

    /**
     * TODO 8: Recursive method that returns a number made up of even digits from another number.
     *  evenDigits(8342116)    returns    8426
     *  evenDigits(40109)  returns    400
     *  evenDigits(8)  returns    8
     *  evenDigits(-163505)  returns    -60
     *  evenDigits(35179)  returns    0
     */

    public int evenDigits(int n)
    {
        if (n < 0)
        {
            return - evenDigits(-n);
        }
        else if (n == 0)
        {
            return 0;
        }
        else if (n % 2 == 0)
        {
            return 10 * evenDigits(n / 10) + n %  10;
        }
        else
        {
            return evenDigits(n / 10);
        }
    }

    /**
     *  Basics of Programming Languages.
     *  Programming languages use symbols such as + and * to help programmers
     *  deal with expressions. In this problem we'll build a recursive
     *  expression evaluator.
     *
     *
     *  TODO 9: Given a String like "((1 + 4) * (3 + 3))", write a recursive
     *  method that will return the correct answer as an int.
     *
     *  HINTS:
     *  1. Your base case should be looking for a string that is a number, if it is, then return it as an int.
     *  2. Otherwise, break up the expression into leftResult = evaluate(leftExpr)
     *     and rightResult = evaluate(rightExpr)
     *  3. Finally, return leftResult operator rightResult
     *
     *  Expected result: evaluate( "((1*17)+(2*(3+(4*9))))" ) returns 95.
     */

    public int evaluate (String expr)
    {
        if (stringIsInt(expr)) return Integer.parseInt(expr);

        String unwrappedExpression = expr.substring(1, expr.length() - 1); //removing parenthesis
        int operatorIdx = indexOfOperator(unwrappedExpression); // find the next operator not in parenthesis

        if (operatorIdx > 0)
        {
            String left = unwrappedExpression.substring(0, operatorIdx).trim(); //get the left expr string
            String right = unwrappedExpression.substring(operatorIdx + 1).trim(); //get the right expr string

            int leftResult = evaluate(left);  //find the value of the left expr
            int rightResult = evaluate(right); // find the value of the right expr

            char operator  = unwrappedExpression.charAt(operatorIdx); //get the operator itself

            if (operator == '+') return leftResult + rightResult; //evaluate an answer for +
            else if (operator == '*') return leftResult * rightResult; //evaluate answer for *

            else throw new NoSuchElementException(); // if its some other operator then return something bad
        }
        return 0;
    }

    private boolean stringIsInt(String expr)
    {
        return expr.matches("-?\\d+");
    }

    private int indexOfOperator(String unwrappedExpression)
    {
        char[] exprChars = unwrappedExpression.toCharArray();

        boolean inParenthesis = false;

        for (int idx = 0; idx < exprChars.length; idx++)
        {
            char chr = exprChars[idx];

            if ( chr == '(') inParenthesis = true;
            else if (chr == ')') inParenthesis = false;

            if ((chr == '*' || chr == '+') && !inParenthesis) return idx;
        }
        return -1;
    }



    public static void main(String[] args)
    {
        RecursionPractice test = new RecursionPractice();

        test.descending(5);
        System.out.println("");
        System.out.println("Fact of 5 " + test.fact(5));

        System.out.println("Evaluation of 2^3: " + test.exp(2, 3));
        System.out.println("Evaluation of 5^0: " + test.exp(5, 0));
        System.out.println("Evaluation of 3^2: " + test.exp(3, 2));

        System.out.println("Search 8 in [8,9,10,1]: " + test.search(new int[]{8,9,10,1}, 4, 8));
        System.out.println("Search 6 in [5,4,3]: " + test.search(new int[]{5,4,3}, 3, 6));

        System.out.println("Sum of 10,20,30 : " + test.sum(new int[]{10,20,30}, 0));

        System.out.println("Find the greatest int in [1]: " + test.greatest(new int[]{1}, 0));
        System.out.println("Find the greatest int in [5, 500, 1, 10]: " + test.greatest(new int[]{5, 500, 1, 10}, 0));

        System.out.println("Is madam a palindrome? " + test.isPalindrome("madam"));
        System.out.println("Is byebye a palindrome? " + test.isPalindrome("byebye"));
        System.out.println("Is ok a palindrome? " + test.isPalindrome("ok"));
        System.out.println("Is step  on  no  pets a palindrome? " + test.isPalindrome("step  on  no  pets"));

        System.out.println("Even digits of 8342116: " + test.evenDigits(8342116));
        System.out.println("Even digits of -163505: " + test.evenDigits(-163505));

        System.out.println("Evaluate (7 + 3): " + test.evaluate("(7 + 3)"));
        System.out.println("Evaluate ((1*17)+(2*(3+(4*9)))): " + test.evaluate("((1*17)+(2*(3+(4*9))))"));
        System.out.println("Evaluate (12*(10+10)): " + test.evaluate("(12*(10+10))"));
        System.out.println("Evaluate ((10+10)*12): " + test.evaluate("((10+10)*12)"));


    }
}
