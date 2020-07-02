package at.madlmayr.kata12;

public class Decompressor {

    private static String decompressString(String input, int pos) {
        String number = "";
        String resultString = "";

        for (int charCounter = pos; charCounter < input.length(); charCounter++) {
            int charAtPos = (int) input.charAt(charCounter);

            if (charAtPos >= (int) '0' && charAtPos <= (int) '9') {
                number += (char) charAtPos;
            } else if (charAtPos == (int) '[') {
                String s = decompressString(input, charCounter + 1);
                // jump to where the square bracket is TODO: Validate.
                charCounter += s.length() + 1;
                int repetitions = Integer.parseInt(number);
                for (int rep = 0; rep < repetitions; rep++) {
                    resultString += s;
                }
            } else if (charAtPos == (int) ']') {
                return resultString;
            } else {
                resultString += (char) charAtPos;
            }
        }
        return resultString;
    }

    public static void main(String[] args) {


        System.out.println(decompressString("3[a]", 0));
        System.out.println(decompressString("2[3[a]b]", 0));
    }


}
