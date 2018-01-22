package ga.hypixel5zig.modules;

import eu.the5zig.mod.modules.GameModeItem;
import eu.the5zig.mod.server.GameMode;
import eu.the5zig.mod.server.GameState;
import ga.hypixel5zig.games.Hypixel;

public class KillStreakItem extends GameModeItem<Hypixel> {
	public KillStreakItem() {
		super(Hypixel.class);
	}
	@Override
	protected Object getValue(boolean dummy) {
		if (dummy) {
			return "12";
		}else if(getGameMode().getKillstreak() == 0){
			return null;
		}
		return getGameMode().getKillstreak();
	}

	@Override
	public String getTranslation()
	{
		return "ingame.killstreak";
	}
}
