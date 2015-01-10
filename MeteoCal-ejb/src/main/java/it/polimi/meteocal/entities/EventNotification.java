/*
 * Copyright (C) 2014 Matteo Gazzetta, Alessandro Fato
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
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package it.polimi.meteocal.entities;

import it.polimi.meteocal.util.Status;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Matteo Gazzetta, Alessandro Fato
 */
@Entity
@NamedQueries({
    @NamedQuery(name = EventNotification.FIND_BY_EVENT, query = "SELECT n FROM EventNotification n WHERE n.event = :event"),
    @NamedQuery(name = EventNotification.FIND_BY_EVENT_AND_USER, query = "SELECT n FROM EventNotification n WHERE n.event = :event AND n.user = :user"),
    @NamedQuery(name = EventNotification.FIND_OLD_NOTIFICATION, query = "SELECT n FROM EventNotification n WHERE n.event.startDate <= :now"),})
public class EventNotification extends Notification {

    public static final String FIND_BY_EVENT = "EventNotification.FIND_BY_EVENT";
    public static final String FIND_BY_EVENT_AND_USER = "EventNotification.FIND_BY_EVENT_AND_USER";
    public static final String FIND_OLD_NOTIFICATION = "EventNotification.FIND_OLD_NOTIFICATION";

    @OneToOne
    @NotNull
    private Event event;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

}
