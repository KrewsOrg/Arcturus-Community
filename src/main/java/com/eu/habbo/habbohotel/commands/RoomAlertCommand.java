package com.eu.habbo.habbohotel.commands;

import com.eu.habbo.Emulator;
import com.eu.habbo.habbohotel.gameclients.GameClient;
import com.eu.habbo.habbohotel.rooms.Room;
import com.eu.habbo.habbohotel.rooms.RoomChatMessageBubbles;
import com.eu.habbo.messages.outgoing.modtool.ModToolIssueHandledComposer;

public class RoomAlertCommand extends Command
{
    public RoomAlertCommand()
    {
        super("cmd_roomalert", Emulator.getTexts().getValue("commands.keys.cmd_roomalert").split(";"));
    }

    @Override
    public boolean handle(GameClient gameClient, String[] params) throws Exception
    {
        String message = "";

        if (params.length >= 2)
        {
            for (int i = 1; i < params.length; i++)
            {
                message += params[i] + " ";
            }

            if (message.isEmpty())
            {
                gameClient.getHabbo().whisper(Emulator.getTexts().getValue("commands.error.cmd_roomalert.empty"), RoomChatMessageBubbles.ALERT);
                return true;
            }

            Room room = gameClient.getHabbo().getHabboInfo().getCurrentRoom();

            if (room != null)
            {
                room.sendComposer(new ModToolIssueHandledComposer(message).compose());
                return true;
            }
        }

        return false;
    }
}