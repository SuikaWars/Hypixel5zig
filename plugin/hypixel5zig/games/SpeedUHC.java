package plugin.hypixel5zig.games;

import eu.the5zig.mod.server.GameMode;
import plugin.hypixel5zig.games.Hypixel;

public class SpeedUHC extends Hypixel {
	@Override
	public String getName() {
		return "Speed UHC";
	}
	private long winTime;
	public long getWinTime()
	{
		return this.winTime;
	}
	public void setWinTime(long winTime1)
	{
		winTime = winTime1;
	}
}
