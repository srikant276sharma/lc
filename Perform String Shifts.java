Perform String Shifts
--

class Solution {
    public String stringShift(String s, int[][] shift) {
        int length = s.length();
        int finalAmount = 0;

        /*Calculate finalAmount. */
        for (int[] currentShift : shift) {
            int amount = currentShift[1];
            if (currentShift[0] == 0) {
                /*In case of Left, subtracting amount from finalAmount. */
                finalAmount -= amount;
            } else {
                /*In case of Right, adding amount to finalAmount. */
                finalAmount += amount;
            }
        }

        char[] finalChars = new char[length];
        /*In case finalAmount overflows String length. */
        finalAmount %= length;

        if (finalAmount < 0) {
            /*Left Shift. */
            for (int i = 0; i < length; i++) {
                finalChars[(length + i - (-finalAmount)) % length] = s.charAt(i);
            }
        } else if (finalAmount > 0) {
            /*Right Shift. */
            for (int i = 0; i < length; i++) {
                finalChars[(i + finalAmount) % length] = s.charAt(i);
            }
        } else {
            return s;
        }

        return String.valueOf(finalChars);
    }
}
