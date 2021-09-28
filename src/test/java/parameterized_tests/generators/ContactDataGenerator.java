package parameterized_tests.generators;

import parameterized_tests.models.ContactData;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {


    public static void main(String[] args) throws IOException {
        List<ContactData> list = generateContact(1);
        saveAsCsv(list);
    }


    public static List<ContactData> generateContact(int count) {
        List<ContactData> contacts = new ArrayList<ContactData>();
        for (int i = 0; i < count; i++) {
            String fullName = "Testovich%s";
            String phone = "333333333%s";
            String mail = "12@gmail.com%s";
            contacts.add(new ContactData(String.format(fullName, i), String.format(phone, i
            ), String.format(mail, i)));
        }
        return contacts;
    }

    public static void saveAsCsv(List<ContactData> contacts) throws IOException {
        File file = new File("src/test/resources/ContactData.csv");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (ContactData contact : contacts) {
                writer.write(String.format("%s,%s,%s\n", contact.getFullName(), contact.getPhone(), contact.getMail()));
            }
        }
    }
}
