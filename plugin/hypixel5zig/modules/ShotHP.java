package plugin.hypixel5zig.modules;

import eu.the5zig.mod.modules.GameModeItem;
import plugin.hypixel5zig.Listener.HypixelListener;
import eu.the5zig.mod.modules.StringItem;
import eu.the5zig.mod.The5zigAPI;
import eu.the5zig.mod.modules.LargeTextItem;
import eu.the5zig.mod.server.GameMode;

public class ShotHP extends LargeTextItem<GameMode> {
	public ShotHP() {
		super(GameMode.class);
	}
	@Override
	protected String getText()
	{
		if(HypixelListener.ShotHP != null){
			String[] ShotHP = HypixelListener.ShotHP.split(",");
			return The5zigAPI.getAPI().translate("ingame.shothp", new Object[] { ShotHP[0],ShotHP[1] });
		}
		return null;
	}
}
