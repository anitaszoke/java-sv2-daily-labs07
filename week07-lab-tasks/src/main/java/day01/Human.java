package day01;

import java.time.LocalDate;

public class Human {
    private String name;
    private int yearOfBirth;

    public Human(String name, int yearOfBirth) {
        if (isYearOfBirthValid(yearOfBirth) && isNameValid(name)) {
            this.name = name;
            this.yearOfBirth = yearOfBirth;
        }
    }

    public String getName() {
        return name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public boolean isYearOfBirthValid(int yearOfBirth) {
        if (LocalDate.now().getYear() - yearOfBirth > 120) {
            throw new IllegalArgumentException("Invalid year!");
        }
        return true;
    }

    public boolean isNameValid(String name) {
        if (!(name != null && name.indexOf(" ") > 0)) {
            throw new IllegalArgumentException("Invalid name!");
        }
        return true;
    }
}

