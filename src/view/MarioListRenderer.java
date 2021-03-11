package view;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class MarioListRenderer extends DefaultListCellRenderer {

    Font font = new Font("helvitica", Font.BOLD, 24);

    private Map<String, ImageIcon> imageMap;

    public MarioListRenderer(Map<String, ImageIcon> imageMap) {
        this.imageMap = imageMap;
    }

    @Override
    public Component getListCellRendererComponent(
            JList list, Object value, int index,
            boolean isSelected, boolean cellHasFocus) {

        JLabel label = (JLabel) super.getListCellRendererComponent(
                list, value, index, isSelected, cellHasFocus);
        label.setIcon(imageMap.get((String) value));
        label.setHorizontalTextPosition(JLabel.RIGHT);
        label.setFont(font);
        return label;
    }

    public Map<String, ImageIcon> createImageMap(String[] list) {
        Map<String, ImageIcon> map = new HashMap<>();
        try {
            map.put("Mario", new ImageIcon(new URL("http://i.stack.imgur.com/NCsHu.png")));
            map.put("Luigi", new ImageIcon(new URL("http://i.stack.imgur.com/UvHN4.png")));
            map.put("Bowser", new ImageIcon(new URL("http://i.stack.imgur.com/s89ON.png")));
            map.put("Koopa", new ImageIcon(new URL("http://i.stack.imgur.com/QEK2o.png")));
            map.put("Princess", new ImageIcon(new URL("http://i.stack.imgur.com/f4T4l.png")));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return map;
    }
}