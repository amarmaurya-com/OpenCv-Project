import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.highgui.HighGui;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;

public class FaceDetection {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        // Load the classifier (make sure the path is correct)
        CascadeClassifier faceCascade = new CascadeClassifier("src/resources/haarcascade_frontalface_default.xml");


        VideoCapture cap = new VideoCapture(0);
        if (!cap.isOpened()) {
            System.out.println("Video Capture Not Opened");
            return;
        }

        Mat frame = new Mat();

        while (true) {
            cap.read(frame);
            if (frame.empty()) {
                System.out.println("No frame captured!");
                break;
            }

            // Detect faces
            MatOfRect faces = new MatOfRect();
            faceCascade.detectMultiScale(frame, faces, 1.1, 4, 0, new Size(30, 30), new Size());

            // Draw rectangles around detected faces
            for (Rect rect : faces.toArray()) {
                Imgproc.rectangle(frame, rect, new Scalar(0, 255, 0), 2);
            }

            HighGui.imshow("Face Detection", frame);

            if (HighGui.waitKey(30) == 27) break;  // ESC to exit
        }

        cap.release();
        System.out.println("Video Capture Released");
    }
}

