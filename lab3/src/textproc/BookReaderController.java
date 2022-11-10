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
       
        // Lägger till Frame,Panels,knappar och scrollPane
        JFrame frame = new JFrame(title);
        JPanel panel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(myList);
        JRadioButton b1 = new JRadioButton("Alfabetiskt");  //V4
        JRadioButton b2 = new JRadioButton("Antal ggr");
        
        // Hur framen ska stängas
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = frame.getContentPane();

        // Sökfält
        JPanel searchJPanel = new JPanel();
        JTextField searchField = new JTextField();
        JButton searchButton = new JButton("Sök");
        searchField.setPreferredSize(new Dimension(500, (int) searchButton.getPreferredSize().getHeight()));
        searchJPanel.add(searchButton);
        searchJPanel.add(searchField);

        // Lägger panelen i söder och knapparna i panelen
        pane.add(panel, BorderLayout.SOUTH);
        pane.add(searchJPanel, BorderLayout.NORTH);
        panel.add(b1);
        panel.add(b2);
        
        // Lägger Scrollpane i "rutan"(pane)
        pane.add(scrollPane);
        frame.pack();
        frame.setVisible(true);
       
        // Sorterar efter alfabetiskt ordning vid b1 och numeriskt ordning vid b2
        b1.addActionListener(a -> {
            SortList.sort((e1, e2) -> e1.getKey().compareTo(e2.getKey()));
        });
        b2.addActionListener(a -> {
            SortList.sort((e1, e2) -> e2.getValue() - e1.getValue());
        });

        //V1 Söker efter ordet i sökfältet, Trimmar bort mellanslag och gör om till små bokstäver
        searchButton.addActionListener(a -> {
            String word = searchField.getText().toLowerCase().trim();
           boolean found = false;
            for (int i = 0; i < SortList.getSize(); i++) {
                if (SortList.getElementAt(i).getKey().equals(word)) {
                    myList.setSelectedIndex(i);
                    found = true;
                    break;
                }
            }
            //V2
            if (!found) {
                JOptionPane.showMessageDialog(null, "Word not found");
            }
        });

    }

}
