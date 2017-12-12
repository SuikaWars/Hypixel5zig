package plugin.hypixel5zig.modules;

import eu.the5zig.mod.modules.GameModeItem;
import eu.the5zig.mod.server.GameMode;
import eu.the5zig.mod.server.GameState;
import plugin.hypixel5zig.games.Hypixel;

public class AssistsItem extends GameModeItem<Hypixel> {
	public AssistsItem() {
		super(Hypixel.class);
	}
	@Override
	protected Object getValue(boolean dummy) {
		if (dummy) {
			return "1";
		}else if(getGameMode().getAssists() == 0){
			return null;
		}
		return getGameMode().getAssists();
	}

	@Override
	public String getTranslation()
	{
		return "ingame.assists";
	}
}
