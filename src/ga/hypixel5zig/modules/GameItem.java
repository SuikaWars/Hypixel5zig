package ga.hypixel5zig.modules;

import eu.the5zig.mod.modules.GameModeItem;
import eu.the5zig.mod.modules.StringItem;
import ga.hypixel5zig.Listener.HypixelListener;

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
