package severstal_java_first.page;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import severstal_java_first.TestData;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    SelenideElement
            firstName = $("#firstName"),
            lastName = $("#lastName"),
            email = $("#userEmail"),
            userNumber = $("#userNumber"),
            gender = $("#genterWrapper"),
            subject = $("#subjectsInput"),
            hobbies = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submit = $("#submit");

    public RegistrationPage openFormPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage fillFirsName(String firstName) {
        this.firstName.val(firstName);
        return this;
    }

    public RegistrationPage fillLastName(String lastName) {
        this.lastName.val(lastName);
        return this;
    }

    public RegistrationPage fillEmail(String email) {
        this.email.val(email);
        return this;
    }

    public RegistrationPage fillUserNumber(String number) {
        userNumber.val(number);
        return this;
    }

    public RegistrationPage selectGender(String genderName) {
        gender.$(byText(genderName)).click();
        return this;
    }

    public RegistrationPage fillSubject(String subject) {
        this.subject.val(subject);
        return this;
    }

    public RegistrationPage selectHobbies(List<String> hobbies) {
        hobbies.forEach(hobby -> this.hobbies.$(byText(hobby)).click());
        return this;
    }

    public RegistrationPage uploadPicture(String filePath) {
        uploadPicture.uploadFromClasspath(filePath);
        return this;
    }

    public RegistrationPage fillCurrentAddress(String Address) {
        currentAddress.scrollTo().val(Address);
        return this;
    }

    public RegistrationPage fillState(String State) {
        stateInput.val(State).pressEnter();
        return this;
    }

    public RegistrationPage fillCity(String City) {
        cityInput.val(City).pressEnter();
        return this;
    }

    public RegistrationPage fillDateOfBirth(Date birthDay) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birthDay);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(calendar.get(Calendar.MONTH));
        $(".react-datepicker__year-select").selectOption(String.valueOf(calendar.get(Calendar.YEAR)));
        $(".react-datepicker__month").$(byText(
                String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)))).click();
        return this;
    }

    public RegistrationPage clickSubmit() {
        submit.click();
        return this;
    }

    public RegistrationPage assertForm(TestData testData) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM,yyyy", Locale.ENGLISH);
        $$x("//div[@class='modal-body']//td[2]").shouldHave(CollectionCondition.exactTexts(
                testData.firstName + " " + testData.lastName, testData.email,
                testData.gender, testData.number, dateFormat.format(testData.dateOfBirth),
                "", testData.hobbies.get(0) + ", " + testData.hobbies.get(1), testData.picture,
                testData.currentAddress, testData.state + " " + testData.city));
        return this;
    }


}


