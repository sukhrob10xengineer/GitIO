import java.io.*;

public class Main {
    public static void main(String[] args) {
        String sourceFilePath = "source.txt";
        String targetFilePath = "target.txt";
        String wordToFind = "word";
        String replacementWord = "replacement";
        int numberOfReplacements = 23;

        try {

            BufferedReader reader = new BufferedReader(new FileReader(sourceFilePath));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            reader.close();


            String modifiedContent = content.toString();
            for (int i = 0; i < numberOfReplacements; i++) {
                int index = modifiedContent.indexOf(wordToFind);
                if (index != -1) {
                    modifiedContent = modifiedContent.substring(0, index) + replacementWord +
                            modifiedContent.substring(index + wordToFind.length());
                } else {
                    break;
                }
            }


            BufferedWriter writer = new BufferedWriter(new FileWriter(targetFilePath));
            writer.write(modifiedContent);
            writer.close();

            System.out.println("File manipulation completed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

