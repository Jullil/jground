package org.jground.entity;

import javax.persistence.*;

@Entity
@Table(name="map_object")
public class MapObject implements MyEntity {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    private int x;
    private int y;
    private MapObjectType type;

    public MapObject() {}

    public MapObject(int x, int y, User user, MapObjectType type) {
        this.x = x;
        this.y = y;
        this.user = user;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public MapObjectType getType() {
        return type;
    }

    public void setType(MapObjectType type) {
        this.type = type;
    }
}
