/* 🧠 Why this works (in one paragraph)

1. We read characters in groups
2. Count how many times they repeat consecutively
3. Immediately write the compressed form back into the same array
4. write always points to the next free slot
5. Multi-digit counts (12, 100) are handled safely

🚨 Key interview takeaway (lock this in)
If order + adjacency matter → never use a Map
Use:
    Two pointers
    One pass
    In-place writing */



class Solution {
    public int compress(char[] chars) {
        int read = 0;
        int write = 0;

        while(read < chars.length) {
            char curr = chars[read];
            int count = 0;

            while(read < chars.length && chars[read] == curr) {
                read++; //incrementing for checking adjacently
                count++; //each adjacently same ones
            }
            
            chars[write++] = curr; //compressing and writing curr as one char;

            if(count >1) {
                for(char ch : String.valueOf(count).toCharArray()) {
                    chars[write++] = ch; //writing count only when character appears more than 1 time;
                }
            }
        }

        return write;
        
    }
}

/*
🚨 Interview warning (remember this forever)

If the problem says “modify the array in-place”
❌ Map
❌ Extra arrays
✅ Two pointers */







/* 
Let’s expose the flaw with ONE example
Input::
[a, a, b, a, a]

Your Map approach gives:
a → 4
b → 1

But correct compression must be:
a2 b1 a2

👉 Same character a appears in multiple groups
👉 A Map cannot represent this */

//Map destroys order so 


/* Final mindset checkpoint ✅

If a problem says:
“in-place”
“modify the array”
“preserve order”

Your instinct should be:
Two pointers, not Map */