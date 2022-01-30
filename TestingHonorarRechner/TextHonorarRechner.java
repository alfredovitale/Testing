package de.vitale.texthonorar.rechner;

import java.util.*;
import java.util.stream.Collectors;

public class TextHonorarRechner {

    public String calculateRoyalty(String inputString) {

        //If string is null throw NullPointerException
        if (null == inputString) {
            throw new NullPointerException();
        }
        String royalty = "";
        long totalCharCount = 0l;
        long pictureCount = 0;
        Boolean isCheating = checkCheating(inputString);
        if (isCheating) {
           return royalty = "$0";
        }
        //If string is empty then generate royalty as 0.
        if (!isEmpty(inputString.trim())) {
            //calculate Leerzeichen
            long spaceCount = inputString.chars().filter(c -> c == (int) ' ').count();
            //calculate the length of string
            totalCharCount = inputString.length();
            //calculate  actual char excluding spaces
            totalCharCount = totalCharCount - spaceCount;
            //calculate Honorar
            double royaltyRate = (totalCharCount / 10.0);
            royalty = "$" + royaltyRate;
            //count frequency of picture word
            pictureCount = Arrays.stream(inputString.split(" ")).filter(item -> item.contains("picture")).collect(Collectors.toList()).size();
        } else {
            royalty = "$0";
        }
        System.out.println("Number of Characters are: " + totalCharCount);
        System.out.println("Royalty payment: " + royalty);
        System.out.println("Number of pictures: " + pictureCount);
        return royalty;
    }

    private Boolean checkCheating(String inputString) {
        Set<Integer> count = new HashSet<>();
        String[] words = inputString.split(" ");
        Map<String, Integer> map = new LinkedHashMap<>();
        Arrays.stream(words).forEach(e -> map.put(e, map.getOrDefault(e, 0) + 1));
        map.forEach((k, v) -> {
            count.add(v);
        });
        if (count.size() == 1) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(Object str) {
        return str == null || "".equals(str);
    }

    public static void main(String[] args) {
        TextHonorarRechner textHonorarRechner = new TextHonorarRechner();
        String input = "blab and again bla picture la blab la bla and a picture again. What picture. Bla so do it bla picture blab la blab la blab la bla.";
        textHonorarRechner.calculateRoyalty(input);
    }
}
