package ga.hypixel5zig.modules;

import eu.the5zig.mod.modules.GameModeItem;
import eu.the5zig.mod.server.GameMode;
import eu.the5zig.mod.server.GameState;
import ga.hypixel5zig.games.Hypixel;

public class WinStreakItem extends GameModeItem<Hypixel> {
	public WinStreakItem() {
		super(Hypixel.class);
	}
	@Override
	protected Object getValue(boolean dummy) {
		if (dummy) {
			return "2";
		}else if(getGameMode().getWinStreak() == 0){
			return null;
		}
		return getGameMode().getWinStreak();
	}

	@Override
	public String getTranslation()
	{
		return "ingame.winstreak";
	}
}
