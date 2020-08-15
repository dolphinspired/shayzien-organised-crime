package com.dylange.organisedcrime.ui;

import com.dylange.organisedcrime.OrganisedCrimePlugin;
import com.dylange.organisedcrime.config.OrganisedCrimeConfig;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

@Slf4j
public class OrganisedCrimePanel extends PluginPanel {

    private OrganisedCrimePlugin plugin;
    private OrganisedCrimeConfig config;

    private JPanel worldsContainer = new JPanel();

    //overallKillsLabel.setFont(FontManager.getRunescapeSmallFont());

    public OrganisedCrimePanel(OrganisedCrimePlugin plugin, OrganisedCrimeConfig config) {
        this.plugin = plugin;
        this.config = config;

        setBorder(new EmptyBorder(6, 6, 6, 6));
        setBackground(ColorScheme.DARK_GRAY_COLOR);
        setLayout(new BorderLayout());

        // Create layout panel for wrapping
        final JPanel layoutPanel = new JPanel();
        layoutPanel.setLayout(new BoxLayout(layoutPanel, BoxLayout.Y_AXIS));
        add(layoutPanel, BorderLayout.NORTH);

        worldsContainer.setLayout(new BorderLayout());
        worldsContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);
//        worldsContainer.setPreferredSize(new Dimension(0, 30));
        worldsContainer.setBorder(new EmptyBorder(5, 5, 5, 10));
        worldsContainer.setVisible(true);
    }

    @Override
    public void invalidate() {
        super.invalidate();
        log.error("PANEL, number of items to draw: " + plugin.gangInfoMap.size());
    }
}
