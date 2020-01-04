/* Given an array of characters compress them and return the String
  i/p: ["a","a","b","b","c","c"] o/p: ["a","2","b","2","c","2"]
  i/p: ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
  o/p: ["a","b","1","2"]
*/

/*
  * Solution Intution: We have 2 pointers one for reading,writing and anchoring
  * Read pointers traverses till adjacent characters are equal
  * write pointer is used to replace characters
  * anchor is used to to specify which character to write
*/

class Solution{
  public int compress(chars[] chars){
    int read = 0,write = 0,anchor = 0;
    int n = chars.length;

    while(read < n){
      //read + 1 condition is important ccc at the end will never encounter a change of
      // character, therefore when read+1 == len reaplce the chars[write+1] with length of
      // the last character.
      if(chars[read+1] != chars[read]){
        chars[write] = chars[anchor];
        write++;

        if(read > anchor){
          String temp = (read-anchor+1).toCharArray() + "";
          for(char c : temp){
            chars[write] = c;
            write++;
          }
        }
    }
    anchor = read+1;
  }
}
