public class Vertices implements Comparable<Vertices>{
private int X;
private int Y;
private double distance;
private Vertices pred;
boolean visited;
int index;
public Vertices(int i, int X, int Y)
{
index = i;
visited = false;
this.X = X;
this.Y = Y;
pred = null;
distance = Double.POSITIVE_INFINITY;
}
public int getX() {
return X;
}
public int getY() {
return Y;
}
public double getDistance() {
return distance;
}
public void setDistance(double distance) {
this.distance = distance;
}
public double distanceBetween(Vertices other)
{
return Math.sqrt(Math.pow(other.getX()-X,2) + Math.pow(other.getY()-Y,2));
}
public Vertices getPred() {
return pred;
}
public void setPred(Vertices pred) {
this.pred = pred;
}
@Override
public int compareTo(Vertices o) {
if (distance <= o.getDistance())
return -1;
return 1;
}
}