import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormController {

    public TextField txtName;
    public TextField txtAge;
    public TextField txtEmail;
    public TextField txtTelephone;
    public TextField txtPassword;
    public TextField txtRoomID;
    public TextField txtRoomType;

    public void saveClickOnAction(ActionEvent actionEvent) {

        /**
         * Check "Demo" for different regex applying methods
         */

        // Name
        if (isValidUserName()) {
            System.out.println("matching Username");
        } else {
            System.err.println("Not matching Username");
        }

        // Age
        if (isValidAge()) {
            System.out.println("matching age");
        } else {
            System.err.println("Not matching age");
        }

        // email
        if (isValidEmail()) {
            System.out.println("matching email");
        } else {
            System.err.println("Not matching email");
        }

        // Contact No
        if (isValidPhoneNum()) {
            System.out.println("matching Telephone number");
        } else {
            System.err.println("Not matching Telephone number");
        }

        // Password
        if (isValidPassword()) {
            System.out.println("matching Password");
        } else {
            System.err.println("Not matching Password");
        }

        // Room ID
        if (isValidRoomID()) {
            System.out.println("matching Room ID");
        } else {
            System.err.println("Not matching Room ID");
        }

        // room type
        if (isValidRoomType()) {
            System.out.println("matching Type");
        } else {
            System.err.println("Not matching Type");
        }
    }

    private boolean isValidRoomType() {
        //============================= validate Type
        /**
         *  "^(AC|Non-AC)$"
         *  only get given values
         * */
        Pattern typePattern = Pattern.compile("^(AC|Non-AC|None)$");
        Matcher typeMatcher = typePattern.matcher(txtRoomType.getText());

        return typeMatcher.matches();
    }

    private boolean isValidRoomID() {
        //============================= validate Room ID
        /**
         *  "^(?:RM-)[0-9]{4}$"
         *  starts with "RM-"
         *  at least 4 numbers must contain
         * */
        Pattern roomTypePattern = Pattern.compile("^(?:RM-)[0-9]{4}$");
        Matcher roomTypeMatcher = roomTypePattern.matcher(txtRoomID.getText());

        return roomTypeMatcher.matches();
    }

    private boolean isValidPassword() {
        //============================= validate Password
        /**
         *  "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{4,}$"
         *  A-Z at least one character
         *  a-z at least one character
         *  0-9 at least one character
         *  #?!@$%^&*- at least one character
         *  at least 4 characters must contain
         * */
        Pattern pwPattern = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{4,}$");
        Matcher pwMatcher = pwPattern.matcher(txtPassword.getText());

        return pwMatcher.matches();
    }

    private boolean isValidPhoneNum() {
        //============================= validate Telephone number
        /**
         * "^(?:7|0|(?:\\+94))[0-9]{9,10}$"
         * matches a string that starts with either a 7, a 0, or the string "+94" (Sri lankan numbers)
         * followed by 9 or 10 digits
         */
        Pattern tpPattern = Pattern.compile("^(?:7|0|(?:\\+94))[0-9]{9,10}$");
        Matcher tpMatcher = tpPattern.matcher(txtTelephone.getText());

        return tpMatcher.matches();
    }

    private boolean isValidEmail() {
        //============================= validate email
        /**
         * "^([a-z 0-9]{2,})([@])([a-z]{2,9})([.])([a-z]{2,})$"
         * only simple a-z letters
         * character limit between 2 - 9
         * must contain @
         * must contain .
         */
        Pattern emailPattern = Pattern.compile("^([a-z 0-9]{2,})([@])([a-z]{2,9})([.])([a-z]{2,})$");
        Matcher emailMatcher = emailPattern.matcher(txtEmail.getText());

        return emailMatcher.matches();
    }

    private boolean isValidAge() {
        //============================= validate age
        /**
         * "^[0-9]{2,}$"
         *  only contain numbers (can't include just one number)
         */
        Pattern agePattern = Pattern.compile("^[0-9]{2,}$");
        Matcher ageMatcher = agePattern.matcher(txtAge.getText());

        return ageMatcher.matches();
    }

    private boolean isValidUserName() {
        //============================= validate Name
        /**
         * "^[a-zA-Z0-9]{4,}$"
         * only contain simple, capital letters & 1-9 numbers
         */
        Pattern userNamePattern = Pattern.compile("^[a-zA-Z0-9]{4,}$");
        Matcher userNameMatcher = userNamePattern.matcher(txtName.getText());

        return userNameMatcher.matches();
    }
}

//===========Sample code with Shake (required AnimateFX library)
/*
        private boolean isValidName () {
            Pattern pattern = Pattern.compile("^[a-zA-Z]{3,}$");
            Matcher matcher = pattern.matcher(txtName.getText());

            boolean isMatches = matcher.matches();
            if (isMatches) {
                return true;
            } else {
                Shake shakeUserName = new Shake(txtName);
                txtName.requestFocus();
                shakeUserName.play();
                return false;
            }
        }
*/