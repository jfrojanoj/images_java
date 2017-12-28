package com.dip_java;
import ij.plugin.plugInFilter;
import ij.ImagePlus;
import ij.process.ImageProcessor;
import ij.IJ;

public class point_oper_lin_hist_equalization {
    public void run(ImageProcessor ip) {
        int M = ip.getWidth();
        int N = ip.getHeight();
        int K = 256;  // number of intensity values

        // compute the cumulative histogram
        int [] H =  ip.getHistogram();
        for (int j = 1; j < H.length; j++) {
            H[j] = H[j - 1] + H[j];
        }

        // equalize the image:
        for (int v = 0; v < N; v++) {
            for (int u = 0; u < M; u++) {
                int a = ip.get(u, v);
                int b = H[a] * (K - 1) / (M * N); // eq 4.12

                ip.set(u, v, b);
            }
        }
    }
}
