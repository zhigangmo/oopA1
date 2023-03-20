
#!/bin/bash

# Compile Java files
javac -g TutorApp.java Student.java Tutor.java TutorManager.java

# Check if compilation was successful
if [ $? -eq 0 ]; then
    # Run the TutorApp with input.txt as a command line argument
    java TutorApp input.txt
    #jdb TutorApp input.txt
else
    echo "Compilation failed. Please fix the errors and try again."
fi
