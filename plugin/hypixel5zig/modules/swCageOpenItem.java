package plugin.hypixel5zig.modules;

import eu.the5zig.mod.modules.GameModeItem;
import plugin.hypixel5zig.Listener.HypixelListener;
import eu.the5zig.mod.server.GameMode;
import eu.the5zig.mod.server.GameState;
import eu.the5zig.mod.The5zigAPI;
import eu.the5zig.mod.modules.LargeTextItem;
import plugin.hypixel5zig.games.SkyWars;

public class swCageOpenItem extends LargeTextItem<SkyWars> {
	public swCageOpenItem() {
		super(SkyWars.class);
	}
	@Override
	protected String getText()
	{
		if(SkyWars.CageOpenTime != -1L){
			String Stringtime = shorten((SkyWars.CageOpenTime - System.currentTimeMillis()) / 1000.0D);
			if(!(Stringtime.contains("-"))){
				return The5zigAPI.getAPI().translate("ingame.cageopen_in", new Object[] { Stringtime });
			}
		}
		return null;
	}
}
