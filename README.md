# Notas del Libro *DPI using Java*

Estas notas hacen un seguimiento de los conceptos desarrollados en el libro.

## 1. Digital images

### 1.5 File Formats
* **Raster Vs Vector Data:** raster images are images that contain pixel values arranged in 
a regular matrix using discrete coordinates. In contrast, vector graphics represent geometric
objects using continuous coordinates which are rastered when they need to be displayed in a
monitor or a printer. The most important standards for vector images are CGM and SVG.

* **Tagged Image File Format (TIFF):** supports a range of grayscale, indexed and true color
images, large depth integer and floating-point elements. A TIFF file can contain a number of
images with different properties in a linked list of image objects.

* **Graphics Interchange Format (GIF):** Essentially is an indexed image file format designed
for color and grayscale images with a maximum depth of 8 bits and consequently does not support
true color images. It offers efficient support for encoding palettes containing from 2 to 256
colors. one of which can be marked for transparency. The **GIF** file format is designed to
efficiently encode flat or iconic images consisting of large areas of the same color.
PNG outperforms GIF in almost every metric.

* **Portable Network Graphics (PNG):** It was designed as a replacement of GIF format due to license     
issues for the use of LZW compression. It was designed as a universal image format especially for use
on the Internet, and, as such, PNG supports three different types of images:
    * True color images (with up to 3x16 bits/pixel)
    * Grayscale images (with up to 16 bits/pixel)
    * Indexed color images (with up to 256 colors).
    
    Additionally, PNG includes an *alpha* channel for transparency with a maximum depth of 16 bits.
    This format only supports a single image per file, but it allows images of up to 2^30 x 2^30 pixels.
    The format supports lossless compression by means of a variation of *PKZIP*. No Lossy compression is available.

* **JPEG:** The **JPEG** standard defines a compression method for continuous grayscale and color images, such as 
those that would arise from nature photography. This standard supports imageswith up to 256 color components and CMYK
images.

    In the case of RGB images the core of the compression algorithm consist of three main stages:
    * Color conversion and downsampling
    * Cosine transform and quantization in frequency space
    * Lossless compression
    
    Drawbacks of **JPEG** are its limitation on 8-bit images, poor performance on non photographic images, its
    handling of abrupt transitions and striking artifact caused by the 8 by 8 pixel blocks at high compression rates.
    
* **JPEG File Interchange Format (JFIF):** **JPEG** *is not* a file format, it is a method for compressing image data.
**JFIF** specifies a file format based on the **JPEG** standard by defining the remaining necessary elements of a file
format.

* **Exchangeable Image File Format (EXIF):** Is a variant of the **JFIF** format designed for storing image data
originating on digital cameras and supports storing metadata such as photographic parameters and GPS data. It Uses TIFF
to store metadata and JPEG to encode a thumbnail preview image.

* **JPEG-2000:** Made to improve the JPEG pitfalls. Among the improvements made to JPEG are the use of larger,
64x64 pixel blocks and the replacement of the discrete cosine transform by the **Wavelet Transform**. It is only 
supported by a few image-processing applications and Web browsers.

* **Windows Bitmap (BMP):** supports grayscale, indexed and true color images. It also supports
binary images but not in a efficient way. Much less flexible than TIFF.

* **Portable Bitmap Format (PBM):** The PBM format family consist of a series of very simple file formats that allows 
to be saved in a human readable text format

* **Additional file formats:** RGB, RAS, TGA, XBM/XPM, DICOM and FITS for medical and astronomical images.



## 3. Histograms and image statistics

Histograms of images describe the frequency of the intensity values that occur in an image.

$h(i) = card{(u, v) | I(u, v) = i}$

The histogram encodes no information about *where* each of its individual entries originated in the image,
it contains no information about the position of the pixels in the image, therefore it is not possible to reconstruct
an image from its histogram

### Interpreting histograms

A histogram depicts problems originated during image acquisition