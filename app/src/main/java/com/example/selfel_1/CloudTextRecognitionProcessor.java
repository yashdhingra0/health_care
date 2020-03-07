package com.example.selfel_1;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.Task;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.cloud.text.FirebaseVisionCloudText;
import com.google.firebase.ml.vision.cloud.text.FirebaseVisionCloudTextDetector;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;

/** Processor for the cloud text detector demo. */
public class CloudTextRecognitionProcessor extends VisionProcessorBase<FirebaseVisionCloudText> {

    private static final String TAG = "CloudTextRecognitionProcessor";

    private final FirebaseVisionCloudTextDetector detector;

    public CloudTextRecognitionProcessor() {
        super();
        detector = FirebaseVision.getInstance().getVisionCloudTextDetector();
    }

    @Override
    protected Task<FirebaseVisionCloudText> detectInImage(FirebaseVisionImage image) {
        return detector.detectInImage(image);
    }

    @Override
    protected void onSuccess(
            @NonNull FirebaseVisionCloudText text,
            @NonNull FrameMetadata frameMetadata,
            @NonNull GraphicOverlay graphicOverlay) {
        graphicOverlay.clear();
        Log.d("TAG", "detected text is: " + text.getText());
        CloudTextGraphic textGraphic = new CloudTextGraphic(graphicOverlay, text);
        graphicOverlay.add(textGraphic);
    }

    @Override
    protected void onFailure(@NonNull Exception e) {
        Log.w("TAG", "Cloud Text detection failed." + e);
    }
}
