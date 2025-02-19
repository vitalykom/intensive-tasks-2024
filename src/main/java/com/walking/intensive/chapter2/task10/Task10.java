package com.walking.intensive.chapter2.task10;

/**
 * Реализуйте метод isPalindrome(), который проверяет, является ли строка палиндромом.
 *
 * <p>Метод должен игнорировать пунктуацию, пробелы и регистр.
 *
 * <p>P.S. Мой любимый палиндром: Муза! Ранясь шилом опыта, ты помолишься на разум.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task10 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("Муза! Ранясь шилом опыта, ты помолишься на разум."));
    }

    static boolean isPalindrome(String inputString) {
        if (inputString == null || inputString.length() < 2) {
            return false;
        }

        StringBuilder palindrome = new StringBuilder();
        for (int i = 0; i < inputString.length(); i++) {
            if (!deleteSymbol(inputString.charAt(i))) {
                palindrome.append(inputString.charAt(i));
            }
        }
        int j = palindrome.length() - 1;
        for (int i = 0; i < palindrome.length(); i++) {
            if (!String.valueOf(palindrome.charAt(j)).equalsIgnoreCase(String.valueOf(palindrome.charAt(i)))) {
                return false;
            }
            j--;
        }
        return true;
    }

    static boolean deleteSymbol(Character character) {
        String symbol = " ,.;:!?-_";
        if (symbol.contains(character.toString())) {
            return true;
        }
        return false;
    }
}
