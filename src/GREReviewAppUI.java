import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GREReviewAppUI extends JFrame {
    private GREReviewApp app;
    private WordsPanel wordsPanel;
    private MenuPanel menuPanel;
    private ControlPanelA controlPanel;


    public GREReviewAppUI() {
        super("GRE Review App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1200, 1200));
        ;
        app = new GREReviewApp();
        wordsPanel = new WordsPanel(app);
        controlPanel = new ControlPanelA(wordsPanel, app);
        menuPanel = new MenuPanel(app, wordsPanel, controlPanel);


        wordsPanel.setVisible(true);
        menuPanel.setVisible(true);
        controlPanel.setVisible(false);

        add(wordsPanel);
        add(menuPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);
        addKeyListener(new KeyHandler());

        pack();
        centreOnScreen();
        setVisible(true);
    }

    private void centreOnScreen() {
        Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
    }

    private class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            app.keyPressed(e.getKeyCode());
        }
    }
}
