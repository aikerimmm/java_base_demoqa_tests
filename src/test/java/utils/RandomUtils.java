package utils;

import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.String.format;
import java.util.List;
import java.util.Map;


public class RandomUtils {

    private static final Random random = new Random();

    public static void main(String[] args) {
        System.out.println(RandomUtils.getRandomString(8));
        System.out.println(RandomUtils.getRandomEmail());
        System.out.println(RandomUtils.getRandomPhone());
        System.out.println(getRandomInt(0, 999999));
        System.out.println(getRandomInt(111111111, 888888888));
        System.out.println(RandomUtils.getRandomGender());

    }

    public static String getRandomString(int length) {
        String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        SecureRandom rnd = new SecureRandom();

        for (int i = 0; i < length; i++) {
            result.append(LETTERS.charAt(rnd.nextInt(LETTERS.length())));
        }
        return result.toString();
    }

    public static String getRandomEmail() {
        return format("%s@s.com", getRandomString(8), getRandomString(8));
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);

    }

    public static String getRandomPhone() {
        String phoneTemplate = "+%s (%s) %s - %s - %s";

        return format(phoneTemplate, getRandomInt(1, 9), getRandomInt(111, 999),
                getRandomInt(111, 999), getRandomInt(11, 99), getRandomInt(11, 99));
    }

//    public static String getRandomGender() {
//        String[] genders = {"Male","Female","Other"};
//
//        int randomIndex = getRandomInt(0,2);
//
//        return genders[randomIndex];
//    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};

        return getRandomItemFromStringArray(genders);
    }

    public static String getRandomItemFromStringArray(String[] stringArray) {

        int arrayLength = stringArray.length;
        int randomIndex = getRandomInt(0, arrayLength - 1);


        return stringArray[randomIndex];
    }

    public static LocalDate getRandomDate() {
        long minDay = LocalDate.of(1950, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(2010, 12, 31).toEpochDay();

        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);

        return LocalDate.ofEpochDay(randomDay);
    }

    public static String getDay(LocalDate date) {
        return String.valueOf(date.getDayOfMonth());
    }

    public static String getMonth(LocalDate date) {
        return date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }

    public static String getYear(LocalDate date) {
        return String.valueOf(date.getYear());
    }

    private static final String[] SUBJECTS = {
            "Maths", "Physics", "Chemistry", "Biology",
            "English", "Computer Science", "Commerce",
            "Accounting", "Economics", "Arts"};

    public static String getSubject() {
        return SUBJECTS[random.nextInt(SUBJECTS.length)];
    }

    public static String getRandomHobbies() {
        String[] hobbies = {"Sports", "Reading", "Music"};

        return getRandomItemFromStringArray(hobbies);
    }

    public static String getPicture() {
        return "1.png";
    }

    private static final String[] HOBBIES = {
            "NRC", "Reading", "Music"
    };

    public static String getHobby() {
        return HOBBIES[random.nextInt(HOBBIES.length)];
    }

    private static final Map<String, List<String>> STATE_CITY_MAP = Map.of(
            "NCR", List.of("Delhi", "Gurgaon", "Noida"),
            "Uttar Pradesh", List.of("Agra", "Lucknow", "Merrut"),
            "Haryana", List.of("Karnal", "Panipat"),
            "Rajasthan", List.of("Jaipur", "Jaiselmer")
    );

    public static String getRandomState() {
        return STATE_CITY_MAP.keySet()
                .stream()
                .skip(random.nextInt(STATE_CITY_MAP.size()))
                .findFirst()
                .orElseThrow();
    }

    public static String getRandomCityByState(String state) {
        List<String> cities = STATE_CITY_MAP.get(state);
        if (cities == null || cities.isEmpty()) {
            throw new IllegalArgumentException("No cities found for state: " + state);
        }
        return cities.get(random.nextInt(cities.size()));
    }
}



