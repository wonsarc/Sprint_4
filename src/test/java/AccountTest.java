import io.qameta.allure.Step;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class AccountTest {
    private final String name;
    private final boolean isExpectedCheckNameToEmbosst;

    public AccountTest(String name, boolean isExpectedCheckNameToEmbosst) {
        this.name = name;
        this.isExpectedCheckNameToEmbosst = isExpectedCheckNameToEmbosst;
    }

    @Parameterized.Parameters
    public static Object[][] expectedCheckNameToEmbosst() {
        return new Object[][]{
                {"Т Ш", true},
                {"Тимоти Шаламееееее", true},
                {"ТимотиШаламе", false},
                {"Тимоти Шаламееееееeп", false},
                {"Т ", false},
                {"Тимоти  Шаламееееее", false},
                {" Тимоти Шаламе", false},
                {"Тимоти Шаламе ", false},
                {"ТимотиШаламе ", false},
                {" ТимотиШаламе", false},
                {" Тимоти Шаламе ", false},
                {null, false},
        };
    }

    @Test
    @Step("Expected check name to embosst")
    public void testGetKittensWithArgument() {
        Account account = new Account(name);
        Assert.assertEquals(isExpectedCheckNameToEmbosst, account.checkNameToEmboss());
    }

}
