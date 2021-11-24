package com.example.my_framework;

public class CollisionDetect {

    static double object1x;
    static double object1y;

    static double object2x;
    static double object2y;

    static double radiusObject1;
    static double radiusObject2;

    static double dx;
    static double dy;

    static double distanceObjects;

    public static boolean collisionDetect(ObjectFW object1, ObjectFW object2){

        object1x = object1.getHitBox().centerX();
        object1y = object1.getHitBox().centerY();

        object2x = object2.getHitBox().centerX();
        object2y = object2.getHitBox().centerY();

        radiusObject1 = object1.getRadius();
        radiusObject2 = object2.getRadius();

        dx = object1x-object2x;
        dy = object1y - object2y;

        distanceObjects = Math.sqrt(dx*dx+dy*dy);

        if(distanceObjects<(radiusObject1+radiusObject2)){

            return true;

        }

        return false;

    }
}
