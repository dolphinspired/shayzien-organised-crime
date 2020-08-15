package com.dylange.organisedcrime;

import com.dylange.organisedcrime.config.OrganisedCrimeConfig;
import com.dylange.organisedcrime.models.GangInfo;
import com.dylange.organisedcrime.tools.InformationBoardTextReader;
import com.dylange.organisedcrime.ui.OrganisedCrimePanel;
import com.google.inject.Provides;

import javax.inject.Inject;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import static com.dylange.organisedcrime.tools.WidgetConstants.GROUP_ID_INFORMATION_BOARD;
import static com.dylange.organisedcrime.tools.WidgetConstants.GROUP_ID_NO_INFORMATION_ATM;

@Slf4j
@PluginDescriptor(
        name = "Organised crime",
        description = "Keeps track of organised crime locations across worlds",
        enabledByDefault = true // TODO: set this to false when finished developing
)
public class OrganisedCrimePlugin extends Plugin {
    private static final int PANEL_REFRESH_TICK_THRESHOLD = 100; // 100 ticks, 1 minute.

    private NavigationButton navButton;
    private OrganisedCrimePanel panel;
    private int ticksSinceLastUiUpdate = 0;

    @Inject
    private Client client;

    @Inject
    private ClientToolbar clientToolbar;

    @Inject
    private OrganisedCrimeConfig config;

    public Map<Integer, GangInfo> gangInfoMap = new HashMap<>();

    @Provides
    OrganisedCrimeConfig provideOrganisedCrimeConfig(ConfigManager configManager) {
        return configManager.getConfig(OrganisedCrimeConfig.class);
    }

    @Override
    protected void startUp() throws Exception {
        panel = new OrganisedCrimePanel(this, config);

        final BufferedImage icon = ImageUtil.getResourceStreamFromClass(getClass(), "icon.png");

        navButton = NavigationButton.builder()
                .tooltip("Organised Crime")
                .icon(icon)
                .priority(5)
                .panel(panel)
                .build();
        clientToolbar.addNavigation(navButton);
    }

    @Override
    protected void shutDown() throws Exception {
        gangInfoMap.clear();
        clientToolbar.removeNavigation(navButton);
    }

    @Subscribe
    public void onGameTick(GameTick gameTick) {
        if (++ticksSinceLastUiUpdate >= PANEL_REFRESH_TICK_THRESHOLD) refreshPanel();
    }

    @Subscribe
    public void onWidgetLoaded(WidgetLoaded widgetLoaded) {
        if (widgetLoaded.getGroupId() != GROUP_ID_INFORMATION_BOARD) return;
        if (widgetLoaded.getGroupId() == GROUP_ID_NO_INFORMATION_ATM) {
            gangInfoMap.remove(client.getWorld());
            return;
        }

        final GangInfo gangInfo = InformationBoardTextReader.getDisplayedGangInfo(client);
        if (gangInfo != null) {
            log.error("Location text: " + gangInfo.getLocationMessage());
            log.error("Time text: " + gangInfo.getTimeMessage());
            log.error("World: " + gangInfo.getWorld());
            gangInfoMap.put(gangInfo.getWorld(), gangInfo);
            refreshPanel();
        }
    }

    private void refreshPanel() {
        ticksSinceLastUiUpdate = 0;
        panel.invalidate();
    }
}
