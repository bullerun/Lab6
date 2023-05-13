package me.lab6.server.Utility;

import me.lab6.common.Data.Coordinates;
import me.lab6.common.Data.Difficulty;
import me.lab6.common.Data.Discipline;
import me.lab6.common.Data.LabWork;
import me.lab6.common.Exception.MustBeNotEmptyException;
import me.lab6.common.Exception.RangeException;
import me.lab6.server.Manager.CommandManager;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * auxiliary class for working with an instance of the LabWork class
 * @author Nikita and Vlad
 * @version 0.1
 */
public class LabAsk {
    private final Long MINIMAL_POINT = 0L;
    private final float MINIMAL_X_COORDINATES = -18;
    private Scanner scanner;

    private LabWork labWork;


    public LabAsk(Scanner scanner) {
        this.scanner = scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }


    public void setLabWork(LabWork labWork) {
        this.labWork = labWork;
    }

    public LabWork addLabWork() throws NoSuchElementException{
        this.labWork = new LabWork();
        nameAsk();
        coordinatesAsk();
        minimalPointAsk();
        difficultyAsk();
        disciplineAsk();
        return labWork;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void nameAsk() throws NoSuchElementException{
        while (true) {
            try {
                labWork.setName(scanner.nextLine().trim());
                break;
            } catch (MustBeNotEmptyException e) {
            }
        }
    }

    public void coordinatesAsk() throws NoSuchElementException{
        XAsk(labWork.getCoordinates());
        YAsk(labWork.getCoordinates());
    }

    public void XAsk(Coordinates coordinates) throws NoSuchElementException{
        while (true) {
            try {
                coordinates.setX(Float.parseFloat(scanner.nextLine().trim()));
                break;
            } catch (NumberFormatException e) {


            } catch (RangeException e) {


            } catch (IllegalArgumentException e) {


            }
        }
    }

    public void YAsk(Coordinates coordinates) throws NoSuchElementException{
        while (true) {
            try {

                coordinates.setY(Long.parseLong(scanner.nextLine().trim()));
                break;
            } catch (NumberFormatException e) {


            }
        }
    }

    public void minimalPointAsk() throws NoSuchElementException{
        while (true) {
            try {

                labWork.setMinimalPoint(Long.parseLong(scanner.nextLine().trim()));
                break;
            } catch (NumberFormatException e) {


            } catch (RangeException e) {


            }
        }
    }

    public void difficultyAsk() throws NoSuchElementException {
        while (true) {
            try {

                labWork.setDifficulty(scanner.nextLine().trim().toUpperCase());
                break;
            } catch (IllegalArgumentException e) {


            }
        }
    }

    public void disciplineAsk() throws NoSuchElementException{
        while (true) {
            try {

                String line = scanner.nextLine().trim();
                if (line.equals("") | line.equals("no")) {
                    labWork.setDiscipline(null);
                    break;
                }
                if (line.equals("yes")) {
                    if (labWork.getDiscipline() == null) {
                        labWork.setDiscipline(new Discipline());
                    }
                    nameDisciplineAsk(labWork.getDiscipline());
                    practiceHoursDisciplineAsk(labWork.getDiscipline());
                    break;
                }
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {


            }
        }

    }

    public void nameDisciplineAsk(Discipline discipline) throws NoSuchElementException{
        while (true) {
            try {

                discipline.setName(scanner.nextLine().trim());
                break;
            } catch (IllegalArgumentException e) {


            }
        }
    }

    public void practiceHoursDisciplineAsk(Discipline discipline) throws NoSuchElementException{
        while (true) {
            try {

                discipline.setPracticeHours(Integer.parseInt(scanner.nextLine().trim()));
                break;
            } catch (NumberFormatException e) {

            }
        }
    }
}
