/*package ga.hypixel5zig.modules;

import eu.the5zig.mod.modules.GameModeItem;
import eu.the5zig.mod.server.GameMode;
import eu.the5zig.mod.server.GameState;
import ga.hypixel5zig.games.BuildBattle;

public class BuildBattleTheme extends GameModeItem<BuildBattle> {
	public BuildBattleTheme() {
		super(BuildBattle.class);
	}	
	@Override
	public void registerSettings() {
		getProperties().addSetting("language", true);
	}
	@Override
	protected Object getValue(boolean dummy) {
		if (((Boolean)getProperties().getSetting("language").get()).booleanValue()) {
			if (dummy) {
			return "Snowman";
			}
			return getGameMode().getTheme();
		}
		if (dummy) {
			return "Snowman";
		}
		return getGameMode().getTheme()
	}

	@Override
	public String getTranslation()
	{
		return "ingame.theme";
	}
}
*/