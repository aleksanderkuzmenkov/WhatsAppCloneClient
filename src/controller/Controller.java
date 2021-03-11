package controller;

import model.Model;
import view.View;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

public class Controller implements ActionListener, ListSelectionListener {
    private View view;
    private Model model;

    public Controller(String title) throws RemoteException {
        this.model = new Model();
        model.connectToServer();
        this.view = new View(title, model.getContactList());
        setListeners();
    }

    private void setListeners() {
        view.getMessagesView().addListSelectionListener(this);
        view.getSendMessage().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(view.getSendMessage().getActionCommand())){
            // --- check if message input not empty ---
            if(!view.getChatArea().getText().equals("") || view.getChatArea().getText() != null) {
                try {
                    // --- send message ---
                    model.sendMessage(model.getUserNumberFromName(view.getMessagesView().getSelectedValue().toString()), view.getChatArea().getText());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        view.getChatWith().setText("");
        view.getChatWith().setText("Chat with " + view.getMessagesView().getSelectedValue().toString());

        // --- TODO select data for selected user ---

    }
}
