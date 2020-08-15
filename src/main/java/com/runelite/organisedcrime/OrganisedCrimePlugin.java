package com.runelite.organisedcrime;

import com.google.inject.Provides;
import javax.inject.Inject;

import com.runelite.organisedcrime.config.*;
import com.runelite.organisedcrime.models.GangInfo;
import com.runelite.organisedcrime.tools.InformationBoardTextReader;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import static com.runelite.organisedcrime.tools.WidgetConstants.GROUP_ID_INFORMATION_BOARD;
import static com.runelite.organisedcrime.tools.WidgetConstants.GROUP_ID_NO_INFORMATION_ATM;

@Slf4j
@PluginDescriptor(
	name = "Organised crime"
)
public class OrganisedCrimePlugin extends Plugin
{
	private static final int INDEX_START_INFO_BOARD_TEXT = 1;
	private static final int INDEX_END_INFO_BOARD_TEXT = 11;
	private static final String START_TIME_TEXT = "The meeting is expected to";

	@Inject
	private Client client;

	@Inject
	private OrganisedCrimeConfig organisedCrimeConfig;

	@Provides
	OrganisedCrimeConfig provideOrganisedCrimeConfig(ConfigManager configManager)
	{
		return configManager.getConfig(OrganisedCrimeConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		log.info("Example started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("Example stopped!");
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
