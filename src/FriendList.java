import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class FriendList extends JFrame {
    private JTable friendsTable;
    private JTextField friendNameField;
    private JButton addButton;
    private JPanel contentPanel;

    private final ArrayList<Friend> friends;

    public FriendList() {
        friends = new ArrayList<>();

        addButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);

                addFriend();
            }
        });

        setTitle("Friendship");
        setSize(50, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPanel);
        pack();
        setVisible(true);
    }

    private void addFriend() {
        DefaultTableModel model = (DefaultTableModel) friendsTable.getModel();
        Friend friend = new Friend(friendNameField.getText());

        this.friends.add(friend);

        model.addRow(new String[]{friend.name()});

        friendNameField.setText("");
    }

    private void createUIComponents() {
        DefaultTableModel model = new DefaultTableModel(
                new String[][]{},
                new String[]{"Name"}
        );

        friendsTable = new JTable(model);
    }
}
