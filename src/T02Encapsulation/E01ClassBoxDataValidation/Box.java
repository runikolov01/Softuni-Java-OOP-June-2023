package T02Encapsulation.E01ClassBoxDataValidation;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        } else {
            this.length = length;
        }
    }

    private void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        } else {
            this.width = width;
        }
    }

    private void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        } else {
            this.height = height;
        }
    }

    //Surface Area = 2lw + 2lh + 2wh
    public double calculateSurfaceArea() {
        double result = (2 * this.length * this.width) + (2 * this.length * this.height) + (2 * this.width * this.height);
        return result;
    }

    //Lateral Surface Area = 2lh + 2wh
    public double calculateLateralSurfaceArea() {
        double result = (2 * this.length * this.height) + (2 * this.width * this.height);
        return result;
    }

    //Volume = lwh
    public double calculateVolume() {
        return this.length * this.width * this.height;
    }
}
