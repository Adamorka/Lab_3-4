package oop_lab3.entity.it_workers;

import oop_lab3.entity.ITWorker;
import oop_lab3.entity.Worker;

import java.util.Objects;

public class Developer extends ITWorker implements DeveloperWork{
    private ProgramLanguage programLanguage;

    public Developer() {
        this.typeOfWorker = "Developer";
    }

    public Developer(String firstName, String lastName, int age, String resume, String nameOfItCompany, ProgramLanguage programLanguage) {
        super(firstName, lastName, age, resume, nameOfItCompany);
        this.programLanguage = programLanguage;
        this.typeOfWorker = "Developer";
    }

    @Override
    public String writeCode() {
        return "Write a code.";
    }

    public enum ProgramLanguage {
        JAVA,
        C,
        KOTLIN,
        JS,
        CPP,
        PYTHON,
        PHP;
    }

    public ProgramLanguage getProgramLanguage() {
        return programLanguage;
    }

    public void setProgramLanguage(ProgramLanguage programLanguage) {
        this.programLanguage = programLanguage;
    }


    @Override
    public String getTypeOfWorker() {
        return "Developer";
    }


    @Override
    public String toString() {
        return "Developer" +
                "-" + nameOfItCompany +
                "-" + firstName +
                "-" + lastName +
                "-" + age +
                "-" + resume +
                "-" + programLanguage +
                '\r' +
                '\n';
    }

    @Override
    public Worker fromString(String str) {
        String[] arr = str.split("-");
        return new Developer(arr[2], arr[3], Integer.parseInt(arr[4]), arr[5], arr[1], ProgramLanguage.valueOf(arr[6]));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Developer developer = (Developer) o;
        return programLanguage == developer.programLanguage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(programLanguage);
    }
}
