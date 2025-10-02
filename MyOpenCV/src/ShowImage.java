
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.highgui.HighGui;

public class ShowImage {
    public static void main(String[] args) {

//        Lode OpenCV
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

//        Image Address
        String path = "./image.jpg";

//        Get image
        /**
         * Mat a class in OpenCV, used to store image video in matrix
         * Imgcodecs.imread  lode a media from path and store into the memory
         */
        Mat img = Imgcodecs.imread(path);

        if(img.empty()){
            System.out.println("Image not found");
            return;
        }
/**
 *      HighGui is a module in OpenCV,  Mostly use to display images || video
 */
        HighGui.imshow("Image",img);
        HighGui.waitKey(0);

        HighGui.destroyAllWindows();

    }
}
