package ga.hypixel5zig.modules;

import eu.the5zig.mod.modules.GameModeItem;
import eu.the5zig.mod.server.GameMode;
import eu.the5zig.mod.server.GameState;
import ga.hypixel5zig.games.Hypixel;

public class TeamItem extends GameModeItem<Hypixel> {
	public TeamItem() {
		super(Hypixel.class);
	}
	@Override
	protected Object getValue(boolean dummy) {
		if (dummy) {
			return "\u00A7aGreen";
		}
		return getGameMode().getTeam();
	}

	@Override
	public String getTranslation()
	{
		return "ingame.team";
	}
}
