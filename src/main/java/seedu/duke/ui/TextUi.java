package seedu.duke.ui;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import seedu.duke.common.Elderly;

import static seedu.duke.common.MagicValues.INDEX_OF_DIASTOLIC_PRESSURE_IN_ARRAY;
import static seedu.duke.common.MagicValues.INDEX_OF_SYSTOLIC_PRESSURE_IN_ARRAY;
import static seedu.duke.common.Messages.ADD_NOK_MESSAGE;
import static seedu.duke.common.Messages.ADD_RECORD_MESSAGE;
import static seedu.duke.common.Messages.ADD_MEDICINE_MESSAGE;
import static seedu.duke.common.Messages.ADD_APPOINTMENT_MESSAGE;
import static seedu.duke.common.Messages.NUMBER_OF_ELDERLY_STRING;
import static seedu.duke.common.Messages.WELCOME_MESSAGE;
import static seedu.duke.common.Messages.PROMPT_MESSAGE;
import static seedu.duke.common.Messages.LOGO;
import static seedu.duke.common.Messages.GOODBYE_MESSAGE;
import static seedu.duke.common.Messages.INVALID_COMMAND_MESSAGE;
import static seedu.duke.common.Messages.ADD_ELDERLY_MESSAGE;
import static seedu.duke.common.Messages.SET_VACCINATED_MESSAGE;
import static seedu.duke.common.Messages.SET_BIRTHDAY_MESSAGE;
import static seedu.duke.common.Messages.SET_BLOOD_PRESSURE_MESSAGE;
import static seedu.duke.common.Messages.SET_DIET_MESSAGE;

public class TextUi {
    private final Scanner in;
    private final PrintStream out;

    public TextUi() {
        this(System.in, System.out);
    }

    /**
     * Sets the default constructor for interaction with UI.
     *
     * @param in  A Scanner object.
     * @param out A PrintStream object.
     */
    public TextUi(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
    }

    /**
     * Prints the welcome message to the user.
     */
    public void printWelcomeMessage() {
        out.println(LOGO);
        out.println(WELCOME_MESSAGE);
    }

    /**
     * Prompts the user for input and returns the received input.
     *
     * @return Line entered by the user.
     */
    public String getUserInput() {
        out.print(PROMPT_MESSAGE);
        String input = in.nextLine();
        // Keep getting input until its not empty
        while (input.trim().isEmpty()) {
            input = in.nextLine();
        }
        return input;
    }

    /**
     * Prints Goodbye message to user.
     */
    public void printGoodByeMessage() {
        out.println(GOODBYE_MESSAGE);
    }

    /**
     * Prints to the screen that you don't understand the commands.
     */
    public void printUnknownCommandMessage() {
        out.println(INVALID_COMMAND_MESSAGE);
    }

    /**
     * Prints Add Elderly message to user.
     */
    public void printAddElderlyMessage() {
        out.println(ADD_ELDERLY_MESSAGE);
    }

    /**
     * Prints acknowledgement of appointment added to user.
     */
    public void printAddAppointmentMessage() {
        out.println(ADD_APPOINTMENT_MESSAGE);
    }

    /**
     * Prints acknowledgement of medicine added to user.
     */
    public void printAddMedicineMessage() {
        out.println(ADD_MEDICINE_MESSAGE);
    }

    /**
     * Prints acknowledgement of NOK added to user.
     */
    public void printAddNokMessage() {
        out.println(ADD_NOK_MESSAGE);
    }

    /**
     * Prints acknowledgement of record added to user.
     */
    public void printAddRecordMessage() {
        out.println(ADD_RECORD_MESSAGE);
    }

    /**
     * Prints acknowledgement of Vaccination status added to user.
     */
    public void printSetVaccinationMessage(Elderly elderly) {
        out.printf(SET_VACCINATED_MESSAGE, elderly.getName());
    }

    /**
     * Prints acknowledgement of birthday added to user.
     */
    public void printSetBirthdayMessage(Elderly elderly) {
        out.printf(SET_BIRTHDAY_MESSAGE, elderly.getName(), elderly.getBirthday());
    }

    /**
     * Prints acknowledgement of blood pressure added to user.
     */
    public void printSetBloodPressureMessage(Elderly elderly) {
        out.printf(SET_BLOOD_PRESSURE_MESSAGE, elderly.getName(),
                elderly.getBloodPressure()[INDEX_OF_SYSTOLIC_PRESSURE_IN_ARRAY],
                elderly.getBloodPressure()[INDEX_OF_DIASTOLIC_PRESSURE_IN_ARRAY]);
    }

    /**
     * Prints the list of elderly given a consolidated list of elderly.
     *
     * @param elderlyListString A string containing a consolidated list of elderly.
     */
    public void printElderlyList(String elderlyListString) {
        out.println(elderlyListString);
    }

    /**
     * Prints acknowledgement of dietary preference of elderly added to user.
     */
    public void printSetDietMessage(Elderly elderly) {
        out.printf(SET_DIET_MESSAGE, elderly.getName(), elderly.getDiet());
    }
}
