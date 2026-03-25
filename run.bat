@echo off
echo Compiling Java Student Record Manager...
javac src/*.java

if %errorlevel% equ 0 (
    echo Compilation successful!
    echo.
    echo Starting Student Record Management System...
    echo.
    java -cp src Main
) else (
    echo Compilation failed!
    pause
)