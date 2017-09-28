package com.jaycee88.propertyanimationdemo;

import android.animation.TypeEvaluator;

/**
 * PointEvaluator
 * Created by jaycee on 2017/8/8.
 */
public class PointEvaluator implements TypeEvaluator<Point> {

    @Override
    public Point evaluate(float fraction, Point startValue, Point endValue) {
        float x = startValue.getX() + fraction * (endValue.getX() - startValue.getX());
        float y = startValue.getY() + fraction * (endValue.getY() - startValue.getY());
        return new Point(x, y);
    }
}
