package seedu.duke.list;

import seedu.duke.common.Elderly;
import seedu.duke.common.Medicine;
import seedu.duke.common.Appointment;
import seedu.duke.common.NextOfKin;
import seedu.duke.common.Record;


import java.util.Date;
import java.util.Objects;

//import seedu.duke.common.*;
import static seedu.duke.common.MagicValues.*;


public class ElderlyList {

    public ElderlyList() {
    }

    /**
     * Adds the elderly into the elderly array list.
     *
     * @param userLine Line that is inputted by the user.
     */
    public void addElderly(String userLine) {
        String[] paramList = userLine.split(" n/");
        String elderlyName = paramList[1];
        elderlyArrayList.add(new Elderly(elderlyName));
        ui.printAddElderlyMessage();
    }

    /**
     * Adds the medicine to the given elderly based on the input.
     *
     * @param userLine Line that is inputted by the user.
     */
    public void addMedicine(String userLine) {
        String[] paramList = userLine.split(" [nmf]/");
        String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
        Elderly elderly = getElderly(elderlyName);
        String medicineName = paramList[INDEX_OF_MEDICINE_NAME];
        String frequency = paramList[INDEX_OF_FREQUENCY];
        elderly.addMedicine(new Medicine(medicineName, frequency));
        ui.printAddMedicineMessage();
    }

    /**
     * Views all medicine the elderly needs to take based on the input.
     *
     * @param userLine Line that is inputted by the user.
     */
    public void viewMedicine(String userLine) {
        String[] paramList = userLine.split(" n/");
        String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
        Elderly elderly = getElderly(elderlyName);
        printMedicines(elderly);
    }

    /**
     * Prints all the medicine, given the elderly.
     *
     * @param elderly The elderly in question.
     */
    public void printMedicines(Elderly elderly) {
        int counter = 1;
        System.out.println("Medicine of " + elderly.getName() + " are shown below:");
        for (Medicine medicine : elderly.getMedicines()) {
            System.out.format("% 3d.", counter);
            System.out.println(medicine);
            counter++;
        }
    }

    /**
     * Adds the appointment to the given elderly based on the input.
     *
     * @param userLine Line that is inputted by the user.
     */
    public void addAppointment(String userLine) {
        String[] paramList = userLine.split(" [nldtp]/");
        String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
        Elderly elderly = getElderly(elderlyName);
        String location = paramList[INDEX_OF_LOCATION];
        String date = paramList[INDEX_OF_DATE];
        String time = paramList[INDEX_OF_TIME];
        String purpose;
        if (paramList.length == LENGTH_IF_PURPOSE_EXISTS) {
            purpose = paramList[INDEX_OF_PURPOSE];
        } else {
            purpose = "general checkup";
        }
        elderly.addAppointment(new Appointment(location, date, time, purpose));
        ui.printAddAppointmentMessage();
    }

    /**
     * Views all appointments the elderly has based on the input.
     *
     * @param userLine Line that is inputted by the user.
     */
    public void viewAppointment(String userLine) {
        String[] paramList = userLine.split(" n/");
        String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
        Elderly elderly = getElderly(elderlyName);
        printAppointments(elderly);
    }

    /**
     * Prints all the appointments, given the elderly.
     *
     * @param elderly The elderly in question.
     */
    public void printAppointments(Elderly elderly) {
        int counter = 1;
        System.out.println("Appointments of " + elderly.getName() + " are shown below:");
        for (Appointment appointment : elderly.getAppointments()) {
            System.out.format("% 3d.", counter);
            System.out.println(appointment);
            counter++;
        }
    }

    /**
     * Adds Next-Of-Kin information to the given elderly based on the input.
     *
     * @param userLine Line that is inputted by user.
     */
    public void addNok(String userLine) {
        String[] paramList = userLine.split(" [nkpear]/");
        String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
        Elderly elderly = getElderly(elderlyName);
        String nokName = paramList[INDEX_OF_NOK_NAME];
        String nokPhoneNumber = paramList[INDEX_OF_NOK_PHONE_NUMBER];
        String nokEmail = paramList[INDEX_OF_NOK_EMAIL];
        String nokAddress = paramList[INDEX_OF_NOK_ADDRESS];
        String nokRelationship = paramList[INDEX_OF_NOK_RELATIONSHIP];
        elderly.addNok(new NextOfKin(nokName, nokPhoneNumber, nokEmail, nokAddress, nokRelationship));
        ui.printAddNokMessage();
    }

    /**
     * Views the Next-Of_kin information of the elderly based on input.
     *
     * @param userLine Line that has been inputted by user.
     */
    public void viewNok(String userLine) {
        String[] paramList = userLine.split(" n/");
        String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
        Elderly elderly = getElderly(elderlyName);
        printNextOfKin(elderly);
    }

    /**
     * Prints the Next-Of-Kin information, given the elderly.
     *
     * @param elderly The elderly in question.
     */
    public void printNextOfKin(Elderly elderly) {
        System.out.println("Details of " + elderly.getName() + " Next-of-Kin are shown below:");
        System.out.println(elderly.getNextOfKin());
    }

    /**
     * Adds information to the given elderly based on the input.
     *
     * @param userLine Line that is inputted by user.
     */
    public void addRecord(String userLine) {
        String[] paramList = userLine.split(" [npa]/");
        String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
        Elderly elderly = getElderly(elderlyName);
        String elderlyPhoneNumber = paramList[INDEX_OF_ELDERLY_PHONE_NUMBER];
        String elderlyAddress = paramList[INDEX_OF_ELDERLY_ADDRESS];
        elderly.addRecord(new Record(elderlyPhoneNumber, elderlyAddress));
        ui.printAddRecordMessage();
    }

    /**
     * Views the information of the elderly based on input.
     *
     * @param userLine Line that has been inputted by user.
     */
    public void viewRecord(String userLine) {
        String[] paramList = userLine.split(" n/");
        String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
        Elderly elderly = getElderly(elderlyName);
        printRecord(elderly);
    }

    /**
     * Prints the information, given the elderly.
     *
     * @param elderly The elderly in question.
     */
    public void printRecord(Elderly elderly) {
        System.out.println("Record of " + elderly.getName() + " is shown below:");
        System.out.println(elderly.getRecord());
    }

    /**
     * Gets the Elderly object given the name.
     *
     * @param name String containing name of elderly.
     * @return Elderly object.
     */
    public Elderly getElderly(String name) {
        int counter = 0;
        for (Elderly elderly : elderlyArrayList) {
            if (Objects.equals(elderly.getName(), name)) {
                break;
            }
            counter++;
        }
        return elderlyArrayList.get(counter);
    }

    /**
     * Views the blood pressure of the elderly.
     *
     * @param userLine Line that has been inputted by user.
     */
    public void viewBloodPressure(String userLine) {
        String[] paramList = userLine.split(" n/");
        String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
        Elderly elderly = getElderly(elderlyName);
        printBloodPressure(elderly);
    }

    private void printBloodPressure(Elderly elderly) {
        double[] bloodPuressure = elderly.getBloodPressure();
        System.out.printf("Blood pressure of %s is now (%.2f %.2f)%n", elderly.getName(),
                bloodPuressure[0], bloodPuressure[1]);
    }

    /**
     * Sets the blood pressure of the elderly.
     *
     * @param userLine Line that has been inputted by user.
     */
    public void setBloodPressure(String userLine) {
        String[] paramList = userLine.split(" n/");
        String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
        double systolicPressure = Double.parseDouble(paramList[INDEX_OF_SYSTOLIC_PRESSURE]);
        double diastolicPressure = Double.parseDouble(paramList[INDEX_OF_DIASTOLIC_PRESSURE]);
        Elderly elderly = getElderly(elderlyName);
        elderly.setBloodPressure(systolicPressure, diastolicPressure);
        ui.printSetBloodPressureMessage();
        printBloodPressure(elderly);
    }

    /**
     * Views the birthday of the elderly.
     *
     * @param userLine Line that has been inputted by user.
     */
    public void viewBirthday(String userLine) {
        String[] paramList = userLine.split(" n/");
        String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
        Elderly elderly = getElderly(elderlyName);
        printBirthday(elderly);
    }

    private void printBirthday(Elderly elderly) {
        System.out.printf("Birthday of %s is %s%n", elderly.getName(), elderly.getBirthday());
    }

    /**
     * Sets the birthday of the elderly.
     *
     * @param userLine Line that has been inputted by user.
     */
    public void setBirthday(String userLine) {
        String[] paramList = userLine.split(" n/");
        String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
        String birthday = paramList[INDEX_OF_BIRTHDAY];
        Elderly elderly = getElderly(elderlyName);
        elderly.setBirthday(birthday);
        ui.printSetBirthdayMessage();
        printBirthday(elderly);
    }

    /**
     * Sets the vaccination status of the elderly to be true.
     *
     * @param userLine Line that has been inputted by user.
     */
    public void setVaccinated(String userLine) {
        String[] paramList = userLine.split(" n/");
        String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
        Elderly elderly = getElderly(elderlyName);
        elderly.setVaccinated();
        ui.printSetVaccinationMessage();
        printVaccinationStatus(elderly);
    }

    /**
     * Gets the vaccination status of the elderly to be true.
     *
     * @param userLine Line that has been inputted by user.
     */
    public void getVaccinationStatus(String userLine) {
        String[] paramList = userLine.split(" n/");
        String elderlyName = paramList[INDEX_OF_ELDERLY_NAME];
        Elderly elderly = getElderly(elderlyName);
        printVaccinationStatus(elderly);
    }

    private void printVaccinationStatus(Elderly elderly) {
        boolean isVaccinated = elderly.isVaccinated();
        System.out.printf("%s is currently", elderly.getName());
        if (!isVaccinated) {
            System.out.printf("not ");
        }
        System.out.printf("vaccinated.%n");
    }

}
