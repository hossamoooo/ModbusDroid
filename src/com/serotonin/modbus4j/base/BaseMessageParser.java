/*
 * ============================================================================
 * GNU General Public License
 * ============================================================================
 *
 * Copyright (C) 2006-2011 Serotonin Software Technologies Inc. http://serotoninsoftware.com
 * @author Matthew Lohbihler
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.serotonin.modbus4j.base;

import com.serotonin.messaging.IncomingMessage;
import com.serotonin.messaging.MessageParser;
import com.serotonin.util.queue.ByteQueue;

abstract public class BaseMessageParser implements MessageParser {
    protected final boolean master;

    public BaseMessageParser(boolean master) {
        this.master = master;
    }

    //@Override
    public IncomingMessage parseMessage(ByteQueue queue) throws Exception {
        try {
            return parseMessageImpl(queue);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            // Means that we ran out of data trying to read the message. Just return null.
            return null;
        }
    }

    abstract protected IncomingMessage parseMessageImpl(ByteQueue queue) throws Exception;
}
