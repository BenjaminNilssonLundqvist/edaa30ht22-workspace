package textproc;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.security.Key;

public class BookReaderController {
    public BookReaderController(GeneralWordCounter counter) {
        SwingUtilities.invokeLater(() -> createWindow(counter, "Book Reader", 100, 300));
    }

    private void createWindow(GeneralWordCounter counter, String title, int width, int height) {
        SortedListModel<Map.Entry<String, Integer>> SortList = new SortedListModel<Map.Entry<String, Integer>>(
                counter.getWordList());
        
                JList<Map.Entry<String, Integer>> myList = new JList<Map.Entry<String, Integer>>(SortList);
                //Lägger till Frame,Panels,knappar och scrollPane
                JFrame frame = new JFrame(title);
                JPanel panel = new JPanel();
                JScrollPane scrollPane = new JScrollPane(myList);
                JButton b1= new JButton("Alfabetiskt");
                JButton b2= new JButton("Antal ggr");
                JButton search = new JButton("Sök");
               // Hur framen ska stängas
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Container pane = frame.getContentPane();
                
               
               // Lägger panelen i söder och knapparna i panelen
                pane.add(panel, BorderLayout.SOUTH);
                panel.add(b1);
                panel.add(b2);
                panel.add(search);
                // Lägger Scrollpane i "rutan"(pane)
                pane.add(scrollPane);
                frame.pack();
                frame.setVisible(true);
                // Sorterar efter alfabetiskt ordning vid b1 och numeriskt ordning vid b2

                b1.addActionListener(a->{
                    SortList.sort((e1,e2)->e1.getKey().compareTo(e2.getKey()));
                });
                b2.addActionListener(a->{
                    SortList.sort((e1,e2)->e2.getValue()-e1.getValue());
                });

                
              

    }

}
