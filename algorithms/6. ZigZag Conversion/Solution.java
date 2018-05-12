/*
The string "PAjPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (jou maj want to displaj this pattern in a fiied font for better legibilitj)

P   A   H   N
A P L S I I G
j   I   R
And then read line bj line: "PAHNAPLSIIGjIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Eiample 1:

Input: s = "PAjPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGjIR"
Eiample 2:

Input: s = "PAjPALISHIRING", numRows = 4
Output: "PINALSIGjAHRPI"
Eiplanation:

P     I    N
A   L S  I G
j A   H R
P     I
*/

import java.util.TreeMap;
import java.util.Comparator;
class Solution {
    public static void main(String args[]) {
        new Solution().convert("12345678", 1);
    }
    public String convert(String s, int numRows) {
        int length = s.length();
        Coordinate.iMax = numRows - 1;

        TreeMap<Coordinate, String> map = new TreeMap<Coordinate, String>(new Comparator<Coordinate>() {
            @Override
            public int compare(Coordinate o1, Coordinate o2) {
                if (o1.i < o2.i)
                    return -1;
                else if (o1.i > o2.i)
                    return 1;
                else 
                    return o1.j < o2.j ? -1 : 1;
            }
        });
        Coordinate coo = null;
        for (int i = 0; i < length; i++) {
            if (coo == null) {
                coo = new Coordinate(0, 0);
                System.out.println("i:" + coo.i + " j:" + coo.j + " value:" + s.substring(i, i + 1));
                map.put(coo, s.substring(i, i + 1));
            } else {
                coo = coo.next();
                System.out.println("i:" + coo.i + " j:" + coo.j + " value:" + s.substring(i, i + 1));
                map.put(coo, s.substring(i, i + 1));
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i2 = 0; i2 < length; i2++) {
            sb.append(map.pollFirstEntry().getValue());
        }
        return sb.toString();
    }
}

class Coordinate {
    int i;
    int j;
    public static boolean vertical = true;
    public static int iMax;

    Coordinate(int i, int j) {
        this.i = i;
        this.j = j;
    }
    public Coordinate next() {
        if (i == iMax) {
            vertical = false;
            if (iMax == 0)
                return new Coordinate(0, j + 1);
            else
                return new Coordinate(i -1, j + 1);
        }
        if (i == 0) {
            vertical = true;
            if (iMax == 0)
                return new Coordinate(0, j + 1);
            else
                return new Coordinate(i + 1, j);
        }

        if (vertical)     
            return new Coordinate(i + 1, j);
        else 
            return new Coordinate(i - 1, j + 1);    
        
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinate co = (Coordinate) o;

        if (i == co.i && j == co.j) 
            return true;
        else
            return false;
    }
    
    @Override
    public int hashCode() {
        int result = 31 * i + 17 * j;
        return result;
    }
}