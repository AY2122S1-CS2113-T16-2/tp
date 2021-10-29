package seedu.duke.exceptions;

import static seedu.duke.common.Messages.ADD_NOK_FORMAT_MESSAGE;

public class InvalidAddNokFormatException extends InvalidInputException {
    public InvalidAddNokFormatException() {
        super(ADD_NOK_FORMAT_MESSAGE);
    }

}
