package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RoundedButton extends JButton {

    private boolean isHovered = false;

    public RoundedButton(String text) {
        super(text);

        // Set the default blue color using the standard Java method
        setBackground(new Color(52, 120, 246));

        setFont(new Font("Segoe UI", Font.BOLD, 17));
        setForeground(Color.WHITE);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                isHovered = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                isHovered = false;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dynamically grab whatever background color was set for this specific button
        Color baseColor = getBackground();
        
        if (isHovered) {
            // Automatically make the color slightly darker when the mouse hovers over it
            g2.setColor(baseColor.darker());
        } else {
            g2.setColor(baseColor);
        }

        // Draw the rounded background
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
        g2.dispose();

        // Let the standard JButton handle drawing BOTH the text and the icon!
        super.paintComponent(g);
    }
}