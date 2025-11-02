class day63 {
    public static int longestChar(String s, int k) {
        int left = 0;
        int maxLen = 0;
        int n = s.length();

        for(int right = 0; right<n; right++) {
            if(s.charAt(left) != s.charAt(right)) {
                k--;
            }

            while(k<0) {
                if(s.charAt(left) == s.charAt(right)) {
                    k++;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right-left+1);
        }

        return maxLen;
    }
}

class dayZ {
    public static int longestChar(String s, int k) {
        int left = 0;
        int maxLen = 0;
        int n = s.length();
        int maxFreq = 0;
        int freq[] = new int[26];

        for(int right = 0; right<n; right++) {
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            int windowSize = right - left+1;
            int neededCollections = windowSize - maxFreq;

            while(neededCollections > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
                windowSize = right - left+1;
                neededCollections = windowSize - maxFreq;
            }

            maxLen = Math.max(maxLen, windowSize);
        }

        return maxLen;
    }
}

//why k<0 because when k becomes too many negatives

//and why this code wont work 
//this code relies on it being the string fully  single characters like A or B ABAAB
//if theres like ABABABCCCH another character then this code wont work

//handle the frequency of this
//Your version compares s.charAt(left) with s.charAt(right):
/* 
if (s.charAt(left) != s.charAt(right)) k--;
That means:
You’re only checking whether the window matches the first character in it. */
/* 
















🧠 Imagine this:

You’re looking at a string:

A A B A B B A


and k = 1.

That means you can change 1 letter to make all the letters in some substring the same.
Your goal: find the longest possible substring where that’s doable.

🪄 Step 1: The idea behind the algorithm

You slide a window (like a magnifying glass) across the string and ask:

“Can I make everything in this window the same by changing at most k letters?”

If yes — expand the window.
If no — shrink it.

🧱 Example: "AABABBA", k = 1
Window	Changes Needed	Valid?	Explanation
A	0	✅	just "A"
AA	0	✅	all A’s
AAB	1	✅	change B → A
AABA	1	✅	one B → A
AABAB	2	❌	need to change 2 B’s → too many
(shrink window from left) → ABAB	2	❌	still 2
(shrink again) → BAB	1	✅	one A → B

✅ The longest valid window seen = 4 characters (AABA).

⚙️ How the program does that

It keeps:

maxFreq = number of times the most common letter appears in your current window

windowSize = right - left + 1

replacementsNeeded = windowSize - maxFreq

If replacementsNeeded > k, it means “too many letters to fix,”
so you move left++ (shrink window).

💬 In simple words:

Think of it like painting:

You’re painting letters so they all match.

maxFreq = the color that already dominates.

You only have k paint cans for others.

If you need more paint cans → slide the window smaller.

❤️ The key mindset shift

Stop trying to track left and right with rules.
Instead, always ask yourself:

“Is my current window valid?
If yes → expand.
If no → shrink.”

That’s it.
The code is just implementing that rule mechanically. */