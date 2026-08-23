package xyz.xenondevs.invui;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

/**
 * Contains information about a click on an item by a player.
 *
 * @param player       The player who clicked.
 * @param clickType    The type of click.
 * @param hotbarButton The hotbar key that was pressed (in [0; 8]),
 *                     or -1 if {@link #clickType()} is not {@link ClickType#NUMBER_KEY}.
 * @param fromDrag     Whether this is a quick-craft drag that covered exactly one slot, reported
 *                     as a click because that is what the vanilla container does with one - see
 *                     {@code AbstractContainerMenu#doClick}, which re-dispatches such a drag as a
 *                     pickup. The two are otherwise indistinguishable: the drag arrives as
 *                     {@link ClickType#LEFT}, {@link ClickType#RIGHT} or {@link ClickType#MIDDLE}
 *                     with no hotbar button, exactly like a real click of the same button. A
 *                     handler that acts on a click - a menu button, say - wants to know, because
 *                     dragging a carried stack across it is a gesture aimed at the slot rather than
 *                     at the button.
 */
public record Click(
    Player player,
    ClickType clickType,
    int hotbarButton,
    boolean fromDrag
)
{
    
    /**
     * Creates a new {@link Click} with the given player, click type and hotbar button.
     *
     * @param player       The player who clicked.
     * @param clickType    The type of click.
     * @param hotbarButton The hotbar key that was pressed (in [0; 8]), or -1 for none.
     */
    public Click(Player player, ClickType clickType, int hotbarButton) {
        this(player, clickType, hotbarButton, false);
    }
    
    /**
     * Creates a new {@link Click} with the given player and click type.
     *
     * @param player    The player who clicked.
     * @param clickType The type of click.
     */
    public Click(Player player, ClickType clickType) {
        this(player, clickType, -1, false);
    }
    
}