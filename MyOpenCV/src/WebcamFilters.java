import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

import java.util.Scanner;

public class WebcamFilters {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        VideoCapture cap = new VideoCapture(0);
        if (!cap.isOpened()) {
            System.out.println("Video Capture Not Opened");
            return;
        }

        Scanner sc = new Scanner(System.in);
        Mat frame = new Mat();
        Mat processed = new Mat();
        char mode = sc.next().charAt(0);  // default → original


        while (true) {
            cap.read(frame);
            if (frame.empty()) {
                System.out.println("No frame captured!");
                break;
            }

            // Switch filter based on key pressed
            switch (mode) {
                case 'g': // grayscale
                    Imgproc.cvtColor(frame, processed, Imgproc.COLOR_BGR2GRAY);
                    HighGui.imshow("Webcam Filters", processed);
                    break;

                case 'b': // blur
                    Imgproc.GaussianBlur(frame, processed, new org.opencv.core.Size(15, 15), 0);
                    HighGui.imshow("Webcam Filters", processed);
                    break;

                case 'e': // edge
                    Imgproc.Canny(frame, processed, 100, 200);
                    HighGui.imshow("Webcam Filters", processed);
                    break;

                default: // original
                    HighGui.imshow("Webcam Filters", frame);
            }

            int key = HighGui.waitKey(30);
            if (key == 27) break;   // ESC → exit
            if (key > 0) mode = (char) key;  // change mode
        }

        cap.release();
        System.out.println("Video Capture Released");
    }
}
