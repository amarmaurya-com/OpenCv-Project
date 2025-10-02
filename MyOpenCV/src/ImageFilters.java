import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.highgui.HighGui;

public class ImageFilters {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        // 1. Load an image
        String imagePath = "C:\\Users\\kiran\\Desktop\\MyOpenCV\\sample.jpg";
        Mat img = Imgcodecs.imread(imagePath);

        if (img.empty()) {
            System.out.println("Image not found!");
            return;
        }

        // 2. Convert to Grayscale
        Mat gray = new Mat();
        Imgproc.cvtColor(img, gray, Imgproc.COLOR_BGR2GRAY);

        // 3. Apply Gaussian Blur
        Mat blur = new Mat();
        Imgproc.GaussianBlur(img, blur, new org.opencv.core.Size(15, 15), 0);

        // 4. Edge Detection (Canny)
        Mat edges = new Mat();
        Imgproc.Canny(img, edges, 100, 200);

        // 5. Show results
        HighGui.imshow("Original", img);
        HighGui.imshow("Grayscale", gray);
        HighGui.imshow("Blurred", blur);
        HighGui.imshow("Edges", edges);

        HighGui.waitKey();
    }
}
