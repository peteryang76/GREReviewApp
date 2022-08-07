import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GREReviewApp {

    public static final String WORDS_FILE = "./data/words.txt";
    private static final String FORGOTTEN_WORDS_FILE = "./data/forgottenWords.txt";
    private static final int RANDOM_TIMES = 1000;
    public static final int WIDTH = 1200;
    public static final int HEIGHT = 1200;

    public List<String> wordList;
    public List<String> defList;
    public List<String> forgottenList;
    public List<String> forgottenDef;

    private int index;
    private boolean error;
    private boolean reviewAll;
    private boolean reviewF;

    public GREReviewApp() {
        initialize();
    }

    private void initialize() {
        index = 0;
        error = false;
        reviewAll = false;
        reviewF = false;
        wordList = new ArrayList<>();
        defList = new ArrayList<>();
        forgottenList = new ArrayList<>();
        forgottenDef = new ArrayList<>();
        loadWords();
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

            for (int i = 0; i < fSize; i += 2) {
                forgottenList.add(forgottenLines.get(i));
            }

            for (int i = 1; i < fSize; i += 2) {
                forgottenDef.add(forgottenLines.get(i));
            }
            randomizeWords(wordList, defList);
            randomizeWords(forgottenList, forgottenDef);

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


    public String displayWord() {
        if (reviewAll) {
            return wordList.get(index);
        } else if (reviewF) {
            return forgottenList.get(index);
        }
        return null;
    }

    public String displayDef() {
        if (reviewAll) {
            return defList.get(index);
        } else if (reviewF) {
            return forgottenDef.get(index);
        }
        return null;
    }

    public void addToForgottenWords(int i) {
        int size = forgottenList.size();
        boolean found = false;
        for (int j = 0; j < size; j++) {
            if (forgottenList.get(j).equals(wordList.get(i))) {
                found = true;
                break;
            }
        }
        if (!found) {
            forgottenList.add(wordList.get(i));
            forgottenDef.add(defList.get(i));
        }

    }

    public void deleteFromForgottenList(int i) {
        forgottenList.remove(i);
        forgottenDef.remove(i);
    }

    public void saveForgottenWords() {
        try {
            Writer writer = new Writer(new File(FORGOTTEN_WORDS_FILE));
            for (int i = 0; i < forgottenList.size(); i++) {
                writer.write(forgottenList.get(i));
                writer.write(forgottenDef.get(i));
            }
            writer.close();
            System.out.println("You have save your forgotten words!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void keyPressed(int keyCode) {
        if (keyCode == KeyEvent.VK_LEFT) {
            if (reviewAll || reviewF && index >= 1) {
                index -= 1;
            }
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            if (reviewAll && index < wordList.size() - 1) {
                index += 1;
            } else if (reviewF && index < forgottenList.size() - 1) {
                index += 1;
            }
        } else if (keyCode == KeyEvent.VK_UP) {
            if (reviewAll) {
                addToForgottenWords(index);
            }
        } else if (keyCode == KeyEvent.VK_DOWN) {
            if (reviewF) {
                deleteFromForgottenList(index);
            }
        }
    }

    public void setIndex(int i) {
        index = i;
    }

    public int getIndex() {
        return index;
    }

    public void setReviewAll(boolean flag) {
        reviewAll = flag;
    }

    public void setReviewF(boolean flag) {
        reviewF = flag;
    }

    public boolean getReviewAll() {
        return reviewAll;
    }

    public boolean getReviewF() {
        return reviewF;
    }

    public int getListSize() {
        if (reviewAll) {
            return wordList.size();
        } else {
            return forgottenList.size();
        }
    }


}
