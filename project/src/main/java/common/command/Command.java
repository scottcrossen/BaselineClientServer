package common.command;

import java.io.Serializable;

public class Command implements Serializable {
    public CommandTypes type = CommandTypes.NONE;
}
