
import json

# Open the file in read mode
text = open("README.md", "r")

# Create an empty dictionary
d = dict()

requiredWords = ["kata","circleci","demo","always","going","positive"]

# Loop through each line of the file
for line in text:
    # Remove the leading spaces and newline character
    line = line.strip()

    # Convert the characters in line to
    # lowercase to avoid case mismatch
    line = line.lower()

    # Split the line into words
    words = line.split(" ")

    # Iterate over each word in line
    for word in words:
        if word in requiredWords:
            # Check if the word is already in dictionary
            if word in d:
                # Increment count of word by 1
                d[word] = d[word] + 1
            else:
                # Add the word to dictionary with count 1
                d[word] = 1

# Print the contents of dictionary
for key in list(d.keys()):
    print(key, ":", d[key])

json = json.dumps(d)
f = open("wordCount.json","w")
f.write(json)
f.close()