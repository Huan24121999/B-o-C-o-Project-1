public class PicturePoint {
    private float x;
    private float y;
    private float z;

    public PicturePoint(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public PicturePoint() {
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "("+this.getX()+", "+this.getY()+", "+this.getZ()+")";
    }
}
