public class Kata {
    public static String longToIP(long ip) {
        String binary = Long.toBinaryString(ip);
        String[] binarySections = new String[4];
        binary = String.format("%32s", binary).replaceAll(" ", "0");
        for (int i = 0; i < binarySections.length; i++)
            binarySections[i] = binary.substring(8*i, 8*i+8);
        long[] decimalsections = new long[4];
        for (int i = 0; i < decimalsections.length; i++)
            decimalsections[i] = Long.parseLong(binarySections[i], 2);
        String ipV4 = String.format("%d.%d.%d.%d",
                decimalsections[0], decimalsections[1], decimalsections[2], decimalsections[3]);
        return ipV4; // do it!
    }
}