//package cillexia.CIM;

import java.text.DecimalFormat;

/**
* CIM (Cillexia Math Library): A cillexia project by Christian Bietsch
* Website: www.cillexia.net
*/
public final class CIM {
  // ========== PI ==========
  public static final double PI = 3.14159265359;
  public static final float pi = (float)PI;
  public static final double TWO_PI = PI*2;
  public static final float two_pi = (float)TWO_PI;
  
  // ========== Golden Ratio ==========
  public static final double GOLDEN_RATIO = 1.61803398875;
  public static final float golden_ratio = (float)GOLDEN_RATIO;
  
  // ========== min functions ==========
  public static final double min(double v1, double v2) { return v1 < v2 ? v1 : v2; }
  public static final float min(float v1, float v2) { return v1 < v2 ? v1 : v2; }
  public static final long min(long v1, long v2) { return v1 < v2 ? v1 : v2; }
  public static final int min(int v1, int v2) { return v1 < v2 ? v1 : v2; }
  
  // ========== max functions ==========
  public static final double max(double v1, double v2) { return v1 < v2 ? v2 : v1; }
  public static final float max(float v1, float v2) { return v1 < v2 ? v2 : v1; }
  public static final long max(long v1, long v2) { return v1 < v2 ? v2 : v1; }
  public static final int max(int v1, int v2) { return v1 < v2 ? v2 : v1; }
  
  // ========== abs functions ==========
  public static final double abs(double v) { return v < 0 ? -v : v; }
  public static final float abs(float v) { return v < 0 ? -v : v; }
  public static final long abs(long v) { return v < 0 ? -v : v; }
  public static final int abs(int v) { return v < 0 ? -v : v; }
  
  // ========== floor functions ==========
  public static final double floor(double v) { return v < 0 ? (int)v-1 : (int)v; }
  public static final float floor(float v) { return v < 0 ? (int)v-1 : (int)v; }
  
  // ========== ceil functions ==========
  public static final double ceil(double v) { return v < 0 ? (int)v : (int)v+1; }
  public static final float ceil(float v) { return v < 0 ? (int)v : (int)v+1; }
  
  // ========== round functions ==========
  /** Rounds value to specified decimal format. Pass "00.00" for exact amount of digits, or use "##.##" to cut off unnecessary zeros. */
  public static final String round(DecimalFormat decimalFormat, double v) { return decimalFormat.format(v).toString(); }
  public static final String round(String decimalFormat, double v) { return round(new DecimalFormat(decimalFormat), v); }
  public static final double round(double v, String decimalFormat) { return Double.parseDouble(round(decimalFormat, v)); }
  public static final float round(float v, String decimalFormat) { return Float.parseFloat(round(decimalFormat, v)); }
  public static final double round(double v) { return floor(v + 0.5); }
  public static final float round(float v) { return floor(v + 0.5f); }
  
  // ========== sqrt functions ==========
  public static final double sqrt(double v) { return Math.sqrt(v); }
  public static final float sqrt(float v) { return (float)Math.sqrt(v); }
  
  // ========== pow functions ==========
  public static final double pow(double v, double pow) { return Math.pow(v, pow); }
  public static final float pow(float v, float pow) { return (float)Math.pow(v, pow); }
  
  // ========== lerp functions ==========
  public static final double lerp(double t, double v0, double v1) { return (1.0f - t) * v0 + t * v1; }
  public static final float lerp(float t, float v0, float v1) { return (1.0f - t) * v0 + t * v1; }
  
  // ========== ratio functions MAX:MIN [0.0...1.0] ==========
  public static final double ratio(double min, double max) { return 1.0/CIM.abs(max-min); }
  public static final float ratio(float min, float max) { return 1.0f/CIM.abs(max-min); }
  
  // ========== ratio functions VALUE between MIN and MAX [0.0...1.0] ==========
  public static final double ratio(double value, double min, double max) { return min < max ? (value - min) / (max - min) : (value - max) / (min - max); }
  public static final float ratio(float value, float min, float max) { return min < max ? (value - min) / (max - min) : (value - max) / (min - max); }
  
  // ========== ratio functions VALUE between MIN and MAX [0.0...1.0] FAST VERSION with PRECALCULATED RATIO ==========
  public static final double ratio(double value, double min, double max, double minMaxRatio) { return min < max ? (value - min) * minMaxRatio : (value - max) * minMaxRatio; }
  public static final float ratio(float value, float min, float max, float minMaxRatio) { return min < max ? (value - min) * minMaxRatio : (value - max) * minMaxRatio; }
  
  // ========== map functions ==========
  public static final double map(double t, double tMin, double tMax, double map1, double map2) { return lerp(ratio(t, tMin, tMax), map1, map2); }
  public static final float map(float t, float tMin, float tMax, float map1, float map2) { return lerp(ratio(t, tMin, tMax), map1, map2); }
  
  // ========== clamp functions ==========
  public static final double clamp(double value, double min, double max) { return min < max ? (value < min ? min : value > max ? max : value) : (value > min ? min : value < max ? max : value); }
  public static final float clamp(float value, float min, float max) { return min < max ? (value < min ? min : value > max ? max : value) : (value > min ? min : value < max ? max : value); }
  public static final long clamp(long value, long min, long max) { return min < max ? (value < min ? min : value > max ? max : value) : (value > min ? min : value < max ? max : value); }
  public static final int clamp(int value, int min, int max) { return min < max ? (value < min ? min : value > max ? max : value) : (value > min ? min : value < max ? max : value); }
  
  // ========== cycle functions ==========
  public static final double cycle(double value, double min, double max) { return min < max ? (value < min ? max : value > max ? min : value) : (value < max ? min : value > min ? max : value); }
  public static final float cycle(float value, float min, float max) { return min < max ? (value < min ? max : value > max ? min : value) : (value < max ? min : value > min ? max : value); }
  public static final long cycle(long value, long min, long max) { return min < max ? (value < min ? max : value > max ? min : value) : (value < max ? min : value > min ? max : value); }
  public static final int cycle(int value, int min, int max) { return min < max ? (value < min ? max : value > max ? min : value) : (value < max ? min : value > min ? max : value); }
  
  // ========== distance functions ==========
    /** Euclidean:
  * input xy [-1.0;1.0]
  * output [0.0;1.0] */
  public static final double euclidean(double x, double y) { return 1.0 - CIM.min(CIM.sqrt(x*x + y*y), 1.0); }
  /** Euclidean:
  * input xy [-1.0;1.0]
  * output [0.0;1.0] */
  public static final float euclidean(float x, float y) { return 1.0f - CIM.min(CIM.sqrt(x*x + y*y), 1.0f); }
  /** Diagonal:
  * input xy [-1.0;1.0]
  * output [0.0;1.0] */
  public static final double diagonal(double x, double y) { return 1.0 - CIM.max(CIM.abs(x), CIM.abs(y)); }
  /** Diagonal:
  * input xy [-1.0;1.0]
  * output [0.0;1.0] */
  public static final float diagonal(float x, float y) { return 1.0f - CIM.max(CIM.abs(x), CIM.abs(y)); }
  /** Manhattan:
  * input xy [-1.0;1.0]
  * output [0.0;1.0] */
  public static final double manhattan(double x, double y) { return 1.0 - CIM.min((CIM.abs(x) + CIM.abs(y)), 1.0); }
  /** Manhattan:
  * input xy [-1.0;1.0]
  * output [0.0;1.0] */
  public static final float manhattan(float x, float y) { return 1.0f - CIM.min((CIM.abs(x) + CIM.abs(y)), 1.0f); }
  /** Squarebump:
  * input xy [-1.0;1.0]
  * output [0.0;1.0] */
  public static final double squarebump(double x, double y) { return (1.0-x*x)*(1.0-y*y);  }
  /** Squarebump:
  * input xy [-1.0;1.0]
  * output [0.0;1.0] */
  public static final float squarebump(float x, float y) { return (1.0f-x*x)*(1.0f-y*y);  }
  /** Squared:
  * input xy [-1.0;1.0]
  * output [0.0;1.0] */
  public static final double squared(double x, double y) { return 1.0 - CIM.min((x*x + y*y), 1.0); }
  /** Squared:
  * input xy [-1.0;1.0]
  * output [0.0;1.0] */
  public static final float squared(float x, float y) { return 1.0f - CIM.min((x*x + y*y), 1.0f); }
  /** Squircle:
  * input xy [-1.0;1.0]
  * output [0.0;1.0] */
  public static final double squircle(double x, double y) { return 1.0 - CIM.min(CIM.sqrt(x*x*x*x + y*y*y*y), 1.0); }
  /** Squircle:
  * input xy [-1.0;1.0]
  * output [0.0;1.0] */
  public static final float squircle(float x, float y) { return 1.0f - CIM.min(CIM.sqrt(x*x*x*x + y*y*y*y), 1.0f); }
  
  // ========== link functions ==========
  public static final double[] link(double[] a, double... b) {
    if (a == null) { return b.clone(); }
    final double[] result = new double[a.length + b.length];
    for(int i = 0; i < a.length; i++) result[i] = a[i];
    int c = a.length;
    for(int i = 0; i < b.length; i++) result[c++] = b[i];
    return result;
  }
  public static final float[] link(float[] a, float... b) {
    if (a == null) { return b.clone(); }
    final float[] result = new float[a.length + b.length];
    for(int i = 0; i < a.length; i++) result[i] = a[i];
    int c = a.length;
    for(int i = 0; i < b.length; i++) result[c++] = b[i];
    return result;
  }
  public static final long[] link(long[] a, long... b) {
    if (a == null) { return b.clone(); }
    final long[] result = new long[a.length + b.length];
    for(int i = 0; i < a.length; i++) result[i] = a[i];
    int c = a.length;
    for(int i = 0; i < b.length; i++) result[c++] = b[i];
    return result;
  }
  public static final int[] link(int[] a, int... b) {
    if (a == null) { return b.clone(); }
    final int[] result = new int[a.length + b.length];
    for(int i = 0; i < a.length; i++) result[i] = a[i];
    int c = a.length;
    for(int i = 0; i < b.length; i++) result[c++] = b[i];
    return result;
  }
  public static final short[] link(short[] a, short... b) {
    if (a == null) { return b.clone(); }
    final short[] result = new short[a.length + b.length];
    for(int i = 0; i < a.length; i++) result[i] = a[i];
    int c = a.length;
    for(int i = 0; i < b.length; i++) result[c++] = b[i];
    return result;
  }
  public static final byte[] link(byte[] a, byte... b) {
    if (a == null) { return b.clone(); }
    final byte[] result = new byte[a.length + b.length];
    for(int i = 0; i < a.length; i++) result[i] = a[i];
    int c = a.length;
    for(int i = 0; i < b.length; i++) result[c++] = b[i];
    return result;
  }
  public static final String[] link(String[] a, String... b) {
    if (a == null) { return b.clone(); }
    final String[] result = new String[a.length + b.length];
    for(int i = 0; i < a.length; i++) result[i] = a[i];
    int c = a.length;
    for(int i = 0; i < b.length; i++) result[c++] = b[i];
    return result;
  }
  public static final char[] link(char[] a, char... b) {
    if (a == null) { return b.clone(); }
    final char[] result = new char[a.length + b.length];
    for(int i = 0; i < a.length; i++) result[i] = a[i];
    int c = a.length;
    for(int i = 0; i < b.length; i++) result[c++] = b[i];
    return result;
  }
}
