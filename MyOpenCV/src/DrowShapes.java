import org.opencv.core.*;
import org.opencv.highgui.HighGui;
import org.opencv.imgproc.Imgproc;

public class DrowShapes {
    public static void main(String[] args) {

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//        Creating a background on which shapes wear create
        Mat mat = new Mat(new Size(500,500),org.opencv.core.CvType.CV_8UC3,new Scalar(255,255,255));

//        Create's Line ->  Imgproc.line(Background, Starting Coordinates, Ending Coordinates, Color,thickness)
        Imgproc.line(mat, new Point(50,50),new Point(450,50),new Scalar(25,0,0),3);

        Imgproc.rectangle(mat,new Point(100,100),new Point(400,300),new Scalar(0,255,0),3);

        Imgproc.circle(mat,new Point(450,450),60,new Scalar(0,0,255),2);
        HighGui.imshow("Mat",mat);
        HighGui.waitKey();





    }
}
