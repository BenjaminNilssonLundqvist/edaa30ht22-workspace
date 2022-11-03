package textproc;

import java.util.*;
import javax.swing.*;
import java.awt.*;

public class BookReaderController {
    public BookReaderController(GeneralWordCounter counter) {
        SwingUtilities.invokeLater(() -> createWindow(counter, "Book Reader", 100, 300));
    }

    private void createWindow(GeneralWordCounter counter, String title, int width, int height) {
        SortedListModel<Map.Entry<String, Integer>> SortList = new SortedListModel<Map.Entry<String, Integer>>(
                counter.getWordList());
        
                JList<Map.Entry<String, Integer>> myList = new JList<Map.Entry<String, Integer>>(SortList);

                JFrame frame = new JFrame(title);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Container pane = frame.getContentPane();
                
                JScrollPane scrollPane = new JScrollPane(myList);
                pane.add(scrollPane);
                frame.pack();
                frame.setVisible(true);

    }

}
