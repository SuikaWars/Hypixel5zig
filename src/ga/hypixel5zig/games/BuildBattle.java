package ga.hypixel5zig.games;

import eu.the5zig.mod.server.GameMode;
import ga.hypixel5zig.games.Hypixel;

public class BuildBattle extends Hypixel {
	@Override
	public String getName() {
		return "Build Battle";
	}
	private String Theme;
	public String getTheme()
	{
		return Theme;
	}
	public void setTheme(String theme)
	{
		Theme = theme;
	}
}
