import java.io.File;
import java.io.IOException;
import java.util.*;

public class WordReview {

    private static final String WORDS_FILE = "./data/words.txt";
    private Scanner input;
    private boolean error;
    private int index;
    private List<String> lines;
    private List<String> wordList;
    private List<String> defList;
    private int wordListSize;
    private int RANDOM_TIMES = 1000;

    public  WordReview() {
        runReviewApp();
    }

    private void runReviewApp() {
        wordList = new ArrayList<>();
        defList = new ArrayList<>();
        index = 0;
        error = false;
        String command;
        input = new Scanner(System.in);
        loadWords();
        if (!error) {
            displayWord(index);
        }

        while(!error) {
            command = input.next();

            processInput(command);
        }

    }

    private void displayWord(int i) {
        System.out.println(wordList.get(i));
        System.out.println("\nn->next word");
        System.out.println("\ns->show definition");
    }

    private void processInput(String command) {
        if (command.equals("n")) {
            if (index < wordListSize - 1) {
                index++;
                displayWord(index);
            } else {
                System.out.println("this is the end of the word list.\n");
            }

        } else if (command.equals("s")) {
            displayDef(index);
        } else {
            System.out.println("Please enter a valid command.");
        }
    }

    private void displayDef(int i) {
        System.out.println(defList.get(i));
        System.out.println("\nn->next word");
    }

    private void loadWords() {
        try {
            lines = Reader.readWords(new File(WORDS_FILE));
            int size = lines.size();
            for (int i = 0; i < size; i += 2) {
                wordList.add(lines.get(i));
            }
            wordListSize = wordList.size();

            for (int j = 1; j < size; j += 2) {
                defList.add(lines.get(j));
            }
//            for (int i = 0; i < wordListSize; i++) {
//                System.out.println(wordList.get(i));
//                System.out.println(defList.get(i));
//            }
            randomizeWords();



        } catch (IOException e) {
            System.out.println("404");
        }
    }

    private void randomizeWords() {
        Random rand = new Random();
        for (int i = 0; i < RANDOM_TIMES; i++) {
            int randIndex1 = rand.nextInt(wordListSize);
            int randIndex2 = rand.nextInt(wordListSize);
            Collections.swap(wordList, randIndex1, randIndex2);
            Collections.swap(defList, randIndex1, randIndex2);
        }
    }
}
