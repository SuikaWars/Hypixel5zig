package ga.hypixel5zig.games;

import eu.the5zig.mod.server.GameMode;

public abstract class Hypixel extends GameMode {
	private String Kit;
	private long CageOpenTime;
	private int Assists;
	private int EarnedCoins;
	private long winTime;
	private String Team;
	public void setKit(String Kit1)
	{
		Kit = Kit1;
	}
	public String getKit()
	{
		return Kit;
	}
	public void setCageOpenTime(long CageOpenTime1)
	{
		CageOpenTime = CageOpenTime1;
	}
	public long getCageOpenTime()
	{
		return CageOpenTime;
	}
	public void setAssists(int Assists1)
	{
		Assists = Assists1;
	}
	public int getAssists()
	{
		return Assists;
	}
	public void setEarnedCoins(int coins)
	{
		EarnedCoins = coins;
	}
	public int getEarnedCoins()
	{
		return EarnedCoins;
	}
	public long getWinTime()
	{
		return this.winTime;
	}
	public void setWinTime(long winTime1)
	{
		winTime = winTime1;
	}
	public void setTeam(String team)
	{
		Team = team;
	}
	public String getTeam()
	{
		return Team;
	}
}
