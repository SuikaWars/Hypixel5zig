package plugin.hypixel5zig.modules;

import eu.the5zig.mod.modules.GameModeItem;
import plugin.hypixel5zig.Listener.HypixelListener;
import eu.the5zig.mod.server.GameMode;
import eu.the5zig.mod.server.GameState;
import plugin.hypixel5zig.games.SkyWars;

public class swKitItem extends GameModeItem<SkyWars> {
	public swKitItem() {
		super(SkyWars.class);
	}
	@Override
	protected Object getValue(boolean dummy) {
		if (dummy) {
			return "Default";
		}
		return SkyWars.Kit;
	}

	@Override
	public String getTranslation()
	{
		return "ingame.swkit";
	}
}
