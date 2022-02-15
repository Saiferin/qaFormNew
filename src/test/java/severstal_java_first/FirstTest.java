package severstal_java_first;

import severstal_java_first.page.RegistrationPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FirstTest extends Config {

    RegistrationPage registrationPage = new RegistrationPage();

    private final TestData testData = new TestData();

    @Test
    @DisplayName("Проверка заполнения формы студента")
    public void checkStudentFormTest() {
        registrationPage.openFormPage();
        registrationPage.fillFirsName(testData.firstName)
                .fillLastName(testData.lastName)
                .fillEmail(testData.email)
                .fillUserNumber(testData.number)
                .selectGender(testData.gender)
                .fillDateOfBirth(testData.dateOfBirth)
                .fillSubject(testData.subject)
                .selectHobbies(testData.hobbies)
                .uploadPicture(testData.picture)
                .fillCurrentAddress(testData.currentAddress)
                .fillState(testData.state)
                .fillCity(testData.city)
                .clickSubmit();

        //Asserts
        registrationPage.assertForm(testData);
    }

}
