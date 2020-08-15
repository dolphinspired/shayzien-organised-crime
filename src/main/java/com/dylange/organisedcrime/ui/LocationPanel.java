package com.dylange.organisedcrime.ui;

import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.util.ImageUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.function.Consumer;

public class LocationPanel extends JPanel {

    public LocationPanel(LocationViewState viewState, Consumer<Integer> onWorldClicked) {
        Color backgroundColour = ColorScheme.DARKER_GRAY_COLOR.darker();
        setLayout(new BorderLayout(0, 1));
        setBackground(backgroundColour);

        JSeparator separator = new JSeparator(JSeparator.HORIZONTAL);
        separator.setBackground(ColorScheme.MEDIUM_GRAY_COLOR);

        JPanel descriptionContainer = new JPanel();
//        descriptionContainer.setLayout(new BoxLayout(descriptionContainer, BoxLayout.Y_AXIS));
        descriptionContainer.setLayout(new GridBagLayout());
        descriptionContainer.setBorder(new EmptyBorder(8, 8, 8, 8));
        descriptionContainer.setBackground(backgroundColour);

        JPanel worldsContainer = new JPanel();
        int numRows = viewState.getWorldToTimeRemainingText().keySet().size();
        worldsContainer.setLayout(new GridLayout(numRows, 1, 0, 2));
        worldsContainer.setBorder(new EmptyBorder(8, 8, 8, 8));
        worldsContainer.setBackground(backgroundColour);

        add(separator, BorderLayout.NORTH);
        add(descriptionContainer, BorderLayout.CENTER);
        add(worldsContainer, BorderLayout.SOUTH);

        GridBagConstraints descriptionConstraints = new GridBagConstraints();
        descriptionConstraints.fill = GridBagConstraints.HORIZONTAL;
        descriptionConstraints.gridy = 0;

        GridBagConstraints locationImageConstraints = new GridBagConstraints();
        locationImageConstraints.fill = GridBagConstraints.HORIZONTAL;
        locationImageConstraints.gridy = 1;
        locationImageConstraints.anchor = GridBagConstraints.CENTER;

        JTextArea descriptionLabel = new JTextArea(viewState.getDescription());
        descriptionLabel.setEditable(false);
        descriptionLabel.setFocusable(false);
        descriptionLabel.setWrapStyleWord(true);
        descriptionLabel.setLineWrap(true);
        descriptionLabel.setFont(FontManager.getRunescapeFont());
        descriptionContainer.add(descriptionLabel, descriptionConstraints);

        BufferedImage locationIcon = ImageUtil.getResourceStreamFromClass(getClass(), viewState.getImage());
        JLabel locationImage = new JLabel(new ImageIcon(new ImageIcon(locationIcon).getImage().getScaledInstance(214, 214, Image.SCALE_DEFAULT)));
        descriptionContainer.add(locationImage, locationImageConstraints);

        viewState.getWorldToTimeRemainingText().forEach((world, timeRemainingText) -> {
            String buttonText = String.format("W%d %s", world, timeRemainingText);
            JButton worldButton = new JButton(buttonText);
            worldButton.addActionListener(e -> onWorldClicked.accept(world));
            worldsContainer.add(worldButton);
        });
    }
}
