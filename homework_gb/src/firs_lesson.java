
public class firs_lesson {
    public static void main(String[] args) {
        userData user1 = new userData();
        Documentation.WriteFile(user1.lastName, user1.firstName, user1.patronymic, user1.phoneNumber, user1.dateBirth, user1.gender);
    }
}

