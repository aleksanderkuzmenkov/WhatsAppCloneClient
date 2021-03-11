package view;

import javax.swing.*;
import java.awt.*;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class View extends JFrame {

    private JPanel leftSide = new JPanel();



    private JList messagesView;

    private JScrollPane listScrollPane;

    // --- chat bar elements ---

    private JPanel rightSide = new JPanel();
    private JLabel chatHeader = new JLabel("Chat with ...");

    private JPanel  chatBarHeaderLine = new JPanel();
    private JPanel gridPanel = new JPanel();

    private JPanel textAreaPanel = new JPanel();
    private JTextArea chatArea = new JTextArea(10,30);
    private JButton sendMessage = new JButton("Send");

    private JPanel topPanel = new JPanel();
    private JPanel topInfo = new JPanel();
    private JPanel middlePanel = new JPanel();
    private JPanel chatPanel = new JPanel();

    private JPanel testPanel = new JPanel();

    private JLabel chatWith = new JLabel("Chat with ");

    private JScrollPane scrollPane;

    private String[] listData;



    public View(String title, String[] contactList){
        super(title);
        Container cp = getContentPane();

        listData = contactList;

        prepareContactListPanel();

        prepareChatBar();


        gridPanel.setLayout(new GridLayout(1, 2));

        gridPanel.add(listScrollPane);
        gridPanel.add(rightSide);

        cp.add(gridPanel, BorderLayout.CENTER);

//        cp.add(rightSide, BorderLayout.EAST);

        settings();

    }

    private void prepareChatBar() {



        chatBarHeaderLine.setSize(350,200);
        chatBarHeaderLine.setBackground(Color.ORANGE);

        topPanel.add(topInfo.add(chatWith));

        middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));

        String[] testChatData = {"HEI","Hi","LOL","AHAHAH","HEI","Hi","LOL","AHAHAH","HEI","Hi","LOL","AHAHAH","HEI","Hi","LOL","AHAHAH"};

//        chatPanel.setLayout(new BoxLayout(chatPanel, BoxLayout.Y_AXIS));


        testPanel.setBackground(Color.red);

        testPanel.add(new JLabel("TESTING"), BorderLayout.PAGE_START);


//        chatPanel.add(new JLabel("TEST"));
//        chatPanel.add(new JLabel("TEST"));
//        chatPanel.add(new JLabel("TEST"));
//        chatPanel.add(new JLabel("TEST"));
//        chatPanel.add(new JLabel("TEST"));
//        chatPanel.add(new JLabel("TEST"));
//        chatPanel.add(new JLabel("TEST"));
        chatPanel.add(testPanel,BorderLayout.PAGE_START);

//        chatPanel.add(new JLabel("TEST"));
//        chatPanel.add(new JLabel("TEST"));
//        chatPanel.add(new JLabel("TEST"));
//        chatPanel.add(new JLabel("TEST"));
//        chatPanel.add(new JLabel("TEST"));
//        chatPanel.add(new JLabel("TEST"));
//        chatPanel.add(new JLabel("TEST"));
//        chatPanel.add(new JLabel("TEST"));
//        chatPanel.add(new JLabel("TEST"));
//        chatPanel.add(new JLabel("TEST"));
//        chatPanel.add(new JLabel("TEST"));
//        chatPanel.add(new JLabel("TEST"));
//        chatPanel.add(new JLabel("TEST"));
//        chatPanel.add(new JLabel("TEST"));
//        chatPanel.add(new JLabel("TEST"));
//        chatPanel.add(new JLabel("TEST"));
//        chatPanel.add(new JLabel("TEST"));
//        chatPanel.add(new JLabel("TEST"));
//        chatPanel.add(new JLabel("TEST"));
//        chatPanel.add(new JLabel("TEST"));
//        chatPanel.add(new JLabel("TEST"));
//        chatPanel.add(new JLabel("TEST"));
//        chatPanel.add(new JLabel("TEST"));
//        chatPanel.add(new JLabel("TEST"));
//        chatPanel.add(new JLabel("TEST"));
//        chatPanel.add(new JLabel("TEST"));
//        chatPanel.add(new JLabel("TEST"));
//        chatPanel.add(new JLabel("TEST"));
//        chatPanel.add(new JLabel("TEST"));
//        chatPanel.add(new JLabel("TEST"));
//        chatPanel.add(new JLabel("TEST"));
//        chatPanel.add(new JLabel("TEST"));
//        chatPanel.add(new JLabel("TEST"));
//        chatPanel.add(new JLabel("TEST"));
//        chatPanel.add(new JLabel("TEST"));
//        chatPanel.add(new JLabel("TEST"));

        chatPanel.setPreferredSize(new Dimension(300, 600));

//        JList messageList = new JList(testChatData);


        scrollPane = new JScrollPane(chatPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(200,300));


        middlePanel.add(scrollPane);

        textAreaPanel.add(chatArea);
        textAreaPanel.add(sendMessage);


        JLabel chat = new JLabel("CHaaat");

        chatPanel.setPreferredSize(new Dimension(100, 100) );

        middlePanel.add(textAreaPanel);

        rightSide.add(topPanel, BorderLayout.NORTH);
        rightSide.add(middlePanel, BorderLayout.CENTER);
        rightSide.setBackground(Color.LIGHT_GRAY);


    }

    private void settings() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(900,550);
    }

    private void prepareContactListPanel() {

//        String data[] = {"Amiran", "Viktor", "Der Typ vom Telekom", "DAD","Kunde"};
        messagesView = new JList(listData);

        messagesView.setFixedCellHeight(50);
        messagesView.setFont(new Font("Arial",Font.BOLD,20));

//        messagesView.setSelectionMode(JList.VERTICAL);

        listScrollPane = new JScrollPane(messagesView);
        listScrollPane.setPreferredSize(new Dimension(250,500));


        // --- TODO change list to fullSize ---

        leftSide.add(listScrollPane, BorderLayout.CENTER);
    }

    public JPanel getLeftSide() {
        return leftSide;
    }

    public JList getMessagesView() {
        return messagesView;
    }

    public JScrollPane getListScrollPane() {
        return listScrollPane;
    }

    public JPanel getRightSide() {
        return rightSide;
    }

    public JLabel getChatHeader() {
        return chatHeader;
    }

    public JPanel getChatBarHeaderLine() {
        return chatBarHeaderLine;
    }

    public JPanel getGridPanel() {
        return gridPanel;
    }

    public JPanel getTextAreaPanel() {
        return textAreaPanel;
    }

    public JTextArea getChatArea() {
        return chatArea;
    }

    public JButton getSendMessage() {
        return sendMessage;
    }

    public JLabel getChatWith() {
        return chatWith;
    }
}
