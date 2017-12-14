package com.dip_java;
import ij.plugin.plugInFilter;
import ij.ImagePlus;
import ij.process.ImageProcessor;
import ij.IJ;

public class point_oper_contrast_bright implements plugInFilter {

    public int setup(String arg, ImagePlus im) {
        return DOES_8G + NO_CHANGES;
    }

    public void run(ImageProcessor ip) {
        int w = ip.getWidht();
        int h = ip.getHeight();

        for (int v = 0; v < h; v++) {
            for (int u = 0; u < w; u++) {
                int a = ip.get(u, v);
                int b = (int) (a * 1.5 + 0.5); // the 0.5 is to round to the nearest integer

                if (b > 255) {
                    b = 255; // clamp to the maximum value (a_max)
                }
                ip.set(u, v, b);
            }
        }
    }
}
