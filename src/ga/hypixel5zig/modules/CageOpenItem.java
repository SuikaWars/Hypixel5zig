package ga.hypixel5zig.modules;

import eu.the5zig.mod.modules.GameModeItem;
import plugin.hypixel5zig.Listener.HypixelListener;
import eu.the5zig.mod.server.GameMode;
import eu.the5zig.mod.server.GameState;
import eu.the5zig.mod.The5zigAPI;
import eu.the5zig.mod.modules.LargeTextItem;
import ga.hypixel5zig.games.Hypixel;

public class CageOpenItem extends LargeTextItem<Hypixel> {
	public CageOpenItem() {
		super(Hypixel.class);
	}
	@Override
	protected String getText()
	{
		if(getGameMode().getCageOpenTime() != -1L){
			String Stringtime = shorten((getGameMode().getCageOpenTime() - System.currentTimeMillis()) / 1000.0D);
			if(!(Stringtime.contains("-"))){
				return The5zigAPI.getAPI().translate("ingame.cageopen_in", new Object[] { Stringtime });
			}
		}
		return null;
	}
}
