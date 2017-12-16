package ga.hypixel5zig.modules;

import eu.the5zig.mod.modules.GameModeItem;
import eu.the5zig.mod.server.GameMode;
import eu.the5zig.mod.server.GameState;
import ga.hypixel5zig.games.Hypixel;

public class CoinsItem extends GameModeItem<Hypixel> {
	public CoinsItem() {
		super(Hypixel.class);
	}
	@Override
	protected Object getValue(boolean dummy) {
		if (dummy) {
			return "815";
		}else if(getGameMode().getEarnedCoins() == 0){
			return null;
		}
		return getGameMode().getEarnedCoins();
	}

	@Override
	public String getTranslation()
	{
		return "ingame.coins";
	}
}
