package com.vergilprime.chminimessage;

import com.laytonsmith.PureUtilities.SimpleVersion;
import com.laytonsmith.PureUtilities.Version;
import com.laytonsmith.core.Static;
import com.laytonsmith.core.extensions.AbstractExtension;
import com.laytonsmith.core.extensions.MSExtension;
import net.kyori.adventure.text.minimessage.MiniMessage;

@MSExtension("CHMiniMessage")
public class CHMiniMessage extends AbstractExtension {
	public static MiniMessage miniMessage = MiniMessage.miniMessage();

	@Override
	public Version getVersion() {
		return new SimpleVersion(0,0,1); // Set your version here.
	}

	@Override
	public void onStartup(){
		Static.getLogger().info("CHMiniMessage " + getVersion() + " loaded.");
	}

	@Override
	public void onShutdown(){
		Static.getLogger().info("CHMiniMessage " + getVersion() + " unloaded.");
	}
}