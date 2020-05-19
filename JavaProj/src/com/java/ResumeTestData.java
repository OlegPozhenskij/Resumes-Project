package com.java;

import com.java.model.*;
import com.java.util.DateUtil;

import java.time.Month;
import java.util.EnumMap;
import java.util.Map;

import static com.java.model.ContactType.*;
import static com.java.model.SectionType.*;

public class ResumeTestData {
    public static Resume comleteResume(String uuid, String fullName) {
        Map<ContactType, String> contacts = new EnumMap<>(ContactType.class);
        Map<SectionType, Section> sections = new EnumMap<>(SectionType.class);

        contacts.put(PHONE,"89171585804");
        contacts.put(SKYPE, fullName);
        contacts.put(LINKEDIN,"-");
        contacts.put(MAIL, fullName + "2@gmail.com");
        contacts.put(GITHUB,"https://github.com/OlegPozhenskij");
        contacts.put(STACKOVERFOLW,"-");
        contacts.put(HOMEPAGE,"https://vk.com/o.pozhensky");

        sections.put(PERSONAL, new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));
        sections.put(OBJECTIVE, new TextSection("Junior Java developer"));
        sections.put(ACHIEVEMENT, new ListSection("Создал калькулятор", "Написал Тетрис",
                "Создал Бота в телеграмме", "В разработке своего проекта Резюме"));
        sections.put(QUALIFICATIONS, new ListSection("Languages: Java, JavaScript"));
        sections.put(EXPERIENCE, new OrganizationSection(
                new Organization("Yande", "https://yandex.ru/",
                        new Organization.Position(DateUtil.of(2012, Month.valueOf("MARCH")),
                                DateUtil.of(2015, Month.valueOf("MARCH")), "Java архитектор",
                                "Организация процесса"),
                        new Organization.Position(DateUtil.of(2012, Month.valueOf("MARCH")),
                                DateUtil.of(2015, Month.valueOf("MARCH")), "Java архитектор",
                                "Организация процесса разработки системы ")),
                new Organization("Google", "https://google.com/",
                        new Organization.Position(2008, Month.FEBRUARY, 2010, Month.MARCH, "Прикладная математика и информатика",
                                "Изучал программирование сложных систем, алгоритмы"))));
        sections.put(EDUCATION, new OrganizationSection(
                new Organization("TGU", "https://www.tltsu.ru/",
                        new Organization.Position(2008, Month.FEBRUARY, 2010, Month.MARCH, "Прикладная математика и информатика",
                                "Изучал программирование сложных систем, алгоритмы"))));

        return new Resume(uuid, fullName, contacts, sections);
    }
}
