package plugin.hypixel5zig.modules;

import eu.the5zig.mod.modules.GameModeItem;
import plugin.hypixel5zig.Listener.HypixelListener;
import eu.the5zig.mod.modules.StringItem;

public class GameItem extends StringItem {
	public GameItem() {
		super();
	}
	@Override
	protected Object getValue(boolean dummy) {
		if (dummy) {
			return "SpeedUHC";
		}
		return HypixelListener.Game;
	}

	@Override
	public String getTranslation()
	{
		return "ingame.game";
	}
}
