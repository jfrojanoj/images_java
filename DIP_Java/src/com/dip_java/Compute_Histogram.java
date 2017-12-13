package com.dip_java;
import ij.plugin.plugInFilter;
import ij.ImagePlus;
import ij.process.ImageProcessor;
import ij.IJ;

public class Compute_Histogram implements PlugInFilter {

    public int setup(String arg, ImagePlus im) {
        return DOES_8G + NO_CHANGES;
    }

    public void run(ImageProcessor ip) {
        int [] hist = new int[256];
        int w = ip.getWidth();
        int h = ip.getHeight();

        for (int v = 0; v < h; v++) {
            for (int u = 0; u < w; u++) {
                int i = ip.getPixel(u, v);
                hist[i] = hist[i] + 1;
            }
        }

        // Here we can use the histogram
    }
}
