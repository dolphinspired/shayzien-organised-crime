package com.dylange.organisedcrime.ui;

import com.dylange.organisedcrime.config.OrganisedCrimeConfig;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

@Slf4j
public class OrganisedCrimePanel extends PluginPanel {

    private OrganisedCrimeConfig config;

    //overallKillsLabel.setFont(FontManager.getRunescapeSmallFont());

    public OrganisedCrimePanel(OrganisedCrimeConfig config, WorldClickedCallback worldClickedCallback) {
        this.config = config;

        setBorder(new EmptyBorder(6, 6, 6, 6));
        setBackground(ColorScheme.DARK_GRAY_COLOR);
        setLayout(new BorderLayout());

        // Create layout panel for wrapping
        final JPanel layoutPanel = new JPanel();
        layoutPanel.setLayout(new BoxLayout(layoutPanel, BoxLayout.Y_AXIS));
        add(layoutPanel, BorderLayout.NORTH);

    }

    @Override
    public void invalidate() {
        super.invalidate();

    }

    public void display(List<LocationViewState> viewState) {
        viewState.forEach(locationViewState -> log.error("View state item: " + locationViewState));
    }

    private JPanel getLocationView(LocationViewState locationViewState) {
        JPanel locationContainer = new JPanel();

        locationContainer.setLayout(new BorderLayout());
        locationContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        locationContainer.setBorder(new EmptyBorder(5, 5, 5, 10));
        locationContainer.setVisible(true);

        return locationContainer;
    }
}
