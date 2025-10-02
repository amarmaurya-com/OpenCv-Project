import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

public class WebcamDemo {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        VideoCapture cap = new VideoCapture(0);
        if(!cap.isOpened()){
            System.out.println("Video Capture Not Opened");
            return;
        }

        Mat frame = new Mat();
        Mat Edge = new Mat();
        while(true){
//            .read method will accept the data of current image and store/OverWright on the 'frame (Matrix)' var
            cap.read(frame);
            Imgproc.Canny(frame,Edge,150,70);
            if(frame.empty()){
                System.out.println("No frame captured!");
                break;
            }

//            HighGui.imshow("Video Capture", frame);
            HighGui.imshow("Edge Capture", Edge);

            if(HighGui.waitKey(30)==27)
                break;

        }
        cap.release();
        System.out.println("Video Capture Released");
    }
}
