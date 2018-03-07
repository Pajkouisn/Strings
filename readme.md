# String Operations and Validation

## Some simple operations on Strings

### Functions included:

* nthTokenAfterSplit(String text, String regex, int element)

```
	Gets the nth element after the occurance of the regex.
    EXAMPLE:
    	nthTokenAfterSplit("A/B/C/D", "/", 1) will return B. 
```

* tokenize(String text, String regex)

```
	Gets a list of tokens split after every "regex".
    EXAMPLE:
    	tokenize("A/B/C/D", "/") will return a list of [A,B,C,D]
```
* concatenateTokens(List<String> tokens, String seperator, int...fromTo)

```
	Merges 	items in the list based on the seperator. Decides range of items from list to use dynamically.
    EXAMPLE:
    	concatenateTokens([A,B,C,D], "/", 1,3) will return B/C.
```
* isInteger(String string)

```
	Checks whether the given string is an integer or not.
    EXAMPLE:
    	isInteger("25") returns true. 
        isInteger("25n") returns false. 
```