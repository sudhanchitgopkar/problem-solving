class Solution {
    public String discountPrices(String sentence, int discount) {
        String [] words = sentence.split(" ");
        List<Integer> priceidx = new LinkedList <> ();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            boolean valid = true;

            if (word.charAt(0) != '$' || word.length() < 2) {
                valid = false;
            } //if

            for (int j = 1; j < word.length() && valid; j++) {
                if (!Character.isDigit(word.charAt(j))) {
                    valid = false;
                    break;
                } //if
            } //for

            if (valid) priceidx.add(i);
        } //for

        for (int idx : priceidx) {
            double price = Double.parseDouble(words[idx].substring(1));
            price *= (100d - discount)/100;
            words[idx] = "$" + String.format("%.2f", price);
        } //for

        for (String word : words) {
            sb.append(word).append(" ");
        } //for

        String sol = sb.toString();
        return sb.substring(0, sol.length() - 1);
    } //discountPrices
} //Sol