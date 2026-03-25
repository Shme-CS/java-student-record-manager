#!/bin/bash

echo "Compiling Java Student Record Manager..."
javac src/*.java

if [ $? -eq 0 ]; then
    echo "Compilation successful!"
    echo
    echo "Starting Student Record Management System..."
    echo
    java -cp src Main
else
    echo "Compilation failed!"
    exit 1
fi