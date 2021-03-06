package com.eu.habbo.habbohotel.items.interactions;

import com.eu.habbo.habbohotel.items.Item;
import com.eu.habbo.habbohotel.rooms.Room;
import gnu.trove.map.hash.THashMap;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InteractionInformationTerminal extends InteractionCustomValues
{
    public static final THashMap<String, String> defaultValues = new THashMap<String, String>()
    {
        {
            this.put("internalLink", "http://arcturus.pw");}
    };

    public InteractionInformationTerminal(ResultSet set, Item baseItem) throws SQLException
    {
        super(set, baseItem, defaultValues);
    }

    public InteractionInformationTerminal(int id, int userId, Item item, String extradata, int limitedStack, int limitedSells)
    {
        super(id, userId, item, extradata, limitedStack, limitedSells, defaultValues);
    }

    @Override
    public void onPickUp(Room room)
    {
        this.values.clear();
    }
}
