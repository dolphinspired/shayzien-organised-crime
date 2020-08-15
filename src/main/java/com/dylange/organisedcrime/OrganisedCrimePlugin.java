package com.dylange.organisedcrime;

import com.dylange.organisedcrime.config.OrganisedCrimeConfig;
import com.dylange.organisedcrime.models.GangInfo;
import com.dylange.organisedcrime.tools.InformationBoardTextReader;
import com.google.inject.Provides;
import javax.inject.Inject;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;

import java.awt.image.BufferedImage;

import static com.dylange.organisedcrime.tools.WidgetConstants.GROUP_ID_INFORMATION_BOARD;
import static com.dylange.organisedcrime.tools.WidgetConstants.GROUP_ID_NO_INFORMATION_ATM;

@Slf4j
@PluginDescriptor(
	name = "Organised crime",
	description = "Keeps track of organised crime locations across worlds",
	enabledByDefault = true // TODO: set this to false when finished developing
)
public class OrganisedCrimePlugin extends Plugin
{

	private NavigationButton navButton;
	private OrganisedCrimePanel panel;

	@Inject
	private Client client;

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private OrganisedCrimeConfig config;

	@Provides
	OrganisedCrimeConfig provideOrganisedCrimeConfig(ConfigManager configManager)
	{
		return configManager.getConfig(OrganisedCrimeConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
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
	protected void shutDown() throws Exception
	{
		log.info("Example stopped!");
		clientToolbar.removeNavigation(navButton);
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded widgetLoaded) {
		log.error("Interface shown with group ID: " + widgetLoaded.getGroupId());
		if (widgetLoaded.getGroupId() != GROUP_ID_INFORMATION_BOARD) return;
		if (widgetLoaded.getGroupId() == GROUP_ID_NO_INFORMATION_ATM) {
			// TODO: handle clearing current world's data.
			return;
		}

		final GangInfo gangInfo = InformationBoardTextReader.getDisplayedGangInfo(client);
		if (gangInfo != null) {
			log.error("Location text: " + gangInfo.getLocation());
			log.error("Time text: " + gangInfo.getTimeText());
			log.error("World: " + gangInfo.getWorld());
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
//			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Example says " + config.greeting(), null);
		}
	}

}
