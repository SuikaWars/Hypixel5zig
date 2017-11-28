package plugin.hypixel5zig.modules;

import eu.the5zig.mod.modules.GameModeItem;
import plugin.hypixel5zig.Listener.HypixelListener;
import eu.the5zig.mod.modules.StringItem;

public class ServerItem extends StringItem {
	public ServerItem() {
		super();
	}
	@Override
	protected Object getValue(boolean dummy) {
		if (dummy) {
			return "swlobby1";
		}
		return HypixelListener.Server;
	}

	@Override
	public String getTranslation()
	{
		return "ingame.server";
	}
}
