package net.cybercake.cyberapi.spigot.server.serverlist.managers;

import net.cybercake.cyberapi.spigot.CyberAPI;
import net.cybercake.cyberapi.spigot.server.serverlist.ServerListInfo;
import org.bukkit.Bukkit;

public class ProtocolManager {

    /**
     * Creates an instance of Protocol manager
     * @deprecated Please use {@link ServerListInfo#getProtocolManager()} instead!
     */
    @Deprecated
    @SuppressWarnings({"all"})
    public ProtocolManager() {
        resetVersionName();
        resetProtocolNumber();
        this.alwaysShowVersion = false;
    }

    private static ProtocolManager protocolManager = null;
    public static ProtocolManager protocolManager() {
        if(ProtocolManager.protocolManager == null) ProtocolManager.protocolManager = new ProtocolManager();
        return ProtocolManager.protocolManager;
    }

    private boolean alwaysShowVersion;
    private String versionName;
    private int protocol;

    /**
     * Sets the name of the version to show when the client is outdated or {@link ProtocolManager#setAlwaysShowVersion(boolean)} is true
     * @param versionName the name to set the version to
     * @since 3.1.0
     */
    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    /**
     * Gets the name of the version that is shown when the client is outdated or {@link ProtocolManager#setAlwaysShowVersion(boolean)} is true
     * @return the {@link String} version name
     * @since 3.1.0
     */
    public String getVersionName() {
        return this.versionName;
    }

    /**
     * Resets the version name back to what it should be ({@link Bukkit#getName()} and {@link CyberAPI#getMinecraftVersion()} - 'Purpur 1.19')
     * @since 3.1.0
     */
    public void resetVersionName() {
        this.versionName = Bukkit.getName() + " " + CyberAPI.getInstance().getMinecraftVersion();
    }

    /**
     * Sets the protocol to a specified number, you can see all version protocols here: <a href="https://wiki.vg/Protocol_version_numbers">https://wiki.vg/Protocol_version_numbers</a>
     * @param protocol what to set the fake protocol number to
     * @since 3.1.0
     */
    public void setProtocolNumber(int protocol) {
        this.protocol = protocol;
    }

    /**
     * Gets the protocol, either set by the server or a custom protocol number, you can see all version protocols here: <a href="https://wiki.vg/Protocol_version_numbers">https://wiki.vg/Protocol_version_numbers</a>
     * @return the custom or server protocol number
     * @since 3.1.0
     */
    public int getProtocolNumber() {
        return this.protocol;
    }

    /**
     * Resets the protocol number to its default value (aka what the server's protocol version number is)
     * @since 3.1.0
     */
    public void resetProtocolNumber() { this.protocol = Integer.MIN_VALUE; }

    /**
     * Sets whether the server should always show an outdated client, which would mean the version name is constantly shown
     * @param alwaysShowVersion whether to always display outdated client
     * @since 3.1.0
     */
    public void setAlwaysShowVersion(boolean alwaysShowVersion) {
        this.alwaysShowVersion = alwaysShowVersion;
    }

    /**
     * Should the server always show the version from {@link ProtocolManager#setVersionName(String)}
     * @return whether the server should always show the version
     * @since 3.1.0
     */
    public boolean shouldAlwaysShowVersion() {
        return this.alwaysShowVersion;
    }

}
