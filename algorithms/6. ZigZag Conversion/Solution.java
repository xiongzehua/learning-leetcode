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

import java.util.*;
class Solution {
    public String convert(String s, int numRows) {
        int length = s.length();
        Coordinate.numRows = numRows - 1;

        Map<Coordinate, String> map = new <Coordinate, String>HashMap();
        Coordinate coo = null;
        for (int i = 0; i < length; i++) {
            if (coo == null) {
                coo = new Coordinate(0, 0);
                map.put(coo, s.substring(i, i + 1));
            } else {
                coo = coo.next();
                map.put(coo, s.substring(i, i + 1));
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            
        }
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
            return new Coordinate(i-1, j+1);
        }
  
        if (i == 0) {
            vertical = true;
            return new Coordinate(i, j+1);
        }

        if (vertical)     
            return new Coordinate(i, j+1);
        else 
            return new Coordinate(i-1, j+1);    
        
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