import java.io.File;
import java.io.IOException;
import java.util.*;

public class WordReview {

    private static final String WORDS_FILE = "./data/words.txt";
    private static final String FORGOTTEN_WORDS_FILE = "./data/forgottenWords.txt";
    private Scanner input;
    private boolean error;
    private boolean reviewAll;
    private boolean reviewF;
    private int index;
    private List<String> wordList;
    private List<String> defList;
    private List<String> forgottenWords;
    private List<String> forgottenDefs;
    private int RANDOM_TIMES = 1000;

    public  WordReview() {
        runReviewApp();
    }

    private void runReviewApp() {
        wordList = new ArrayList<>();
        defList = new ArrayList<>();
        forgottenWords = new ArrayList<>();
        forgottenDefs = new ArrayList<>();
        index = 0;
        error = false;
        reviewAll = false;
        reviewF = false;
        String command;
        input = new Scanner(System.in);
        loadWords();
        displayMenu();

        while(!error) {
            command = input.next();

            processInput(command);
        }

    }

    private void displayMenu() {
        System.out.println("Welcome to use GRE Review App!\n");
        System.out.println("all->Review all words\n");
        System.out.println("forgotten->Review words in forgotten list\n");
    }

    private void displayWord(int i, List<String> listOfWords) {
        System.out.println(listOfWords.get(i));
        if (reviewAll) {
            System.out.println("\na->mark as forgotten");
            System.out.println("\nsave->save forgotten list to local");
        } else if (reviewF) {
            System.out.println("\nd->delete from forgotten list");
        }
        System.out.println("\nn->next word");
        System.out.println("\ns->show definition");
    }

    private void processInput(String command) {
        switch (command) {
            case "n":
                int size = 0;
                if (reviewAll) {
                    size = wordList.size();
                } else if (reviewF) {
                    size = forgottenWords.size();
                } else {
                    error = true;
                }
                if (index < size - 1) {
                    index++;
                    if (reviewAll) {
                        displayWord(index, wordList);
                    } else if (reviewF) {
                        displayWord(index, forgottenWords);
                    }

                } else {
                    System.out.println("this is the end of the word list.\n");
                }

                break;
            case "s":
                displayDef(index);
                break;
            case "a":
                addToForgottenWords(index);
                break;
            case "save":
                saveForgottenWords();
                break;
            case "all":
                reviewAll = true;
                reviewF = false;
                displayWord(index, wordList);
                break;
            case "forgotten":
                reviewF = true;
                reviewAll = false;
                displayWord(index, forgottenWords);
                break;
            case "d":
                deleteFromForgottenList(index);
                break;
            default:
                System.out.println("Please enter a valid command.");
                break;
        }
    }

    private void displayDef(int i) {
        if (reviewAll) {
            System.out.println(defList.get(i));
            System.out.println("\na->add to forgotten words");
        } else if (reviewF) {
            System.out.println(forgottenDefs.get(i));
            System.out.println("\nd->delete from forgotten words");
        }
        System.out.println("\nn->next word");
    }

    private void addToForgottenWords(int i) {
        int size = forgottenWords.size();
        boolean found = false;
        for (int j = 0; j < size; j++) {
            if (forgottenWords.get(j).equals(wordList.get(i))) {
                found = true;
                break;
            }
        }
        if (!found) {
            forgottenWords.add(wordList.get(i));
            forgottenDefs.add(defList.get(i));
        }

    }

    private void deleteFromForgottenList(int i) {
        forgottenWords.remove(i);
        forgottenDefs.remove(i);
    }

    private void saveForgottenWords() {
        try {
            Writer writer = new Writer(new File(FORGOTTEN_WORDS_FILE));
            for (int i = 0; i < forgottenWords.size(); i++) {
                writer.write(forgottenWords.get(i));
                writer.write(forgottenDefs.get(i));
            }
            writer.close();
            System.out.println("You have save your forgotten words!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void loadWords() {
        try {
            List<String> lines = Reader.readWords(new File(WORDS_FILE));
            List<String> forgottenLines = Reader.readWords(new File(FORGOTTEN_WORDS_FILE));
            int size = lines.size();
            int fSize = forgottenLines.size();
            for (int i = 0; i < size; i += 2) {
                wordList.add(lines.get(i));
            }

            for (int j = 1; j < size; j += 2) {
                defList.add(lines.get(j));
            }

            for (int i = 0; i <fSize; i += 2) {
                forgottenWords.add(forgottenLines.get(i));
            }

            for (int i = 1; i < fSize; i += 2) {
                forgottenDefs.add(forgottenLines.get(i));
            }
            randomizeWords(wordList, defList);
            randomizeWords(forgottenWords, forgottenDefs);



        } catch (IOException e) {
            System.out.println("404");
        }
    }

    private void randomizeWords(List<String> words, List<String> defs) {
        Random rand = new Random();
        int size = words.size();
        if (size == 0) {
            return;
        }
        for (int i = 0; i < RANDOM_TIMES; i++) {
            int randIndex1 = rand.nextInt(size);
            int randIndex2 = rand.nextInt(size);
            Collections.swap(words, randIndex1, randIndex2);
            Collections.swap(defs, randIndex1, randIndex2);
        }
    }
}
