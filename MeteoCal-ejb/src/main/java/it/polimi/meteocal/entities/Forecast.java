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

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 * Entity that rappresent the Forecast of the Event in MeteoCal
 *
 * @author Matteo Gazzetta, Alessandro Fato
 */
@Table(name = "forecast", indexes = {
        @Index(columnList = "LOCATION")})
@Entity
@NamedQueries({
        @NamedQuery(name = Forecast.FIND_BY_LOCATION, query = "SELECT f FROM Forecast f WHERE f.location LIKE :location"),
        @NamedQuery(name = Forecast.FIND_OLD_FORECAST, query = "SELECT f FROM Forecast f WHERE f.creationDate < :today"),})
public class Forecast implements Serializable {

    /**
     * Name for the NamedQuery
     */
    public static final String FIND_BY_LOCATION = "Forecast.FIND_BY_LOCATION";

    /**
     * Name for the NamedQuery
     */
    public static final String FIND_OLD_FORECAST = "Forecast.FIND_OLD_FORECAST";

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;

    private Float latitude;

    private Float longitude;

    @Basic
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private java.util.Calendar forecastDate;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private java.util.Calendar creationDate;

    @OneToOne(cascade = CascadeType.ALL)
    private Weather weather;

    /**
     * @return the location of the forcast
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the latitude of the forecast
     */
    public Float getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitute to set
     */
    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the longitude of the forecast
     */
    public Float getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the forecast date of the forecast
     */
    public java.util.Calendar getForecastDate() {
        return forecastDate;
    }

    /**
     * @param forecastDate the date of the forecast to ser
     */
    public void setForecastDate(java.util.Calendar forecastDate) {
        this.forecastDate = forecastDate;
    }

    /**
     * @return the creation date of the forecast
     */
    public java.util.Calendar getCreationDate() {
        return creationDate;
    }

    /**
     * @param creationDate the creation date to set
     */
    public void setCreationDate(java.util.Calendar creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @return the weather of the forecast
     */
    public Weather getWeather() {
        return weather;
    }

    /**
     * @param weather the weather to set
     */
    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    /**
     * @return the id of the forecast
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Forecast)) return false;
        Forecast forecast = (Forecast) o;
        return Objects.equals(id, forecast.id) &&
                Objects.equals(location, forecast.location) &&
                Objects.equals(latitude, forecast.latitude) &&
                Objects.equals(longitude, forecast.longitude) &&
                Objects.equals(forecastDate, forecast.forecastDate) &&
                Objects.equals(creationDate, forecast.creationDate) &&
                Objects.equals(weather, forecast.weather);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, location, latitude, longitude, forecastDate, creationDate, weather);
    }

    @Override
    public String toString() {
        return "Forecast{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", forecastDate=" + forecastDate +
                ", creationDate=" + creationDate +
                ", weather=" + weather +
                '}';
    }

}
