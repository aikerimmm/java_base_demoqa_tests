package testdata;

import static utils.RandomUtils.*;

public class RegisterFormData {
    public String firstName = getRandomString(10);
    public String lastName = getRandomString(10);
    public String email = getRandomEmail();
    public String userNumber = getRandomPhone();
    public String[] genders = {"Male", "Female", "Other"};
    public String genterWrapper = getRandomItemFromStringArray(genders);
    public String birthYear = getYear(getRandomDate());
    public String birthMonth = getMonth(getRandomDate());
    public String birthDate = getDay(getRandomDate());
    public String subjectsInput = getSubject();
    public String hobbiesWrapper = getRandomHobbies();
    public String uploadPicture = "1.png";
    public String currentAddress = getRandomString(30);
    public String state = "NCR";
    public String city = getRandomCityByState(state);

}


