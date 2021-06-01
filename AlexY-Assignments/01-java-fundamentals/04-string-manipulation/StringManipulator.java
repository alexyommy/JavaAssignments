public class StringManipulator {
    public String trimAndConcat(String word1, String word2){
        return word1.trim().concat(word2.trim());
    }
    public Integer getIndexOrNull(String word, char o){
        return word.indexOf(o);
    }
    public Integer getIndexOrNull(String word, String subString){
        return word.indexOf(subString);
    }
    public String concatSubstring(String input, int idxA, int idxB, String replacement) {
        String substr;
        try{
            substr = input.substring(idxA, idxB);
        } catch(IndexOutOfBoundsException e) {
            System.out.println(String.format("Exception caught: %s", e));
            substr = "yikes!";
        }
        return substr.concat(replacement);
    }
}













