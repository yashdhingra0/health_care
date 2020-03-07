package com.example.selfel_1;

import android.content.Context;
import android.graphics.Canvas;
import android.hardware.camera2.CameraCharacteristics;
import android.util.AttributeSet;
import android.view.View;

import com.google.android.gms.vision.CameraSource;

import java.util.HashSet;
import java.util.Set;


public class GraphicOverlay extends View {
    private final Object lock = new Object();
    private int previewWidth;
    private float widthScaleFactor = 1.0f;
    private int previewHeight;
    private float heightScaleFactor = 1.0f;
    private int facing = CameraSource.CAMERA_FACING_BACK;
    private Set<Graphic> graphics = new HashSet<>();



    public abstract static class Graphic {
        private GraphicOverlay overlay;

        public Graphic(GraphicOverlay overlay) {
            this.overlay = overlay;
        }


        public abstract void draw(Canvas canvas);


        public float scaleX(float horizontal) {
            return horizontal * overlay.widthScaleFactor;
        }

        public float scaleY(float vertical) {
            return vertical * overlay.heightScaleFactor;
        }

        public Context getApplicationContext() {
            return overlay.getContext().getApplicationContext();
        }

          public float translateX(float x) {
            if (overlay.facing == CameraSource.CAMERA_FACING_FRONT) {
                return overlay.getWidth() - scaleX(x);
            } else {
                return scaleX(x);
            }
        }

       public float translateY(float y) {
            return scaleY(y);
        }

        public void postInvalidate() {
            overlay.postInvalidate();
        }
    }

    public GraphicOverlay(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void clear() {
        synchronized (lock) {
            graphics.clear();
        }
        postInvalidate();
    }

   public void add(Graphic graphic) {
        synchronized (lock) {
            graphics.add(graphic);
        }
        postInvalidate();
    }

    /** Removes a graphic from the overlay. */
    public void remove(Graphic graphic) {
        synchronized (lock) {
            graphics.remove(graphic);
        }
        postInvalidate();
    }

    /**
     * Sets the camera attributes for size and facing direction, which informs how to transform image
     * coordinates later.
     */
    public void setCameraInfo(int previewWidth, int previewHeight, int facing) {
        synchronized (lock) {
            this.previewWidth = previewWidth;
            this.previewHeight = previewHeight;
            this.facing = facing;
        }
        postInvalidate();
    }

    /** Draws the overlay with its associated graphic objects. */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        synchronized (lock) {
            if ((previewWidth != 0) && (previewHeight != 0)) {
                widthScaleFactor = (float) canvas.getWidth() / (float) previewWidth;
                heightScaleFactor = (float) canvas.getHeight() / (float) previewHeight;
            }

            for (Graphic graphic : graphics) {
                graphic.draw(canvas);
            }
        }
    }

//  /**
//   * Sets the aspect ratio for this view. The size of the view will be measured based on the ratio
//   * calculated from the parameters. Note that the actual sizes of parameters don't matter, that
//   * is, calling setAspectRatio(2, 3) and setAspectRatio(4, 6) make the same result.
//   *
//   * @param width  Relative horizontal size
//   * @param height Relative vertical size
//   */
//  public void setAspectRatio(int width, int height) {
//    if (width < 0 || height < 0) {
//      throw new IllegalArgumentException("Size cannot be negative.");
//    }
//    mRatioWidth = width;
//    mRatioHeight = height;
//    requestLayout();
//  }
//
//  @Override
//  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//    int width = MeasureSpec.getSize(widthMeasureSpec);
//    int height = MeasureSpec.getSize(heightMeasureSpec);
//    if (0 == mRatioWidth || 0 == mRatioHeight) {
//      setMeasuredDimension(width, height);
//    } else {
//      if (width < height * mRatioWidth / mRatioHeight) {
//        setMeasuredDimension(width, width * mRatioHeight / mRatioWidth);
//      } else {
//        setMeasuredDimension(height * mRatioWidth / mRatioHeight, height);
//      }
//    }
//  }
}
