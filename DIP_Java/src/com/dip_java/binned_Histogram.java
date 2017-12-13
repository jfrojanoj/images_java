package com.dip_java;
import ij.plugin.plugInFilter;
import ij.ImagePlus;
import ij.process.ImageProcessor;
import ij.IJ;

public class binned_Histogram implements plugInFilter {

    public int setup(String arg, ImagePlus im) {
        return DOES_8G + NO_CHANGES;
    }

    private int [] binned_Histogram(ImageProcessor ip) {
        int K = 256; // number of intensity values
        int B = 32; // size of histogram, must be defined

        int [] hist =  new int[B];
        int w = ip.getWidth();
        int h = ip.getHeight();

        for (int v = 0; v < h; v++) {
            for (int u = 0; u < w; u++) {
                int a = ip.getPixel(u, v);
                int i = a * B / K;

                hist[i] = hist[i] + 1;
            }
        }

        return hist;
    }

    public void run(ImageProcessor ip) {

    }
}
