package severstal_java_first;

import severstal_java_first.page.pageTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class firstTest extends basicTest{

    pageTest practiceFormPage = new pageTest();

    private final TestData testData = new TestData();

    @Test
    @DisplayName("Проверка заполнения формы студента")
    public void checkStudentFormTest() {
        practiceFormPage.openPracticeFormPage();
        practiceFormPage.fillFirsName(testData.firstName)
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
        practiceFormPage.assertForm(testData);
    }

}
