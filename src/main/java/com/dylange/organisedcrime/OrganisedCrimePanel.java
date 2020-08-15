package com.dylange.organisedcrime;

import com.dylange.organisedcrime.config.OrganisedCrimeConfig;
import net.runelite.client.ui.PluginPanel;

public class OrganisedCrimePanel extends PluginPanel {

    private OrganisedCrimePlugin plugin;
    private OrganisedCrimeConfig config;

    public OrganisedCrimePanel(OrganisedCrimePlugin plugin, OrganisedCrimeConfig config) {
        this.plugin = plugin;
        this.config = config;
    }
}
