package com.dylange.organisedcrime.ui;

import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.function.Consumer;

public class LocationPanel extends JPanel {

    public LocationPanel(LocationViewState viewState, Consumer<Integer> onWorldClicked) {
        Color backgroundColour = ColorScheme.DARKER_GRAY_COLOR.darker();
        setLayout(new BorderLayout(0, 1));
        setBorder(new EmptyBorder(5, 0, 0, 0));
        setBackground(backgroundColour);

        JPanel descriptionContainer = new JPanel();
        descriptionContainer.setLayout(new BoxLayout(descriptionContainer, BoxLayout.Y_AXIS));
        descriptionContainer.setBorder(new EmptyBorder(8, 8, 8, 8));
        descriptionContainer.setBackground(backgroundColour);

        JPanel worldsContainer = new JPanel();
        int numRows = viewState.getWorldToTimeRemainingText().keySet().size();
        worldsContainer.setLayout(new GridLayout(numRows, 1, 0, 2));
        worldsContainer.setBorder(new EmptyBorder(8, 8, 8, 8));
        worldsContainer.setBackground(backgroundColour);

        add(descriptionContainer, BorderLayout.NORTH);
        add(worldsContainer, BorderLayout.CENTER);

        JTextArea descriptionLabel = new JTextArea(viewState.getDescription());
        descriptionLabel.setEditable(false);
        descriptionLabel.setFocusable(false);
        descriptionLabel.setWrapStyleWord(true);
        descriptionLabel.setLineWrap(true);
        descriptionLabel.setFont(FontManager.getRunescapeFont());
        descriptionContainer.add(descriptionLabel);

        viewState.getWorldToTimeRemainingText().forEach((world, timeRemainingText) -> {
            String buttonText = String.format("W%d %s", world, timeRemainingText);
            JButton worldButton = new JButton(buttonText);
            worldButton.addActionListener(e -> onWorldClicked.accept(world));
            worldsContainer.add(worldButton);
        });
    }
}
