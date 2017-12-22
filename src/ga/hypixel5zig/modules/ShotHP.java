package ga.hypixel5zig.modules;

import eu.the5zig.mod.modules.GameModeItem;
import eu.the5zig.mod.modules.StringItem;
import eu.the5zig.mod.The5zigAPI;
import eu.the5zig.mod.modules.LargeTextItem;
import eu.the5zig.mod.server.GameMode;
import ga.hypixel5zig.games.Hypixel;

public class ShotHP extends LargeTextItem<Hypixel> {
	public ShotHP() {
		super(Hypixel.class);
	}
	@Override
	protected String getText()
	{
		if(getGameMode().getShotHP() != null){
			return getGameMode().getShotHP();
		}
		return null;
	}
}
